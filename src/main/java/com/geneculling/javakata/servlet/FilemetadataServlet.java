package com.geneculling.javakata.servlet;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.templaterenderer.TemplateRenderer;
import com.google.gson.JsonElement;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import static com.geneculling.javakata.api.FileMetadataUtil.formatFilesMetadata;
import static com.geneculling.javakata.api.FileMetadataUtil.getFilesMetadata;

public class FilemetadataServlet extends HttpServlet {
    private static final boolean WRITE_TO_FILE = false;
    private final TemplateRenderer renderer;

    @Autowired
    public FilemetadataServlet(@ComponentImport TemplateRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Map<String, Object> map = new HashMap<>();

        renderer.render("templates/filemetadata.vm", map, response.getWriter());
        response.flushBuffer();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<JsonElement> jsonElements = new ArrayList<>();

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(request);
            jsonElements = getFilesMetadata(items);
            writeFiles(items);
        } catch (FileUploadException e) {
            throw new RuntimeException("FileUploadException: ", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String formattedJsonElements = formatFilesMetadata(jsonElements);

        response.setContentType("application/json");
        response.getWriter().write(formattedJsonElements);
        response.flushBuffer();
    }

    public void writeFiles(List<FileItem> fileItems) throws Exception {
        if (! WRITE_TO_FILE) {
            return;
        }
        Iterator<FileItem> fileItemIterator = fileItems.iterator();
        while (fileItemIterator.hasNext()) {
            FileItem fileItem = fileItemIterator.next();
            String fileName = fileItem.getName();
            File uploadedFile = new File(fileName);
            fileItem.write(uploadedFile);
        }
    }

}

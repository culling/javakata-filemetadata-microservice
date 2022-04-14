package com.geneculling.javakata.servlet;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.templaterenderer.TemplateRenderer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import java.io.StringWriter;

public class FilemetadataServlet extends HttpServlet {

     private final TemplateRenderer renderer;

    @Autowired
    public FilemetadataServlet(@ComponentImport TemplateRenderer renderer){
        this.renderer = renderer;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        renderer.render("templates/hello.vm", map, response.getWriter());
    }

}

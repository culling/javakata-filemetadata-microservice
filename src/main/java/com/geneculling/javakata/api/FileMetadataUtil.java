package com.geneculling.javakata.api;

import com.geneculling.javakata.pojo.FileMetadataBuilder;
import com.google.gson.JsonElement;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface FileMetadataUtil {
    static String formatFilesMetadata(List<JsonElement> jsonElements) throws IOException {
        Writer writer = new StringWriter();
        if(jsonElements.size() > 1){
            writer.write("[");
        }
        for(JsonElement jsonElement : jsonElements){
            writer.write(jsonElement.toString());
        }
        if(jsonElements.size() > 1){
            writer.write("]");
        }
        return writer.toString();
    }

    static List<JsonElement> getFilesMetadata(List<FileItem> fileItems){
        List<JsonElement> jsonElements = new ArrayList<>();
        Iterator<FileItem> fileItemIterator = fileItems.iterator();
        while (fileItemIterator.hasNext()) {
            FileItem fileItem = fileItemIterator.next();
            jsonElements.add(
                    new FileMetadataBuilder()
                            .fileName(fileItem.getName())
                            .contentType(fileItem.getContentType())
                            .sizeInBytes(fileItem.getSize())
                            .getJson()
            );
        }
        return jsonElements;
    }

}

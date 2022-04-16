package com.geneculling.javakata.pojo;

import com.geneculling.javakata.api.Jsonable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class FileMetadataBuilder implements Jsonable {
    private static final Gson GSON = new Gson();
    private String fileName;
    private String contentType;
    private long sizeInBytes;

    public FileMetadataBuilder(){
    }

    public FileMetadataBuilder(String fileName, String contentType, long sizeInBytes){
        this.fileName = fileName;
        this.contentType = contentType;
        this.sizeInBytes = sizeInBytes;
    }

    public FileMetadataBuilder fileName(String fileName){
        return new FileMetadataBuilder(fileName, this.contentType, this.sizeInBytes);
    }

    public FileMetadataBuilder contentType(String contentType){
        return new FileMetadataBuilder(this.fileName, contentType, this.sizeInBytes);
    }

    public FileMetadataBuilder sizeInBytes(long sizeInBytes){
        return new FileMetadataBuilder(this.fileName, this.contentType, sizeInBytes);
    }

    @Override
    public JsonElement getJson() {
        return GSON.toJsonTree(this, this.getClass());
    }


}

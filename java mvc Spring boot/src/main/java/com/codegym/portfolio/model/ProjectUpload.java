package com.codegym.portfolio.model;

import org.springframework.web.multipart.MultipartFile;

public class ProjectUpload extends Project {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}

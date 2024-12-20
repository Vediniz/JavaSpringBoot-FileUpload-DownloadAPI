package com.github.vediniz.uploadfileproject.vo;

import java.io.Serializable;

public class UploadFileResponseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileDownlodUri;

    public UploadFileResponseVO() {
    }

    public UploadFileResponseVO(String fileName, String fileDownlodUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownlodUri = fileDownlodUri;
        this.fileType = fileType;
        this.size = size;
    }

    private String fileType;
    private long size;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownlodUri() {
        return fileDownlodUri;
    }

    public void setFileDownlodUri(String fileDownlodUri) {
        this.fileDownlodUri = fileDownlodUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}

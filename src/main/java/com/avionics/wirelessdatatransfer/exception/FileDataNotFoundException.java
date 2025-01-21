package com.avionics.wirelessdatatransfer.exception;

public class FileDataNotFoundException extends RuntimeException {
    public FileDataNotFoundException(String fileDataNotFound) {
        super(fileDataNotFound);
    }
}

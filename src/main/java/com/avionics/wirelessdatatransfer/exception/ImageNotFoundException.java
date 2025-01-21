package com.avionics.wirelessdatatransfer.exception;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(String imageNotFound) {
        super(imageNotFound);
    }
}

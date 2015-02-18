package com.belous.juice;

import com.belous.file.FileUtils;

public class FileJuicerResult implements JuicerResult {

    private String fileName;

    public FileJuicerResult(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(Object out) {
        FileUtils.write(fileName, out);
    }
}

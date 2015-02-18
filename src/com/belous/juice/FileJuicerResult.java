package com.belous.juice;

import com.belous.file.FileUtils;

import java.util.Objects;

/**
 * Created by s.belous on 18.02.15.
 */
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

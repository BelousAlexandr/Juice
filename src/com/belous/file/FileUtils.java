package com.belous.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by s.belous on 18.02.15.
 */
public class FileUtils {

    public static void write(String fileName, Object text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.print(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

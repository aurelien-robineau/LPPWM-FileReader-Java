package com.lpweb.lecteur.TextFileReader;

import com.lpweb.lecteur.FileReader;

public abstract class TextFileReader extends FileReader {
    public TextFileReader(String filePath) throws Exception {
        super(filePath);

        String[] splitedFilePath = filePath.split("\\.");
        String extension = splitedFilePath[splitedFilePath.length - 1];
        if (!extension.equals("txt")) {
            throw new Exception(filePath + " is not a text file.");
        }
    }
}

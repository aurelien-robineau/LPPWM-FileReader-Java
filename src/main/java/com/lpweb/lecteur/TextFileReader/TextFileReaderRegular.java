package com.lpweb.lecteur.TextFileReader;

import java.io.FileInputStream;
import java.io.IOException;

public class TextFileReaderRegular extends TextFileReader {
    public TextFileReaderRegular(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    protected String getFileFromStream(FileInputStream in) throws IOException {
        String streamContent = "";

        int charCode = -1;
        while ((charCode = in.read()) != -1) {
            streamContent += (char) charCode;
        }

        return streamContent;
    }
}

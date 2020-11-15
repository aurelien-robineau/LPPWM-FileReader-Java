package com.lpweb.lecteur.TextFileReader;

import java.io.FileInputStream;
import java.io.IOException;

public class TextFileReaderPalindrome extends TextFileReader {
    public TextFileReaderPalindrome(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    protected String getFileFromStream(FileInputStream in) throws IOException {
        String streamContent = "";

        int charCode = -1;
        while ((charCode = in.read()) != -1) {
            streamContent = (char) charCode + streamContent;
        }

        return streamContent;
    }
}

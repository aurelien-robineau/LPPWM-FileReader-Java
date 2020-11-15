package com.lpweb.lecteur.TextFileReader;

import java.io.FileInputStream;
import java.io.IOException;

public class TextFileReaderReverse extends TextFileReader
{
    public TextFileReaderReverse(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    protected String getFileFromStream(FileInputStream in) throws IOException {
        String streamContent = "";

        int charCode = -1;
        String line = "";
        
        while (true) {
            charCode = in.read();

            // If end of file, append line then stop
            if (charCode == -1) {
                streamContent = line + streamContent;
                break;
            }
            // If end of line, add line to content and reset line
            else if (charCode == 13) {
                streamContent = line + '\n' + streamContent;
                line = "";
            }
            // If not an end of line and not an end of file append char to line
            else {
                char ch = (char) charCode;
                line += ch;
            }
        }

        return streamContent;
    }
}

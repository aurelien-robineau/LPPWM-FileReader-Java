package com.lpweb.lecteur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class FileReader implements Readable {
    protected File file;

    public FileReader(String filePath) {
        this.file = new File(filePath);
    }
    
    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    public String read() {
        FileInputStream in = null;
        String fileContent = null;

        try {
            in = new FileInputStream(this.file);
            fileContent = this.getFileFromStream(in);
            if (in != null) in.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Fichier \"" + this.file + "\" introuvable.");
        }
        catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier \"" + this.file + "\".");
        }

        return fileContent;
    }

    public String diff(FileReader reader) {
        try {
            // Execute diff command
            String command = this.getDiffCommand();
            command += " \"" + this.file.getAbsolutePath() + "\" \"" + reader.file.getAbsolutePath() + "\"";
            Process process = Runtime.getRuntime().exec(command);

            // Saving result as string
            BufferedReader commandReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String result = "";
            String line;
            while ((line = commandReader.readLine()) != null) {
                result += line;
            }
     
            commandReader.close();

            return result;
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    private String getDiffCommand() {
        // Diff command for windows
        if (System.getProperty("os.name").startsWith("Windows")) {
            return "FC";
        }

        // Others
        return "diff";
    }

    protected abstract String getFileFromStream(FileInputStream in) throws IOException;
}

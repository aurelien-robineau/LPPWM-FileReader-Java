package com.lpweb.lecteur;

import com.lpweb.lecteur.TextFileReader.TextFileReaderRegular;
import com.lpweb.lecteur.TextFileReader.TextFileReaderReverse;
import com.lpweb.lecteur.TextFileReader.TextFileReaderPalindrome;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // Création des lecteurs
            FileReader reader = new TextFileReaderRegular("src/main/java/com/lpweb/lecteur/test.txt");
            FileReader readerReverse = new TextFileReaderReverse("src/main/java/com/lpweb/lecteur/test.txt");
            FileReader readerPalindrome = new TextFileReaderPalindrome("src/main/java/com/lpweb/lecteur/test.txt");

            // Affichage des fichiers
            System.out.println(reader.read());
            System.out.println(readerReverse.read());
            System.out.println(readerPalindrome.read());
    
            // Comparaison de fichiers
            FileReader reader2 = new TextFileReaderRegular("src/main/java/com/lpweb/lecteur/test2.txt");
            FileReader reader3 = new TextFileReaderRegular("src/main/java/com/lpweb/lecteur/test3.txt");
    
            System.out.println(reader.diff(reader));
            System.out.println(reader.diff(reader2));
            System.out.println(reader.diff(reader3));
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

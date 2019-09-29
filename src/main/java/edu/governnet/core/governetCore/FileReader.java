package edu.governnet.core.governetCore;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private List<String> fileContentsUnmodified;

    public List<String> processFile(String directoryPath, String fileName){
        readFile(directoryPath, fileName);
        return fileContentsUnmodified;
    }

    private void readFile(String directoryPath, String fileName){
        Path filePath = Paths.get(directoryPath,fileName);
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            fileContentsUnmodified = Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
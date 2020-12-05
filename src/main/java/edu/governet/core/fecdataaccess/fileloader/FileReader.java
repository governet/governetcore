package edu.governet.core.fecdataaccess.fileloader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
        Charset charset = StandardCharsets.ISO_8859_1;
        try {
            fileContentsUnmodified = Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("Failed to load file %s/%s", directoryPath, fileName), e);
        }
    }
}
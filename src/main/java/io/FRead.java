package io;

import lombok.AllArgsConstructor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class FRead implements Read {
    String path;

    @Override
    public String read() {
        StringBuilder readText = new StringBuilder();
        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                readText.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return readText.toString();
    }

    public static Set<String> getFilesInDir(){
        String rootPathToBook = "knihy";
        Set<String> setFiles = new HashSet<>();
        final File folder = new File(System.getProperty("user.dir") + "/" + rootPathToBook);
        for (File fileEntry : folder.listFiles()) {
            setFiles.add(rootPathToBook + "/" + fileEntry.getName());
        }
        return setFiles;
    }
}

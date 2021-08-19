package io;

import lombok.AllArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;

@AllArgsConstructor
public class FWrite implements Print {
    String path;

    @Override
    public void write(String src) {
        try (FileWriter writer = new FileWriter(path, false)) { // argument false = файл буде перезаписуватись , якщо true = то ні
            writer.write(src);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
     }
    }
}

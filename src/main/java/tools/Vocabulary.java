package tools;

import io.FRead;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class Vocabulary {
    public static String TSA = "abcdefghijklmnopqrstuvwxyz";
    static String pathVocabulary = "src/main/resources/dictionaries/en-words-80K";


    public static Set<String> getAllWords(){
        FRead fr = new FRead(pathVocabulary);
        String []arrWords = fr.read().split("\r*\n");
        return new HashSet<>(Arrays.asList(arrWords));
    }
}

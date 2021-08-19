package tools;

import java.text.Normalizer;
import java.util.Set;

public class WorkWithText {

    public static String removingUnnecessaryCharacters(String text){
        String withoutDiacriticText = stripAccents(text);
        StringBuilder NormalText = new StringBuilder();
        for (int i = 0; i < withoutDiacriticText.length(); i++) {
            char ch = Character.toLowerCase(withoutDiacriticText.charAt(i));
            if ((ch >= 'a' && ch <= 'z') || ch == '\n') {
                NormalText.append(ch);
            }
        }
        return NormalText.toString();
    }

    // Заміняє всі ці вокані і іншу поєботу на звичайні АСІІ значення букв
    private static String stripAccents(String input) {
        return input == null ? null :
                Normalizer.normalize(input, Normalizer.Form.NFD)
                        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static double textEvaluation(String phrase){
        Set<String> vocWords = Vocabulary.getAllWords();

        int count = 0;
        int sI = 0; //startIndex
        StringBuilder strB = new StringBuilder(phrase);
        int l1 = strB.length()-1;
        String str;
        for (int l = strB.length();l >= sI;l--) {
            str = strB.substring(sI,l);
            if (vocWords.contains(str) && !str.equals("")){
                count++;
                strB.delete(sI,l);
                l = strB.length();
            }
            if (l == sI) {
                l = strB.length() + 1;
                sI++;
            }
        }
        int l2 = strB.length();
        return (1 - ( ((double)l2/l1)));
    }
}

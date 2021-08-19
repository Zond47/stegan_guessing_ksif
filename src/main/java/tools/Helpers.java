package tools;
/* CLASS HELPERS*/

import java.util.Arrays;

public class Helpers {
    // Для шифрів допоміжний клас , нічо важливого

    /**
     * @param phrase only TSA letters without space
     * @return numeric permutation derived from phrase in range <0,n>
     */
    public static int[] permutationFromPhrase(String phrase) {
        phrase = phrase.toLowerCase();
        int[] retVal = new int[phrase.length()];
        char[] sorted = phrase.toCharArray();
        Arrays.sort(sorted); // sort in ascending order
        int len = phrase.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) { // search for the first position of the specific letter
                if (phrase.charAt(i) == sorted[j]) {
                    retVal[i] = j;
                    sorted[j] = '_'; // mark as used
                    break;
                }
            }
        }
        //~
        return retVal;
    }
    //phrase - vasa lox otak
    //sorted - aaakloovsxt
    //index -  0123456789012

    //retval - 7

    /**
     * @param perm permutation in range <0,n>
     * @return
     */
    public static int[] inverse(int[] perm) {
        int[] inv = new int[perm.length];
        for (int i = 0; i < perm.length; i++) {
            inv[perm[i]] = i;
        }
        return inv;
    }

    public static String applyPermutation(String input, int[] perm) {
        char output[] = new char[perm.length];
        for (int i = 0; i < perm.length; i++) {
            output[perm[i]] = input.charAt(i);
        }
        return new String(output);
    }
}

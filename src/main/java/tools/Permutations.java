package tools;

import java.util.*;

public class Permutations { // Для шифрів допоміжний клас , нічо важливого

    private static Random rnd = new Random(System.currentTimeMillis());

    public static void rndPerm(Object input[]) {
        int size = input.length;
        for (int i = 0; i < (size - 1); i++) {
            int j = rnd.nextInt(size - i) + i;
            // swap
            Object tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
        }
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public static List allPerm(Object input[]) {
        List<Object[]> retVal = new ArrayList(getFactorial(input.length));
        allPerm(0, input, retVal);
        return retVal;
    }

    private static void allPerm(int fixed, Object input[], List output) {
        Object in[] = input.clone();
        if (fixed == input.length) {
            output.add(input);
        } else {
            for (int i = fixed; i < input.length; i++) {
                // swap
                Object tmp = in[i];
                in[i] = in[fixed];
                in[fixed] = tmp;
                // recursion
                allPerm(fixed + 1, in, output);
            }
        }
    }

    /* Vstup: M = {a, .... z}, reprezentovane s char*/
    public static Character[] inverse(Character[] perm) {
        Character[] inv = new Character[perm.length];
        for (int i = 0; i < perm.length; i++) {
            inv[perm[i] - 'a'] = (char) (i + 'a');
        }
        return inv;
    }

    /* Vstup: M = {1, .... m}*/
    public static Integer[] inverse(Integer[] perm) {
        Integer[] inv = new Integer[perm.length];
        for (int i = 0; i < perm.length; i++) {
            inv[perm[i]-1] = i+1;
        }
        return inv;
    }

    public static Integer[] inverse(Object[] perm){
        List sorted = Arrays.asList(perm.clone()); // kopia do zoznamu
        Collections.sort(sorted); // zoradime

        Integer[] tmp = new Integer[perm.length];
        for(int i=0; i < perm.length; i++){
            tmp[i] = sorted.indexOf(perm[i])+1;
            // poradie prvku zo vstupu pri zakladnom usporiadani vstupnej mn.
        }
        return inverse(tmp);
    }

}

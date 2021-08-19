package nemenit;

import java.util.Arrays;
import java.util.List;
import vlastne.CombinedCipherAnalyser;
import vlastne.NullCipherAnalyser;

public class Main {

    /**
     * NEMENTE, okrem nastavenia ZT1 az ZT5
     */
    public static void main(String[] args) {
        // SEM MOZETE NAHRAT JEDNOTLIVE OT
        String ZT1 = "";
        String ZT2 = "";
        String ZT3 = "";
        String ZT4 = "";
        String ZT5 = "";
        // ODTIAL UZ NEMENTE MAIN

        // PRVA CAST
        List<String> firstPhase = Arrays.asList(ZT1, ZT2, ZT3, ZT4);
        Evaluator evaluator = new Evaluator();
        StringBuilder vk = new StringBuilder();
        for (int i = 0; i < firstPhase.size(); i++) {
            NullCipherAnalyser nca = new NullCipherAnalyser();
            nca.analyse(firstPhase.get(i));
            String OT = nca.getBestResult();
            if (OT != null) {
                evaluator.addResult(i + 1, OT);
                vk.append(OT.charAt(0));
            }
        }

        // DRUHA CAST
        CombinedCipherAnalyser cca = new CombinedCipherAnalyser(vk.toString());
        cca.analyse(ZT5);
        String OT = cca.getBestResult();
        evaluator.addResult(5, OT);

        // HODNOTIT BUDEM POMOCOU TRIEDY EVALUATOR
        int body = 0;
        int counter = 0;
        for (int key = 1; key <= 5; key++) {
            boolean passed = evaluator.evaluate(key);
            if (passed) {
                body += evaluator.getScore(key);
                if (key < 5) { // okrem posledneho - bonus +2
                    counter++;
                }
            }
        }
        if (counter == 4) {
            body += 2;
        }
        System.out.println("BODY CELKOVO: " + body);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nemenit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * TUTO TRIEDU NEMENTE.
 */
public class Evaluator {

    Map<Integer, String> results = new HashMap<>();
    List<Integer> score = Arrays.asList(2, 2, 2, 2, 7);

    // TOTO DOPLNIM LEN PRI OPRAVOVANI
    String OT1 = "";
    String OT2 = "";
    String OT3 = "";
    String OT4 = "";
    String OT5 = "";
    
    List<String> correctResults = Arrays.asList(OT1, OT2, OT3, OT4, OT5);

    public void addResult(int textID, String OT1) {
        results.put(textID, OT1);
    }

    public String getResult(int textID) {
        return results.get(textID);
    }

    public int getScore(int textID) {
        return score.get(textID - 1);
    }

    public boolean evaluate(int textID) {
        String cr = correctResults.get(textID - 1);
        return getResult(textID).equals(cr);
    }

}

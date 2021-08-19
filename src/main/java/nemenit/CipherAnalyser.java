package nemenit;

import java.util.HashMap;
import java.util.Map;

/*
 * TUTO TRIEDU NEMENTE.
 */
public abstract class CipherAnalyser {

    public HashMap<String, Double> result = new HashMap<>();

    /*
     * Abstraktna metoda, ktoru musite naimplementovat v nejakej podtriede.
     * Perametrom funkcie je ZT a vysledok/vysledky sa maju ulozit do mapy result.
     * Do mapy ukladame aj skore kandidatov na OT.
     */
    abstract public void analyse(String input);

    /*
     * Funkcia vrati ako retazec najlepsie riesenie co sme nasli.
     * Riesenie musi byt ulozene v mape result aj s prislusnou hodnotou skore.
     * Vacsie skore == lepsie riesenie.
     */
    public String getBestResult() {
        if (result.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        double bestScore = Double.MIN_VALUE;
        String bestRes = "";
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            sb.append(value).append(" - ").append(key).append("\n");
            if (value > bestScore) {
                bestScore = value;
                bestRes = key;
            }
        }
        System.out.println(bestScore + " - " + bestRes);
        return bestRes;
    }

}

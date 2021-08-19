package vlastne;

import nemenit.CipherAnalyser;

public class CombinedCipherAnalyser extends CipherAnalyser {

    String vigenereKey;

    public CombinedCipherAnalyser(String vigenereKey) {
        if (vigenereKey.length() == 4) {
            // len v pripade, ze mam vsetky 4 OT (spravne OT :-))
            this.vigenereKey = vigenereKey;
        }
    }

    @Override
    public void analyse(String input) {
        // TODO NAIMPLEMENTOVAT METODU

        // ked ste nasli spravne OT1 az OT4, tak viete vigenereKey
        // niekde if(vigenereKey != null) { ... }
        
        // nezabudnite ulozit 
        //super.result.put(cand, score);
    }

}

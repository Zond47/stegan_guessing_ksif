package vlastne;

import nemenit.CipherAnalyser;

import java.util.ArrayList;
import java.util.List;

public class NullCipherAnalyser extends CipherAnalyser {

    public NullCipherAnalyser() {
        super();
    }

    @Override
    public void analyse(String input/*TSA*/) {
        List<String> candidates = new ArrayList<>();
     
        
        // TODO NAIMPLEMENTOVAT METODU
  
        
        for (String cand : candidates) {
            //double score = TODO
            //super.result.put(cand, score);
        }
    }

   /*
    *  TU MOZETE ZADEFINOVAT/NAIMPLEMENTOVAT VLASTNE METODY
    */
}

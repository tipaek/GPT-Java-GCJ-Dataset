import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       
        int nbLigne = fr.nextInt();

        for (int i=0; i<nbLigne; i++) {
            String ligne = fr.next();

            int a = ligne.length();
            char[] tab = new char[a];
            for(int y = 0; y < a; y++){
                tab[y] = ligne.charAt(y);
            }

            StringBuilder res = new StringBuilder();
            int nbParentese = 0;
             for (char c : tab) {
                int num = Character.getNumericValue(c);
                if(nbParentese != num) {
                    while (nbParentese > num) {
                        nbParentese--;
                        res.append(")");
                    }
                }
                while(nbParentese < num) {
                    nbParentese++;
                    res.append("(");
                }
                res.append(c);
            }
            while(nbParentese > 0 ) {
                nbParentese--;
                res.append(")");
            }

            System.out.println(res);
        }

    }
}

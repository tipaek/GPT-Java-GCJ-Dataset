import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner 
            fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int nbLigne = fr.nextInt();

        for (int i=0; i<nbLigne; i++) {

            int nbActivite = fr.nextInt();

            int debutC = 0;
            int finC = 0;
            int debutJ = 0;
            int finJ = 0;

            StringBuilder res = new StringBuilder();
            boolean possible = true;

            for (int y=0; y<nbActivite; y++) {

                    int debut = fr.nextInt();
                    int fin = fr.nextInt();


                    if (debut >= finC || debutC >= fin) {
                        debutC = debut;
                        finC = fin;
                        res.append("C");
                    } else if (debut >= finJ || debutJ >= fin) {
                        debutJ = debut;
                        finJ = fin;
                        res.append("J");
                    } else {
                        //System.out.println("res = " + res + " impossible car C fin = " + finC + " et J fin = " + finJ);
                        possible = false;
                    }

                    //System.out.println("debut = " + debut + ", fin = " + fin);
            }

            if(possible) System.out.println("Case #" + (i+1) + ": " + res);
            else System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
        }

    }
}

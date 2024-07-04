import java.io.*;
import java.util.*;

class Activite {
    public int debut;
    public int fin;

    public Activite(int d, int f) {
        this.debut = d;
        this.fin = f;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int nbLigne = fr.nextInt();

        for (int i = 0; i < nbLigne; i++) {

            int nbActivite = fr.nextInt();

            ArrayList<Activite> actC = new ArrayList<>();
            ArrayList<Activite> actJ = new ArrayList<>();

            StringBuilder res = new StringBuilder();
            boolean possibleLigne = true;

            for (int y = 0; y < nbActivite; y++) {
                //System.out.println("-----------");
                int debut = fr.nextInt();
                int fin = fr.nextInt();


                boolean possible = true;
                for (Activite act : actC) { // savoir si on ne peux pas
                    if (fin > act.debut && fin < act.fin) {
                        //System.out.println("impossibleC pour : " + debut + " - " + fin);
                        possible = false;
                    } else if (debut > act.debut && debut < act.fin) {
                        //System.out.println("impossibleC pour : " + debut + " - " + fin);
                        possible = false;
                    }
                }

                if (possible) {
                    //System.out.println("cetait possible");
                    res.append("C");
                    actC.add(new Activite(debut, fin));
                } else {
                    //System.out.println("cetait pas possible");
                    possible = true;
                    for (Activite act : actJ) { // savoir si on ne peux pas
                        if (fin > act.debut && fin < act.fin) {
                            //System.out.println("impossibleJ pour : " + debut + " - " + fin);
                            possible = false;
                        } else if (debut > act.debut && debut < act.fin) {
                            //System.out.println("impossibleJ pour : " + debut + " - " + fin);
                            possible = false;
                        }
                    }
                    if (possible) {
                        res.append("J");
                        actJ.add(new Activite(debut, fin));
                    } else possibleLigne = false;
                }


                //System.out.println(res + "= res");
/*
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
 */

                //System.out.println("debut = " + debut + ", fin = " + fin);
            }

            if (possibleLigne) System.out.println("Case #" + (i + 1) + ": " + res);
            else System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
        }

    }
}

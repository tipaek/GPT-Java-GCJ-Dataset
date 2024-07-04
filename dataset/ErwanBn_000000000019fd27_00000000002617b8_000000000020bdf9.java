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

    public static ArrayList<Integer> restT;

    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int nbLigne = fr.nextInt();

        for (int i = 0; i < nbLigne; i++) {

            int nbActivite = fr.nextInt();
            Integer[][] activities = new Integer[nbActivite][2];
            for (int y=0; y<nbActivite; y++) {
                Integer[] tmp = new Integer[3];
                tmp[0] = fr.nextInt();
                tmp[1] = fr.nextInt();
                tmp[2] = y;
                activities[y] = tmp;
            }

            int cpt=0;
            String res = "IMPOSSIBLE";
            boolean condition = false;
            while (!condition) {
                Collections.shuffle(Arrays.asList(activities));
                restT = new ArrayList<>();
                res = renvoieChaine(activities);
                //System.out.println(res);
                if (cpt > nbActivite*1.5) condition = true;
                if (!res.equals("IMPOSSIBLE")) condition = true;
                cpt++;
            }
            if (!res.equals("IMPOSSIBLE")) {
                char[] all = res.toCharArray();
                char[] res2 = new char[all.length];
                //System.out.println(restT.size());
                //System.out.println(all.length);
                for (int a=0; a<all.length; a++) {
                    res2[restT.get(a)] = all[a];
                }

                res = String.valueOf(res2);
            }
            System.out.println("Case #" + (i+1) + ": " + res);
        }

    }

    public static String renvoieChaine(Integer[][] activities) {
        ArrayList<Activite> actC = new ArrayList<>();
        ArrayList<Activite> actJ = new ArrayList<>();

        StringBuilder res = new StringBuilder();
        boolean possibleLigne = true;

        for (int y = 0; y < activities.length; y++) {
            //System.out.println("-----------");
            int debut = activities[y][0];
            int fin = activities[y][1];

            boolean possible = true;
            for (Activite act : actC) { // savoir si on ne peux pas
                if (fin > act.debut && fin < act.fin) {
                    //System.out.println("impossibleC pour : " + debut + " - " + fin);
                    possible = false;
                } else if (debut > act.debut && debut < act.fin) {
                    //System.out.println("impossibleC pour : " + debut + " - " + fin);
                    possible = false;
                } else if(debut < act.debut && fin > act.fin) {
                    possible = false;
                }
            }

            if (possible) {
                //System.out.println("c etait possible");
                res.append("C");
                restT.add(activities[y][2]);
                actC.add(new Activite(debut, fin));
            } else {
                //System.out.println("c etait pas possible");
                possible = true;
                for (Activite act : actJ) { // savoir si on ne peux pas
                    if (fin > act.debut && fin < act.fin) {
                        //System.out.println("impossibleJ pour : " + debut + " - " + fin);
                        possible = false;
                    } else if (debut > act.debut && debut < act.fin) {
                        //System.out.println("impossibleJ pour : " + debut + " - " + fin);
                        possible = false;
                    } else if(debut < act.debut && fin > act.fin) {
                        possible = false;
                    }
                }
                if (possible) {
                    res.append("J");
                    restT.add(activities[y][2]);
                    actJ.add(new Activite(debut, fin));
                } else possibleLigne = false;
            }
        }

        if (possibleLigne) return String.valueOf(res);
        else return "IMPOSSIBLE";
    }
}

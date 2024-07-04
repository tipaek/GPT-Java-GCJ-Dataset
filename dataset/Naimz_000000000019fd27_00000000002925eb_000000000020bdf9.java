import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nbCas = sc.nextInt();
        int nbInterval;

        ArrayList<Intervalle> listeC;
        ArrayList<Intervalle> listeJ;
        Intervalle interval;
        boolean cBon = true;

        StringBuilder stringFinale;

        for (int i = 0; i < nbCas; i++) {

            cBon = true;
            nbInterval = sc.nextInt();
            listeC = new ArrayList<>();
            listeJ = new ArrayList<>();
            stringFinale = new StringBuilder();

            for (int j = 0; j < nbInterval; j++) {

                interval = new Intervalle(sc.nextInt(), sc.nextInt());

                if (intervalDansListe(interval, listeC)) {
                    listeC.add(interval);
                    stringFinale.append("C");
                }
                else if (intervalDansListe(interval, listeJ)) {
                    listeJ.add(interval);
                    stringFinale.append("J");
                }
                else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    cBon = false;
                }
            }
            if (cBon)
                System.out.println("Case #" + (i + 1) + ": " + stringFinale);
        }
    }

    static boolean intervalDansListe(Intervalle intervalle, ArrayList<Intervalle> liste) {

        for (int i = 0; i < liste.size(); i++) {

            if ((intervalle.deb > liste.get(i).deb && intervalle.deb < liste.get(i).fin) || (intervalle.fin > liste.get(i).deb && intervalle.fin < liste.get(i).fin)) {

                return false;
            }
        }
        return true;
    }

    static class Intervalle {

        int deb;
        int fin;

        public Intervalle(int deb, int fin) {
            this.deb = deb;
            this.fin = fin;
        }
    }
}

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
        boolean cBon;

        boolean boolC;
        boolean boolJ;

        StringBuilder stringFinale;

        for (int i = 0; i < nbCas; i++) {

            cBon = true;
            nbInterval = sc.nextInt();
            listeC = new ArrayList<>();
            listeJ = new ArrayList<>();
            stringFinale = new StringBuilder();

            for (int j = 0; j < nbInterval; j++) {

                interval = new Intervalle(sc.nextInt(), sc.nextInt());

                boolC = intervalDansListe(interval, listeC);
                boolJ = intervalDansListe(interval, listeJ);
                if (boolC && boolJ) {

                    int res = plusProche(interval, listeC, listeJ);

                    if (res == 0) {
                        listeC.add(interval);
                        stringFinale.append("C");
                    } else {
                        listeJ.add(interval);
                        stringFinale.append("J");
                    }

                } else if (boolC) {
                    listeC.add(interval);
                    stringFinale.append("C");
                }
                else if (boolJ) {
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

            if ((intervalle.deb == liste.get(i).deb) || (intervalle.fin == liste.get(i).fin) ||
                    ((intervalle.deb <= liste.get(i).fin) && (liste.get(i).deb <= intervalle.fin)) ||
                    ((intervalle.deb < liste.get(i).deb) && (intervalle.fin > liste.get(i).fin))) {


                return false;
            }
        }
        return true;
    }

    static int plusProche(Intervalle intervalle, ArrayList<Intervalle> liste1, ArrayList<Intervalle> liste2) {

        int intervallePlusPetit1 = 2000;
        int intervallePlusPetit2 = 2000;

        for (int i = 0; i < liste1.size(); i++) {

            if (intervalle.deb - liste1.get(i).deb < intervallePlusPetit1)
                intervallePlusPetit1 = intervalle.deb - liste1.get(i).deb;
            if (intervalle.fin - liste1.get(i).fin < intervallePlusPetit1)
                intervallePlusPetit1 = intervalle.fin - liste1.get(i).fin;
        }

        for (int i = 0; i < liste2.size(); i++) {

            if (intervalle.deb - liste2.get(i).deb < intervallePlusPetit2)
                intervallePlusPetit2 = intervalle.deb - liste2.get(i).deb;
            if (intervalle.fin - liste2.get(i).fin < intervallePlusPetit2)
                intervallePlusPetit2 = intervalle.fin - liste2.get(i).fin;
        }

        if (intervallePlusPetit1 < intervallePlusPetit2)
            return 0;
        else if (intervallePlusPetit2 < intervallePlusPetit1)
            return 1;

        return 0;
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

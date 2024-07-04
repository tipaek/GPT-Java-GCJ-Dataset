import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();

        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int[] debut = new int[N];
            int[] fin = new int[N];

            for (int i = 0; i < N; i++) {
                debut[i] = input.nextInt();
                fin[i] = input.nextInt();
            }

            solver(debut, fin, N, ks);
        }
    }

    public static void solver(int[] debut, int[] fin, int N, int iteration) {
        StringBuilder resultat = new StringBuilder("C");
        String parentActuel = "C";

        List<Integer> tachesCDebut = new ArrayList<>();
        List<Integer> tachesCFin = new ArrayList<>();
        List<Integer> tachesJDebut = new ArrayList<>();
        List<Integer> tachesJFin = new ArrayList<>();

        tachesCDebut.add(debut[0]);
        tachesCFin.add(fin[0]);

        int nbrChangement = 0;

        for (int i = 1; i < N; i++) {
            boolean conflict = false;

            if (parentActuel.equals("C")) {
                for (int j = 0; j < tachesCDebut.size(); j++) {
                    if (isConflict(debut[i], fin[i], tachesCDebut.get(j), tachesCFin.get(j))) {
                        conflict = true;
                        nbrChangement++;
                        parentActuel = "J";
                        break;
                    }
                }
                if (!conflict) {
                    resultat.append("C");
                    tachesCDebut.add(debut[i]);
                    tachesCFin.add(fin[i]);
                    nbrChangement = 0;
                }
            } else {
                for (int j = 0; j < tachesJDebut.size(); j++) {
                    if (isConflict(debut[i], fin[i], tachesJDebut.get(j), tachesJFin.get(j))) {
                        conflict = true;
                        nbrChangement++;
                        parentActuel = "C";
                        break;
                    }
                }
                if (!conflict) {
                    resultat.append("J");
                    tachesJDebut.add(debut[i]);
                    tachesJFin.add(fin[i]);
                    nbrChangement = 0;
                }
            }

            if (conflict) {
                i--;
            }

            if (nbrChangement >= 2) {
                System.out.println("Case #" + iteration + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + iteration + ": " + resultat.toString());
    }

    private static boolean isConflict(int debut, int fin, int tacheDebut, int tacheFin) {
        return (debut < tacheFin && debut >= tacheDebut) ||
               (fin > tacheDebut && fin <= tacheFin) ||
               (debut <= tacheDebut && fin >= tacheFin) ||
               (debut >= tacheDebut && fin <= tacheFin);
    }
}
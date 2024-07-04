import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

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
        String resultat = "C";
        String parentActuel = "C";

        List<Integer> tachesCDebut = new ArrayList<>();
        List<Integer> tachesCFin = new ArrayList<>();
        List<Integer> tachesJDebut = new ArrayList<>();
        List<Integer> tachesJFin = new ArrayList<>();

        tachesCDebut.add(debut[0]);
        tachesCFin.add(fin[0]);

        int nbrTachePossible = 1;
        int nbrChangement = 0;

        for (int i = 1; i < N; i++) {
            
            if (parentActuel.equals("C")) 
            {
                for (int j = 0; j < tachesCDebut.size(); j++) {
                    if ( (debut[i] < tachesCFin.get(j) && debut[i] >= tachesCDebut.get(j))|| ( fin[i] > tachesCDebut.get(j) && fin[i] <= tachesCFin.get(j) ) ) {
                        nbrChangement++;
                        parentActuel="J";
                        i--;
                        break;
                    }
                }
                if(parentActuel.equals("C"))
                {
                    resultat+="C";
                    nbrChangement = 0;
                    tachesCDebut.add(debut[i]);
                    tachesCFin.add(fin[i]);
                }
                
            }
            else
            {
                for (int j = 0; j < tachesJDebut.size(); j++) {
                    if ( (debut[i] < tachesJFin.get(j) && debut[i] >= tachesJDebut.get(j))|| ( fin[i] > tachesJDebut.get(j) && fin[i] <= tachesJFin.get(j) ) ) {
                        nbrChangement++;
                        parentActuel="C";
                        i--;
                        break;
                    }
                }
                
                if(parentActuel.equals("J"))
                {
                    resultat+="J";
                    nbrChangement=0;
                    tachesJDebut.add(debut[i]);
                    tachesJFin.add(fin[i]);
                }
                
            }
            
            if(nbrChangement >= 2)
            {
                System.out.println("Case #" + iteration + ": IMPOSSIBLE");
                return;
            }
            else
            {
                nbrTachePossible++;
            }

        }
        
        System.out.println("Case #" + iteration + ": "+resultat);
    }

}
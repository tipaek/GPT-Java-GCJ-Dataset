import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nbMatrice = fr.nextInt();

        for (int i = 0; i < nbMatrice; i++) { //pour les 3 matrices
            int dimension = fr.nextInt();
            ArrayList<int[]> matrice = new ArrayList<>();

            int totalMaxLigne = 0;

            int sommeDiago = 0;

            for (int y = 0; y < dimension; y++) { // pour les n lignes
                
                int[] res = new int[dimension];

                HashMap<Integer, Integer> comptage = new HashMap<>();

                for (int z = 0; z < nombres.length; z++) {
                    int nb = 0;
                    int currentNombre = fr.nextInt();
                    res[z] = currentNombre;
                    if (comptage.containsKey(currentNombre)) {
                        nb = comptage.get(currentNombre);
                    }
                    nb++;

                    comptage.put(currentNombre,nb);
                    if (y == z) sommeDiago += currentNombre;

                }
                for (int a : comptage.values()) {
                    if(a > totalMaxLigne) totalMaxLigne = a;
                }
                if(totalMaxLigne == 1) totalMaxLigne = 0;


                matrice.add(res);
            }

            int totalMaxColonne = 0;

            for (int x = 0; x < dimension; x++) {
                int maxColonne = 0;
                HashMap<Integer, Integer> comptage = new HashMap<>();

                for (int y = 0; y < dimension; y++) {
                    int nb = 0;
                    int currentNombre = matrice.get(y)[x];
                    if (comptage.containsKey(currentNombre)) {
                        nb = comptage.get(currentNombre);
                    }
                    nb++;

                    comptage.put(currentNombre,nb);
                }
                for (int a : comptage.values()) {
                    if(a > totalMaxColonne) totalMaxColonne = a;
                }
                if(totalMaxColonne == 1) totalMaxColonne = 0;
            }

            //System.out.println("SommeDiago = " + sommeDiago);
            //System.out.println("MaxLigne = " + totalMaxLigne);
            //System.out.println("MaxColonne = " + totalMaxColonne);

            System.out.println("Case #" + i + " " + sommeDiago + " " + totalMaxLigne + " " + totalMaxColonne);


        }


    }
}
    
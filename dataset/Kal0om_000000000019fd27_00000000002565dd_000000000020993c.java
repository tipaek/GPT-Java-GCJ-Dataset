import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner fr = null;
        try {
            fr = new Scanner(new BufferedReader(new FileReader("src/test1.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int nbMatrice = fr.nextInt();

        for (int i = 0; i < nbMatrice; i++) { //pour les 3 matrices
            int dimension = fr.nextInt();
            ArrayList<int[]> matrice = new ArrayList<>();

            int totalMaxLigne = 0;

            int sommeDiago = 0;

            for (int y = 0; y < dimension; y++) { // pour les n lignes

                int[] res = new int[dimension];

                HashMap<Integer, Integer> comptage = new HashMap<>();
                for (int z = 0; z < dimension; z++) {
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
                int tmp = 0;
                for (int a : comptage.values()) {
                    if(a > 1) tmp = 1;
                }
                totalMaxLigne += tmp;

                matrice.add(res);
            }

            int totalMaxColonne = 0;

            for (int x = 0; x < dimension; x++) {
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
                int tmp = 0;
                for (int a : comptage.values()) {
                    if(a > 1) tmp = 1;
                }
                totalMaxColonne += tmp;
            }

            //System.out.println("SommeDiago = " + sommeDiago);
            //System.out.println("MaxLigne = " + totalMaxLigne);
            //System.out.println("MaxColonne = " + totalMaxColonne);

            System.out.println("Case #" + (i+1) + ": " + sommeDiago + " " + totalMaxLigne + " " + totalMaxColonne);


        }


    }
}

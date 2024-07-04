import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fr = new BufferedReader(new InputStreamReader(System.in))) {
            int nbMatrice = Integer.parseInt(fr.readLine());

            for (int i = 0; i < nbMatrice; i++) {
                int dimension = Integer.parseInt(fr.readLine());
                ArrayList<int[]> matrice = new ArrayList<>();
                int totalMaxLigne = 0;
                int sommeDiago = 0;

                for (int y = 0; y < dimension; y++) {
                    String[] nombres = fr.readLine().split(" ");
                    int[] res = new int[dimension];
                    HashMap<Integer, Integer> comptage = new HashMap<>();

                    for (int z = 0; z < nombres.length; z++) {
                        int currentNombre = Integer.parseInt(nombres[z]);
                        res[z] = currentNombre;
                        comptage.put(currentNombre, comptage.getOrDefault(currentNombre, 0) + 1);
                        if (y == z) sommeDiago += currentNombre;
                    }

                    for (int count : comptage.values()) {
                        if (count > totalMaxLigne) totalMaxLigne = count;
                    }
                    if (totalMaxLigne == 1) totalMaxLigne = 0;

                    matrice.add(res);
                }

                int totalMaxColonne = 0;

                for (int x = 0; x < dimension; x++) {
                    HashMap<Integer, Integer> comptage = new HashMap<>();

                    for (int y = 0; y < dimension; y++) {
                        int currentNombre = matrice.get(y)[x];
                        comptage.put(currentNombre, comptage.getOrDefault(currentNombre, 0) + 1);
                    }

                    for (int count : comptage.values()) {
                        if (count > totalMaxColonne) totalMaxColonne = count;
                    }
                    if (totalMaxColonne == 1) totalMaxColonne = 0;
                }

                System.out.println("Case #" + i + " " + sommeDiago + " " + totalMaxLigne + " " + totalMaxColonne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
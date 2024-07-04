import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int nbLigne = fr.nextInt();

        for (int i=0; i<nbLigne; i++) {

            int taille = fr.nextInt();
            int diago = fr.nextInt();

            int[][] matrice = new int[taille][taille];

            for (int y=0; y<taille; y++) {
                for (int z=0; z<taille; z++) {
                    matrice[y][z] = (z+y)%taille+1;
                }
            }

            boolean condition = getSommeDiago(matrice) != diago;
            if(diago > taille*taille) condition = false;
            int cpt = 0;
            while (condition) {
                Collections.shuffle(Arrays.asList(matrice));
                if(getSommeDiago(matrice) == diago) condition = false;
                if(cpt > matrice.length*100) condition = false;
                cpt++;
            }

            if(getSommeDiago(matrice) == diago) {
                System.out.println("Case #" + (i+1) + ": POSSIBLE");
                for (int y = 0; y < taille; y++) {
                    for (int z = 0; z < taille; z++) {
                        System.out.print(matrice[y][z]);
                    }
                    System.out.println("");
                }
            } else System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");

        }

    }

    public static int getSommeDiago(int[][] matrice) {
        int res = 0;

        for (int y=0; y<matrice.length; y++) {
            res += matrice[y][y];
        }

        return res;
    }
}

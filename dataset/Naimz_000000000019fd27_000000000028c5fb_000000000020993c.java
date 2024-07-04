import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nbCas = sc.nextInt();

        int tailleMatrice;
        int[][] matrice;

        int sommeDiag = 0;
        int ligne = 0;
        int colonne = 0;

        boolean deja = false;

        for (int i = 0; i < nbCas; i++) {

            sommeDiag = 0;
            ligne = 0;
            colonne = 0;
            tailleMatrice = sc.nextInt();
            matrice = new int[tailleMatrice][tailleMatrice];

            for (int j = 0; j < tailleMatrice; j++) {

                for (int k = 0; k < tailleMatrice; k++) {

                    matrice[j][k] = sc.nextInt();
                    if (j == k) {
                        sommeDiag += matrice[j][k];
                    }
                }
            }

            for (int j = 0; j < tailleMatrice; j++) {

                for (int k = 0; k < tailleMatrice; k++) {

                    if (compterVert(matrice, matrice[j][k], j) && !deja) {

                        deja = true;
                        ligne++;
                    }
                }

                deja = false;
            }

            for (int j = 0; j < tailleMatrice; j++) {

                for (int k = 0; k < tailleMatrice; k++) {

                    if (compterHori(matrice, matrice[k][j], j) && !deja) {

                        deja = true;
                        colonne++;
                    }
                }

                deja = false;
            }

            System.out.println("Case #" + (i + 1) + ": " + sommeDiag + " " + ligne + " " + colonne);
        }
    }

    public static boolean compterVert(int[][] matrice, int valeur, int ligne) {

        int cpt = 0;

        for (int i = 0; i < matrice.length; i++) {

            if (matrice[ligne][i] == valeur) {
                cpt++;
            }
        }
        return cpt >= 2;
    }

    public static boolean compterHori(int[][] matrice, int valeur, int ligne) {

        int cpt = 0;

        for (int i = 0; i < matrice.length; i++) {

            if (matrice[i][ligne] == valeur) {
                cpt++;
            }
        }
        return cpt >= 2;
    }
}

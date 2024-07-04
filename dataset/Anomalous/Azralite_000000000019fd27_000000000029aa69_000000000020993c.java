import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nbTest = sc.nextInt();

        for (int i = 0; i < nbTest; i++) {
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int nbCase = sc.nextInt();

            int[][] matrix = new int[nbCase][nbCase];

            // Reading the matrix and calculating trace
            for (int j = 0; j < nbCase; j++) {
                for (int k = 0; k < nbCase; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Checking for row repeats
            for (int j = 0; j < nbCase; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < nbCase; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Checking for column repeats
            for (int k = 0; k < nbCase; k++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < nbCase; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int testCase = scanner.nextInt();

        for (int i = 1; i <= testCase; i++) {

            int n = scanner.nextInt();

            int diagonal = 0;

            int matrix[][] = new int[n][n];

            int rowRepeat = 0;
            int colRepeat = 0;
            Set<Integer> rowContainer = new HashSet<>();
            for (int j = 0; j < n; j++) {

                Set<Integer> rowSet = new HashSet<>();


                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k)
                        diagonal += matrix[j][k];

                    if (rowSet.contains(matrix[j][k])) {
                        rowRepeat++;
                        rowContainer.add(j);
                    } else rowSet.add(matrix[j][k]);
                }
            }

            for (int j = 0; j < n; j++) {

                Set<Integer> colSet = new HashSet<>();

                for (int k = 0; k < n; k++) {

                    if (colSet.contains(matrix[k][j])) {
                        colRepeat++;
                        break;
                    } else colSet.add(matrix[k][j]);
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonal + " " + rowContainer.size() + " " + colRepeat);

        }

    }

}

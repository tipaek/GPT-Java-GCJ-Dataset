import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCases; i++) {
            int size = sc.nextInt();
            sc.nextLine();

            int[][] matrix = new int[size][size];
            int trace = 0;
            int rowMismatch = 0;
            int colMismatch = 0;

            for (int j = 0; j < size; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    int element = sc.nextInt();
                    matrix[j][k] = element;
                    rowSet.add(element);
                    if (j == k) {
                        trace += element;
                    }
                }
                if (rowSet.size() != size) {
                    rowMismatch++;
                }
            }

            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    colSet.add(matrix[k][j]);
                }
                if (colSet.size() != size) {
                    colMismatch++;
                }
            }

            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowMismatch + " " + colMismatch);
        }
        sc.close();
    }
}
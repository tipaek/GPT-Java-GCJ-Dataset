import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int N = scanner.nextInt();

            int k = 0;
            int[][] matrix = new int[N][N];
            for (int rowN = 0; rowN < N; rowN++) {
                for (int colN = 0; colN < N; colN++) {
                    matrix[rowN][colN] = scanner.nextByte();
                    if (rowN == colN) {
                        k += matrix[rowN][colN];
                    }
                }
            }

            int r = 0, c = 0;
            for (int rowN = 0; rowN < N; rowN++) {
                Set<Integer> setRow = new HashSet<Integer>();
                boolean rowHasDuplicates = false;

                Set<Integer> setCol = new HashSet<Integer>();
                boolean colHasDuplicates = false;

                for (int colN = 0; colN < N; colN++) {
                    if (false == rowHasDuplicates) {
                        if (setRow.contains(matrix[rowN][colN])) {
                            rowHasDuplicates = true;
                        } else {
                            setRow.add(matrix[rowN][colN]);
                        }
                    }

                    if (false == colHasDuplicates) {
                        if (setCol.contains(matrix[colN][rowN])) {
                            colHasDuplicates = true;
                        } else {
                            setCol.add(matrix[colN][rowN]);
                        }
                    }

                    if (rowHasDuplicates && colHasDuplicates) {
                        colN = N;
                    }
                }

                if (rowHasDuplicates) {
                    r++;
                }
                if (colHasDuplicates) {
                    c++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}

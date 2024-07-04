import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;

                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowFlag) {
                        if (rowSet.contains(matrix[i][j])) {
                            rowRepeats++;
                            rowFlag = true;
                        } else {
                            rowSet.add(matrix[i][j]);
                        }
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (colSet.contains(matrix[i][j])) {
                        colRepeats++;
                        break;
                    } else {
                        colSet.add(matrix[i][j]);
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}
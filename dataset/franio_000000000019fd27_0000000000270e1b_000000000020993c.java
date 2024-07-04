
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            int k = 0;
            for (int j = 0; j < size; j++) {
                k += matrix[j][j];
            }

            int rows = 0;
            for (int r = 0; r < size; r++) {
                Set<Integer> wasBefore = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    if (wasBefore.contains(matrix[r][c])) {
                        rows++;
                        break;
                    } else {
                        wasBefore.add(matrix[r][c]);
                    }

                }
            }

            int columns = 0;
            for (int c = 0; c < size; c++) {
                Set<Integer> wasBefore = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (wasBefore.contains(matrix[r][c])) {
                        columns++;
                        break;
                    } else {
                        wasBefore.add(matrix[r][c]);
                    }
                }
            }
            sout(i, k, rows, columns);
        }
        scanner.close();
    }

    private static void sout(int x, int k, int r, int c) {
        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }
}


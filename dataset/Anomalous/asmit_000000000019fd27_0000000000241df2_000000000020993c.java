import java.io.*;
import java.util.*;

class Vestigium {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int T = sc.nextInt();
        int[] results = new int[3 * T];

        for (int h = 0; h < T; h++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int rowRepeats = calculateRowRepeats(matrix, size);
            int colRepeats = calculateColRepeats(matrix, size);

            results[3 * h] = trace;
            results[3 * h + 1] = rowRepeats;
            results[3 * h + 2] = colRepeats;
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[3 * i] + " " + results[3 * i + 1] + " " + results[3 * i + 2]);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueNumbers.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }
        return rowRepeats;
    }

    private static int calculateColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!uniqueNumbers.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }
        return colRepeats;
    }
}

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GoogleCodeJam.Q1();
    }
}

public class GoogleCodeJam {
    private static Scanner scanner = new Scanner(System.in);

    public static void Q1() {
        int tests = read();
        for(int i = 0; i < tests; i++) {
            int size = read();
            int[][] matrix = createMatrix(size);
            int[] result = solve(size, matrix);
            System.out.print("Case #" + i + 1 + ": ");
            for (var num : result) System.out.print(num);
        }
    }

    private static int read() {
        return scanner.nextInt();
    }

    private static int[] solve(int size, int[][] matrix) {

        HashSet<Integer> set = new HashSet<>();
        fillSet(size, set);
        int trace = 0;
        for (int i = 0; i < size; i++) trace += matrix[i][i];
        int rowErr = checkRows(size, set, matrix);
        int colErr = checkCols(size, set, matrix);
        return new int[] { trace, rowErr, colErr };
    }

    private static int checkRows(int size, HashSet<Integer> set, int[][] matrix) {
        int rowErr = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(set.contains(matrix[i][j])) set.remove(matrix[i][j]);
                else {
                    rowErr++;
                    j = size;
                }
            }
            fillSet(size, set);
        }
        return rowErr;
    }

    private static int checkCols(int size, HashSet<Integer> set, int[][] matrix) {
        int colErr = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(set.contains(matrix[j][i])) set.remove(matrix[j][i]);
                else {
                    colErr++;
                    j = size;
                }
            }
            fillSet(size, set);
        }
        return colErr;
    }

    private static void fillSet(int size, HashSet<Integer> set) {
        for (int i = 0; i < size; i++) set.add(i + 1);
    }

    private static int[][] createMatrix(int size) {
        var matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = read();
            }
        }
        return matrix;
    }
}


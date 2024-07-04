import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {
    private static int T;
    private static ArrayList<int[][]> matrices;
    private static ArrayList<Integer> traces;
    private static ArrayList<Integer> rowRepeats;
    private static ArrayList<Integer> colRepeats;

    public static void main(String[] args) {
        matrices = new ArrayList<>();
        traces = new ArrayList<>();
        rowRepeats = new ArrayList<>();
        colRepeats = new ArrayList<>();
        readInput();
        solve();
        printOutput();
    }

    private static void readInput() {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            matrices.add(matrix);
        }
        in.close();
    }

    private static void solve() {
        for (int[][] matrix : matrices) {
            int n = matrix.length;
            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                boolean[] rowSeen = new boolean[n];
                boolean[] colSeen = new boolean[n];
                boolean rowRepeat = false;
                boolean colRepeat = false;

                for (int j = 0; j < n; j++) {
                    if (!rowRepeat) {
                        if (rowSeen[matrix[i][j] - 1]) {
                            rowRepeat = true;
                            rowRepeatCount++;
                        } else {
                            rowSeen[matrix[i][j] - 1] = true;
                        }
                    }

                    if (!colRepeat) {
                        if (colSeen[matrix[j][i] - 1]) {
                            colRepeat = true;
                            colRepeatCount++;
                        } else {
                            colSeen[matrix[j][i] - 1] = true;
                        }
                    }
                }
            }

            traces.add(trace);
            rowRepeats.add(rowRepeatCount);
            colRepeats.add(colRepeatCount);
        }
    }

    private static void printOutput() {
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traces.get(i) + " " + rowRepeats.get(i) + " " + colRepeats.get(i));
        }
    }
}
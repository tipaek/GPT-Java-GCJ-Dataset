import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int T;
    private static ArrayList<int[][]> matrices;
    private static ArrayList<Integer> N;
    private static ArrayList<Integer> traces;
    private static ArrayList<Integer> r;
    private static ArrayList<Integer> c;

    public static void main(String[] args) {
        matrices = new ArrayList<>();
        traces = new ArrayList<>();
        N = new ArrayList<>();
        r = new ArrayList<>();
        c = new ArrayList<>();
        readInput();
        solve();
        printOutput();
    }

    private static void readInput() {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int cur_N = in.nextInt();
            N.add(cur_N);
            int[][] matrix = new int[cur_N][cur_N];
            for (int j = 0; j < cur_N; j++) {
                for (int k = 0; k < cur_N; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            matrices.add(matrix);
        }
        in.close();
    }

    private static void solve() {
        for (int i = 0; i < T; i++) {
            int[][] matrix = matrices.get(i);
            int cur_N = N.get(i);
            int trace = 0;
            for (int j = 0; j < cur_N; j++) {
                trace += matrix[j][j];
            }
            traces.add(trace);

            int rowRepeats = 0;
            int colRepeats = 0;
            for (int j = 0; j < cur_N; j++) {
                boolean[] rowCheck = new boolean[cur_N];
                boolean[] colCheck = new boolean[cur_N];
                boolean rowDone = false;
                boolean colDone = false;
                for (int k = 0; k < cur_N; k++) {
                    if (!rowDone) {
                        if (!rowCheck[matrix[j][k] - 1]) {
                            rowCheck[matrix[j][k] - 1] = true;
                        } else {
                            rowDone = true;
                            rowRepeats++;
                        }
                    }
                    if (!colDone) {
                        if (!colCheck[matrix[k][j] - 1]) {
                            colCheck[matrix[k][j] - 1] = true;
                        } else {
                            colDone = true;
                            colRepeats++;
                        }
                    }
                    if (rowDone && colDone) {
                        break;
                    }
                }
            }
            r.add(rowRepeats);
            c.add(colRepeats);
        }
    }

    private static void printOutput() {
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traces.get(i) + " " + r.get(i) + " " + c.get(i));
        }
    }
}
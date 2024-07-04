import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {
    private int T, N;
    private ArrayList<ArrayList<ArrayList<Integer>>> matrices = new ArrayList<>();
    private ArrayList<Integer> traces = new ArrayList<>();
    private ArrayList<Integer> r = new ArrayList<>();
    private ArrayList<Integer> c = new ArrayList<>();

    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
        vestigium.readInput();
        vestigium.solve();
        vestigium.printOutput();
    }

    private void readInput() {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        for (int i = 0; i < T; i++) {
            N = in.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int k = 0; k < N; k++) {
                    row.add(in.nextInt());
                }
                matrix.add(row);
            }
            matrices.add(matrix);
        }
    }

    private void solve() {
        for (ArrayList<ArrayList<Integer>> matrix : matrices) {
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix.get(i).get(i);
            }
            traces.add(trace);

            // Calculate row and column repeats
            for (int i = 0; i < N; i++) {
                boolean[] rowValues = new boolean[N];
                boolean[] colValues = new boolean[N];
                boolean rowDone = false;
                boolean colDone = false;

                for (int j = 0; j < N; j++) {
                    // Check row
                    if (!rowDone) {
                        int rowVal = matrix.get(i).get(j) - 1;
                        if (rowValues[rowVal]) {
                            rowRepeats++;
                            rowDone = true;
                        } else {
                            rowValues[rowVal] = true;
                        }
                    }

                    // Check column
                    if (!colDone) {
                        int colVal = matrix.get(j).get(i) - 1;
                        if (colValues[colVal]) {
                            colRepeats++;
                            colDone = true;
                        } else {
                            colValues[colVal] = true;
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

    private void printOutput() {
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traces.get(i) + " " + r.get(i) + " " + c.get(i));
        }
    }
}
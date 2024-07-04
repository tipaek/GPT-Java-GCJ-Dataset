import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int T;
    private static ArrayList<ArrayList<ArrayList<Integer>>> matrices;
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
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int size = scanner.nextInt();
            N.add(size);
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    row.add(scanner.nextInt());
                }
                matrix.add(row);
            }
            matrices.add(matrix);
        }
    }

    private static void solve() {
        for (int i = 0; i < T; i++) {
            ArrayList<ArrayList<Integer>> matrix = matrices.get(i);
            int size = N.get(i);
            int trace = calculateTrace(matrix, size);
            traces.add(trace);
            int[] rowAndColRepeats = calculateRowAndColRepeats(matrix, size);
            r.add(rowAndColRepeats[0]);
            c.add(rowAndColRepeats[1]);
        }
    }

    private static int calculateTrace(ArrayList<ArrayList<Integer>> matrix, int size) {
        int trace = 0;
        for (int j = 0; j < size; j++) {
            trace += matrix.get(j).get(j);
        }
        return trace;
    }

    private static int[] calculateRowAndColRepeats(ArrayList<ArrayList<Integer>> matrix, int size) {
        int rowRepeats = 0;
        int colRepeats = 0;
        for (int j = 0; j < size; j++) {
            if (hasDuplicates(matrix.get(j))) {
                rowRepeats++;
            }
            if (hasDuplicates(getColumn(matrix, j))) {
                colRepeats++;
            }
        }
        return new int[]{rowRepeats, colRepeats};
    }

    private static boolean hasDuplicates(ArrayList<Integer> list) {
        boolean[] seen = new boolean[list.size()];
        for (int num : list) {
            if (seen[num - 1]) {
                return true;
            }
            seen[num - 1] = true;
        }
        return false;
    }

    private static ArrayList<Integer> getColumn(ArrayList<ArrayList<Integer>> matrix, int colIndex) {
        ArrayList<Integer> column = new ArrayList<>();
        for (ArrayList<Integer> row : matrix) {
            column.add(row.get(colIndex));
        }
        return column;
    }

    private static void printOutput() {
        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traces.get(i) + " " + r.get(i) + " " + c.get(i));
        }
    }
}
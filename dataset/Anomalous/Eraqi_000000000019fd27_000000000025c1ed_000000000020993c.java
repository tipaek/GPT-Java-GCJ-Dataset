import java.util.ArrayList;
import java.util.Scanner;

class MatrixTrace {

    private ArrayList<ArrayList<Integer>> matrix;
    private int n;

    public MatrixTrace(int n, Scanner scanner, int t) {
        this.n = n;
        this.matrix = new ArrayList<>(n);

        // Initialize matrix
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>(n));
        }

        // Read matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix.get(i).add(scanner.nextInt());
            }
        }

        int trace = calculateTrace();
        int rowOccurrences = calculateRowOccurrences();
        int columnOccurrences = calculateColumnOccurrences();

        System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowOccurrences + " " + columnOccurrences);
    }

    private int calculateTrace() {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix.get(i).get(i);
        }
        return trace;
    }

    private int calculateRowOccurrences() {
        int rowOccurrences = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicate(matrix.get(i))) {
                rowOccurrences++;
            }
        }
        return rowOccurrences;
    }

    private int calculateColumnOccurrences() {
        int columnOccurrences = 0;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> column = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                column.add(matrix.get(j).get(i));
            }
            if (hasDuplicate(column)) {
                columnOccurrences++;
            }
        }
        return columnOccurrences;
    }

    private boolean hasDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> seen = new ArrayList<>();
        for (int num : list) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            new MatrixTrace(n, scanner, i);
        }
        scanner.close();
    }
}
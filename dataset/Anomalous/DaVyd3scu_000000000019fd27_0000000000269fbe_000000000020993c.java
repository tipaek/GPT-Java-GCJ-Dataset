import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[] traceResults = new int[testCases];
        int[] rowRepeats = new int[testCases];
        int[] columnRepeats = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            Matrix matrix = new Matrix(scanner, size);
            matrix.readMatrix();
            int[] repeats = matrix.countRepeats();

            traceResults[t] = matrix.getTrace();
            rowRepeats[t] = repeats[0];
            columnRepeats[t] = repeats[1];
        }

        for (int t = 0; t < testCases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + traceResults[t] + " " + rowRepeats[t] + " " + columnRepeats[t]);
        }
    }
}

class Matrix {
    private int size;
    private int[][] data;
    private int trace;
    private Scanner scanner;

    public Matrix(Scanner scanner, int size) {
        this.size = size;
        this.scanner = scanner;
        this.data = new int[size][size];
        this.trace = 0;
    }

    public void readMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += data[i][j];
                }
            }
        }
    }

    public int getTrace() {
        return trace;
    }

    public int[] countRepeats() {
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(data[i])) {
                repeatedRows++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = data[j][i];
            }

            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }

        return new int[]{repeatedRows, repeatedColumns};
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}
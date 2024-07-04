import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        MainSolver.main(args);
    }
}

class MainSolver {
    public static void main(String[] args) throws IOException {
        Reader inputReader;
        if (Arrays.asList(args).contains("DEBUG_MODE")) {
            inputReader = new FileReader("input.txt");
        } else {
            inputReader = new InputStreamReader(System.in);
        }

        PrintStream outputWriter = System.out;

        try (Scanner scanner = new Scanner(new BufferedReader(inputReader))) {
            try (PrintWriter printWriter = new PrintWriter(outputWriter)) {
                MainSolver solver = new MainSolver(scanner, printWriter);
                int testCases = scanner.nextInt();
                for (int i = 0; i < testCases; i++) {
                    printWriter.printf("Case #%d: ", i + 1);
                    solver.solve();
                }
            }
        }
    }

    private final Scanner scanner;
    private final PrintWriter printWriter;

    private MainSolver(Scanner scanner, PrintWriter printWriter) {
        this.scanner = scanner;
        this.printWriter = printWriter;
    }

    private void solve() {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n];
            boolean[] colCheck = new boolean[n];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (rowCheck[matrix[i][j] - 1]) {
                    rowHasDuplicate = true;
                }
                rowCheck[matrix[i][j] - 1] = true;

                if (colCheck[matrix[j][i] - 1]) {
                    colHasDuplicate = true;
                }
                colCheck[matrix[j][i] - 1] = true;
            }

            if (rowHasDuplicate) rowDuplicates++;
            if (colHasDuplicate) colDuplicates++;
        }

        printWriter.printf("%d %d %d%n", trace, rowDuplicates, colDuplicates);
    }
}
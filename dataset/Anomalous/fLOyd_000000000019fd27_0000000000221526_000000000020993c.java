import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;
    private static PrintStream out;

    public static class Solver {
        private int n;
        private int[][] matrix;

        public void getInput(Scanner scanner) {
            n = scanner.nextInt();
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }

        public String solve() {
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                trace += matrix[i][i];
                if (rowSet.size() < n) rowDuplicates++;
                if (colSet.size() < n) colDuplicates++;
            }
            return String.format("%d %d %d", trace, rowDuplicates, colDuplicates);
        }
    }

    public static void main(String[] args) throws IOException {
        initializeIO();
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            Solver solver = new Solver();
            solver.getInput(in);
            out.printf("Case #%d: %s%n", t, solver.solve());
        }
        out.close();
    }

    private static void initializeIO() throws IOException {
        // Uncomment the following lines to read from and write to files
        // File inputFile = new File("Resources/CodeJam/_2020/QualificationRound/AInput.000");
        // in = new Scanner(new FileInputStream(inputFile));
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // File outputFile = new File("Resources/CodeJam/_2020/QualificationRound/AOutput.000");
        // out = new PrintStream(outputFile);
        out = new PrintStream(System.out);
    }
}
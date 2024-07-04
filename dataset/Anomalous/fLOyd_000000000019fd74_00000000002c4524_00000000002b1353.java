import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static PrintStream printStream;

    private static class Solver {
        private int n;

        void readInput(Scanner scanner) {
            n = scanner.nextInt();
        }

        String computeSolution() {
            StringBuilder result = new StringBuilder();
            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    result.append(i).append(" 1\n");
                }
            } else if (n <= 998) {
                int splitPoint = n - 499;
                for (int i = 1; i <= splitPoint; i++) {
                    result.append(i).append(" 1\n");
                }
                result.append(splitPoint + 1).append(" 2\n");
                for (int i = splitPoint + 1; i < 499; i++) {
                    result.append(i + 1).append(" 1\n");
                }
            } else {
                result.append("1 1\n");
                for (int i = 2; i <= 45; i++) {
                    result.append(i).append(" 2\n");
                }
                for (int i = 46; i <= n - 946 + 45; i++) {
                    result.append(i).append(" 1\n");
                }
            }
            return result.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        initializeIO(true);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            Solver solver = new Solver();
            solver.readInput(scanner);
            printStream.println("Case #" + t + ":");
            printStream.print(solver.computeSolution());
        }
        printStream.close();
    }

    private static void initializeIO(boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            printStream = System.out;
        } else {
            scanner = new Scanner(new FileInputStream("Resources/CodeJam/_2020/Round1A/BInput.000"));
            printStream = new PrintStream(new FileOutputStream("Resources/CodeJam/_2020/Round1A/BOutput.000"));
        }
    }
}
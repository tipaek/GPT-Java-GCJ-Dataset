import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner scanner;
    private static PrintStream output;

    private static class Solver {
        private String inputString;

        void readInput(Scanner scanner) {
            inputString = scanner.next();
        }

        String computeResult() {
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int digit = inputString.charAt(i) - '0';
                
                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }
                
                result.append(inputString.charAt(i));
                currentDepth = digit;
            }
            
            result.append(")".repeat(currentDepth));
            return result.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        initializeIO(true);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            Solver solver = new Solver();
            solver.readInput(scanner);
            output.println("Case #" + t + ": " + solver.computeResult());
        }

        output.close();
    }

    private static void initializeIO(boolean useSystemIO) throws IOException {
        if (useSystemIO) {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            output = new PrintStream(System.out);
        } else {
            File inputFile = new File("Resources/CodeJam/_2020/QualificationRound/BInput.000");
            scanner = new Scanner(new FileInputStream(inputFile));
            File outputFile = new File("Resources/CodeJam/_2020/QualificationRound/BOutput.000");
            output = new PrintStream(outputFile);
        }
    }
}
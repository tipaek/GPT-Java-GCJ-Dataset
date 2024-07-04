import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        ProblemSolver solver = new ProblemSolver();
        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            solver.solve(testIndex, reader);
        }
    }

    static class ProblemSolver {
        void solve(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            String inputLine = reader.readLine();
            int currentDepth = 0;
            
            for (int i = 0; i < inputLine.length(); i++) {
                int digit = inputLine.charAt(i) - '0';
                
                if (currentDepth < digit) {
                    while (currentDepth < digit) {
                        result.append("(");
                        currentDepth++;
                    }
                } else if (currentDepth > digit) {
                    while (currentDepth > digit) {
                        result.append(")");
                        currentDepth--;
                    }
                }

                result.append(digit);
                while (i + 1 < inputLine.length() && (inputLine.charAt(i + 1) - '0') == digit) {
                    result.append(digit);
                    i++;
                }
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }
}
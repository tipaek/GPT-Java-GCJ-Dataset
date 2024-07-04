package round1b;

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

        public void solve(int testNumber, BufferedReader reader) throws IOException {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int aTemp = a;
            int bTemp = b;
            int steps = 0;
            StringBuilder result = new StringBuilder();

            int A = 0, B = 1;

            while (true) {
                bTemp--;
                aTemp--;
                steps++;
                A = a * b - 1 - (Math.max(a, b) - 1);
                B = Math.max(a, b) - 1;
                result.append(A).append(" ").append(B).append("\n");

                if (bTemp == 1 || aTemp == 1) break;
            }

            while (B != 1) {
                steps++;
                A--;
                B--;
                result.append(A).append(" ").append(B).append("\n");
            }

            System.out.println("Case #" + testNumber + ": " + steps);
            System.out.println(result);
        }
    }
}
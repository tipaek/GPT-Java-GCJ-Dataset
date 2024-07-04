package round1b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());
            Solver solver = new Solver();
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, reader);
            }
        }
    }

    static class Solver {

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
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
                A = a * b - 1 - (a - 1);
                B = a - 1;
                result.append(A).append(" ").append(B).append("\n");

                if (bTemp == 1 || aTemp == 1) break;
            }

            while (B != 1) {
                steps++;
                A--;
                B--;
                result.append(A).append(" ").append(B).append("\n");
            }

            System.out.println("Case #" + caseNumber + ": " + steps);
            System.out.println(result);
        }
    }
}
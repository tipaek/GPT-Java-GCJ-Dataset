import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int d = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": \n" + findSolution(d));
        }
    }

    public static String findSolution(int d) {
        if (d == 1) return "1 1";
        if (d == 2) return "1 1\n2 2";
        if (d == 3) return "1 1\n2 2\n2 1";

        int steps = 0, currentSum = 0;
        while (currentSum <= d - 1) {
            steps++;
            currentSum += steps;
        }

        int difference = d - (currentSum - steps);
        StringBuilder result = new StringBuilder();
        result.append("1 1\n");

        for (int i = 1; i < steps; i++) {
            result.append(i + 1).append(" 2\n");
        }

        for (int i = 0; i < difference - 1; i++) {
            result.append(steps - i).append(" 1\n");
        }

        return result.toString().trim();
    }
}
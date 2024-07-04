import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < t; i++) {
            String n = scanner.nextLine().trim();
            processString(n, i + 1);
        }

        scanner.close();
    }

    public static void processString(String n, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int currentBracketLevel = 0;
        char[] characters = n.toCharArray();

        for (char c : characters) {
            int digit = c - '0';

            while (currentBracketLevel < digit) {
                result.append("(");
                currentBracketLevel++;
            }

            while (currentBracketLevel > digit) {
                result.append(")");
                currentBracketLevel--;
            }

            result.append(c);
        }

        while (currentBracketLevel > 0) {
            result.append(")");
            currentBracketLevel--;
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}
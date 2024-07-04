import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            int testCases = Integer.parseInt(scanner.nextLine());
            long caseNumber = 1;

            for (int t = 0; t < testCases; t++) {
                String inputString = scanner.nextLine();
                StringBuilder result = new StringBuilder();
                int[] digits = inputString.chars().map(c -> c - '0').toArray();
                int currentDepth = 0;

                for (int digit : digits) {
                    while (currentDepth < digit) {
                        result.append("(");
                        currentDepth++;
                    }
                    while (currentDepth > digit) {
                        result.append(")");
                        currentDepth--;
                    }
                    result.append(digit);
                }

                while (currentDepth > 0) {
                    result.append(")");
                    currentDepth--;
                }

                System.out.println("Case #" + caseNumber + ": " + result);
                caseNumber++;
            }
        } finally {
            scanner.close();
        }
    }
}
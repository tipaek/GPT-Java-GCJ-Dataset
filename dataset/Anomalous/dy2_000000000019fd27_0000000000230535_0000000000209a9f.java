import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            StringBuilder result = new StringBuilder();
            String input = scanner.nextLine();
            int currentDepth = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = input.charAt(j) - '0';

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(input.charAt(j));
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}
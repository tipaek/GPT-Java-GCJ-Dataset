import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            char[] characters = input.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : characters) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println(result);
        }

        scanner.close();
    }
}
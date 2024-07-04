import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> results = new ArrayList<>();
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfCases; i++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));

                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }

                output.append(input.charAt(j));
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            results.add("Case #" + i + ": " + output.toString());
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
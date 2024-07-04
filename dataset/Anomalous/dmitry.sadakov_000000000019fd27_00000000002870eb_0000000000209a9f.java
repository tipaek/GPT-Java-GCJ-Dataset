package cj2020.q.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; i++) {
            int[] inputArray = parseInputLine(scanner.nextLine());
            String result = generateOutput(inputArray);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int[] parseInputLine(String line) {
        return Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
    }

    private static String generateOutput(int[] inputArray) {
        StringBuilder output = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < inputArray.length; i++) {
            while (currentDepth < inputArray[i]) {
                output.append("(");
                currentDepth++;
            }
            while (currentDepth > inputArray[i]) {
                output.append(")");
                currentDepth--;
            }
            output.append(inputArray[i]);
        }

        while (currentDepth > 0) {
            output.append(")");
            currentDepth--;
        }

        return output.toString();
    }
}
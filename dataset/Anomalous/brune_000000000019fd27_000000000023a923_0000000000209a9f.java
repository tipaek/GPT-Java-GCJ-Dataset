package uke8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numCases; i++) {
            String inputString = reader.readLine();
            String result = processString(inputString);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String processString(String input) {
        StringBuilder output = new StringBuilder();
        int previousDepth = 0;

        for (char ch : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(ch);
            int depthDifference = currentDepth - previousDepth;

            if (depthDifference > 0) {
                output.append("(".repeat(depthDifference));
            } else if (depthDifference < 0) {
                output.append(")".repeat(-depthDifference));
            }

            output.append(currentDepth);
            previousDepth = currentDepth;
        }

        output.append(")".repeat(previousDepth));
        return output.toString();
    }
}
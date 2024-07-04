import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCases; i++) {
            int[] inputArray = parseInput(scanner.nextLine());
            String[] result = generateOutput(inputArray);
            validateOutput(result);
            
            System.out.println("Case #" + i + ": " + String.join(" ", result));
        }
    }

    private static void validateOutput(String[] output) {
        int currentDepth = 0;
        for (String element : output) {
            if (element.equals("(")) {
                currentDepth++;
            } else if (element.equals(")")) {
                currentDepth--;
            } else if (!Integer.toString(currentDepth).equals(element)) {
                throw new IllegalArgumentException("Current depth does not match number: " + currentDepth + " != " + element);
            }
        }
    }

    private static String[] generateOutput(int[] inputArray) {
        List<String> result = new ArrayList<>();
        int currentDepth = 0;

        for (int i = 0; i < inputArray.length; i++) {
            while (currentDepth < inputArray[i]) {
                result.add("(");
                currentDepth++;
            }
            while (currentDepth > inputArray[i]) {
                result.add(")");
                currentDepth--;
            }
            result.add(Integer.toString(inputArray[i]));
        }

        while (currentDepth > 0) {
            result.add(")");
            currentDepth--;
        }

        return new String[] { String.join("", result) };
    }

    private static int[] parseInput(String input) {
        return Arrays.stream(input.split(""))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}
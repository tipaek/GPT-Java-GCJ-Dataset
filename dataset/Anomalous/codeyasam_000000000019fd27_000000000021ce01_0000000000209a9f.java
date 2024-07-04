import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            String output = calculateNestingDepth(inputString);
            System.out.println(output);
        }
    }

    public static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (char ch : input.toCharArray()) {
            int currentDepth = Character.getNumericValue(ch);
            String depthString = generateDepthString(currentDepth);

            if (previousDepth == 0 || currentDepth == 0) {
                result.append(depthString);
            } else if (previousDepth <= currentDepth) {
                result.delete(result.length() - previousDepth, result.length());
                result.append(depthString.substring(previousDepth));
            } else {
                result.delete(result.length() - currentDepth, result.length());
                result.append(depthString.substring(currentDepth));
            }
            previousDepth = currentDepth;
        }

        return result.toString();
    }

    public static String generateDepthString(int depth) {
        StringBuilder depthBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            depthBuilder.append("(");
        }
        depthBuilder.append(depth);
        for (int i = 0; i < depth; i++) {
            depthBuilder.append(")");
        }
        return depthBuilder.toString();
    }

}
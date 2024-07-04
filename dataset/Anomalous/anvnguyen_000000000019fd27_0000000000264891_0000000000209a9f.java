import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.next();
            String result = buildNestedString(inputString, 0, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String buildNestedString(String s, int min, int previousMin) {
        if (s.isEmpty()) {
            return "";
        }

        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder tempBuilder = new StringBuilder();
        int nextMin = 9;

        for (char c : s.toCharArray()) {
            int currentNum = c - '0';
            if (nextMin > currentNum && currentNum != min) {
                nextMin = currentNum;
            }

            if (currentNum == min) {
                resultBuilder.append(buildNestedString(tempBuilder.toString(), nextMin, min));
                resultBuilder.append(c);
                tempBuilder.setLength(0);
            } else {
                tempBuilder.append(c);
            }
        }

        if (tempBuilder.length() > 0) {
            resultBuilder.append(buildNestedString(tempBuilder.toString(), nextMin, min));
        }

        for (int i = 0; i < min - previousMin; i++) {
            resultBuilder.insert(0, '(');
            resultBuilder.append(')');
        }

        return resultBuilder.toString();
    }
}
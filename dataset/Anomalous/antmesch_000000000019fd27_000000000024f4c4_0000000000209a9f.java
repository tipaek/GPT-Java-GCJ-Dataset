import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String result = processString(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processString(Scanner scanner) {
        StringBuilder output = new StringBuilder();
        String input = scanner.next();
        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }

        int lastLevel = 0;
        numbers.add(0); // Add a trailing zero to close any open parentheses

        for (int i = 0; i < numbers.size(); i++) {
            int currentLevel = numbers.get(i);

            if (currentLevel == lastLevel) {
                output.append(currentLevel);
            } else if (currentLevel > lastLevel) {
                for (int j = 0; j < currentLevel - lastLevel; j++) {
                    output.append("(");
                }
                output.append(currentLevel);
            } else {
                for (int j = 0; j < lastLevel - currentLevel; j++) {
                    output.append(")");
                }
                output.append(currentLevel);
            }

            lastLevel = currentLevel;
        }

        return output.substring(0, output.length() - 1); // Remove the last appended zero
    }
}
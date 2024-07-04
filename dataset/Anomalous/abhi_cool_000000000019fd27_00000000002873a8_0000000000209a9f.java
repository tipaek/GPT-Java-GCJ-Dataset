import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int noOfTestCases;
    private static List<String> listOfStrings = new ArrayList<>();
    private static final String OPEN = "(";
    private static final String CLOSE = ")";

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int i = 0; i < noOfTestCases; i++) {
            String input = listOfStrings.get(i);
            String[] array = input.split("");
            StringBuilder result = new StringBuilder();
            int depth = 0;

            for (String s : array) {
                int value = Integer.parseInt(s);
                while (depth < value) {
                    result.append(OPEN);
                    depth++;
                }
                while (depth > value) {
                    result.append(CLOSE);
                    depth--;
                }
                result.append(value);
            }

            while (depth > 0) {
                result.append(CLOSE);
                depth--;
            }

            System.out.printf("Case #%d: %s%n", i + 1, result.toString());
        }
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        noOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < noOfTestCases; i++) {
            listOfStrings.add(scanner.nextLine());
        }
    }
}
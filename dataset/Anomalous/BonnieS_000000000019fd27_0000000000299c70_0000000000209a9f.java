import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int dataSize = Integer.parseInt(scanner.next());

        for (int caseNumber = 1; caseNumber <= dataSize; caseNumber++) {
            String input = scanner.next();
            ArrayList<Integer> numbers = convertToIntList(input);
            System.out.print("Case #" + caseNumber + ": ");
            printNestedParentheses(numbers);
        }
        scanner.close();
    }

    private static ArrayList<Integer> convertToIntList(String input) {
        ArrayList<Integer> output = new ArrayList<>();
        for (char c : input.toCharArray()) {
            output.add(Character.getNumericValue(c));
        }
        return output;
    }

    private static void printNestedParentheses(ArrayList<Integer> numbers) {
        int currentDepth = 0;
        for (int number : numbers) {
            while (currentDepth < number) {
                System.out.print("(");
                currentDepth++;
            }
            while (currentDepth > number) {
                System.out.print(")");
                currentDepth--;
            }
            System.out.print(number);
        }
        while (currentDepth > 0) {
            System.out.print(")");
            currentDepth--;
        }
        System.out.println();
    }
}
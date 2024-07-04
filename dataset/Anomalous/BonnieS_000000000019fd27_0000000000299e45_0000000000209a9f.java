import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int dataSize = Integer.parseInt(scanner.next());

        for (int i = 1; i <= dataSize; i++) {
            String input = scanner.next();
            List<Integer> numbers = convertToIntList(input);
            System.out.print("Case #" + i + ": ");
            processNumbers(numbers);
            System.out.println();
        }
    }

    private static List<Integer> convertToIntList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private static void processNumbers(List<Integer> numbers) {
        int currentDepth = 0;
        numbers.add(-99); // Sentinel value to handle end of input

        for (int i = 0; i < numbers.size() - 1; i++) {
            int num = numbers.get(i);
            int nextNum = numbers.get(i + 1);

            while (currentDepth < num) {
                System.out.print("(");
                currentDepth++;
            }
            while (currentDepth > num) {
                System.out.print(")");
                currentDepth--;
            }

            System.out.print(num);

            if (nextNum < num) {
                while (currentDepth > nextNum) {
                    System.out.print(")");
                    currentDepth--;
                }
            }
        }

        while (currentDepth > 0) {
            System.out.print(")");
            currentDepth--;
        }
    }
}
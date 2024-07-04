import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            inputs.add(scanner.nextInt());
        }

        for (int number : inputs) {
            List<Integer> digits = new ArrayList<>();
            while (number > 0) {
                digits.add(0, number % 10);
                number /= 10;
            }

            int currentDepth = 0;
            for (int digit : digits) {
                while (currentDepth < digit) {
                    System.out.print("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    System.out.print(")");
                    currentDepth--;
                }
                System.out.print(digit);
            }

            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }

            System.out.println();
        }

        scanner.close();
    }
}
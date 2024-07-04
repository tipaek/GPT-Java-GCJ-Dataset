import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int base = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println(convertToBase10());
        }
    }

    private static String convertToBase10() {
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number);
        }
        return result.toString();
    }
}
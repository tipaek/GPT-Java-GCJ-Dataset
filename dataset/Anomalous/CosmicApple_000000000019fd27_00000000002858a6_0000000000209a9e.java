import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTests = scanner.nextInt();
        int length = scanner.nextInt();

        for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
            int[] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                numbers[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            for (int number : numbers) {
                result.append(number);
            }
            System.out.println(result.toString());

            scanner.next(); // Consuming the next input
        }

        scanner.close();
    }
}
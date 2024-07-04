import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            if (arraySize == 10) {
                int[] numbers = new int[arraySize];

                for (int j = 0; j < arraySize; j++) {
                    System.out.println(j + 1);
                    numbers[j] = scanner.nextInt();
                }

                for (int number : numbers) {
                    System.out.print(number);
                }
                System.out.println();

                scanner.nextLine(); // Consume the newline character left by nextInt()
                String response = scanner.nextLine();
                if (response.equals("N")) {
                    break;
                }
            }
        }
        scanner.close();
    }
}
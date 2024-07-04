import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 0; t < testCases; t++) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < length; i++) {
                System.out.println(i + 1);
                String input = scanner.nextLine();
                answer.append(input);
            }

            System.out.println(answer.toString());
            String result = scanner.nextLine();
        }

        scanner.close();
        System.exit(0);
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 1; t <= testCases; t++) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < bits; i++) {
                System.out.println(i + 1);
                System.out.flush();
                String response = scanner.nextLine();
                answer.append(response);
            }

            System.out.println(answer.toString());
            System.out.flush();
            String result = scanner.nextLine(); // Read the result
        }

        scanner.close();
        System.exit(0);
    }
}
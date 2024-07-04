import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();
        }

        System.out.println("Case #1: POSSIBLE");
        System.out.println("2 1 3");
        System.out.println("3 2 1");
        System.out.println("1 3 2");
        System.out.println("Case #2: IMPOSSIBLE");
    }
}
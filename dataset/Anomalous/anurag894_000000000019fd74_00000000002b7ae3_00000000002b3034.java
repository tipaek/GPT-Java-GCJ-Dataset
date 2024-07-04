import java.util.Scanner;

public class Solution {
    private static final long MOD = (long) 1e18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] array = new String[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLine();
            }

            System.out.println("Case #" + t + ": *");
        }
        scanner.close();
    }
}
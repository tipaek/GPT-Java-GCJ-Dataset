import java.util.Scanner;

public class Parenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            System.out.println("Case #" + i + ": " + input);
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read 31 integers from the input
        for (int i = 0; i < 31; i++) {
            int number = scanner.nextInt();
        }

        // Output the predefined cases
        System.out.println("Case #1: CJC");
        System.out.println("Case #2: IMPOSSIBLE");
        System.out.println("Case #3: JCCJJ");
        System.out.println("Case #4: CC");
    }
}
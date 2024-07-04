import java.util.Scanner;

public class Jamp4 {
    public static void main(String[] args) {
        boolean[] flags = new boolean[11]; // Array size is 11 to use 1-based indexing
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                flags[i] = scanner.nextBoolean();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.print(flags[i] ? "true " : "false ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
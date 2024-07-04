import java.util.Scanner;

public class Solution {

    static final Scanner scanner = new Scanner(System.in);

    static void searchCenter() {
        for (int row = -5; row <= 5; row++) {
            for (int col = -5; col <= 5; col++) {
                System.out.printf("%d %d\n", row, col);
                if (scanner.next().equals("CENTER")) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            searchCenter();
        }

        scanner.close();
    }
}
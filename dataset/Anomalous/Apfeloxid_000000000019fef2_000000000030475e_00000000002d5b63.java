import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCasesAmount = scanner.nextInt();

        for (int test = 0; test < testCasesAmount; test++) {
            solveTestCase(scanner);
        }
    }

    private static void solveTestCase(Scanner scanner) {
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int centerXFrom = -5;
        int centerXTo = 5;
        int centerYFrom = -5;
        int centerYTo = 5;

        for (int x = centerXFrom; x < centerXTo; x++) {
            for (int y = centerYFrom; y < centerYTo; y++) {
                System.out.println(x + " " + y);
                String response = scanner.next();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
}
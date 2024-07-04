import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        for (int i = 0; i < numTests; i++) {
            int testCaseInput = scanner.nextInt();
            System.out.println("Case #" + (i + 1) + ":");

            for (int j = 0; j < testCaseInput; j++) {
                System.out.println((j + 1) + " 1");
            }
        }

        scanner.close();
    }
}
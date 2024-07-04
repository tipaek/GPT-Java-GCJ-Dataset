import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
            int number = scanner.nextInt();
            number -= 1;
            int possible = 1;

            while (number > possible) {
                number -= possible;
                possible++;
            }
            possible--;

            System.out.println("Case #" + (caseIndex + 1) + ":");
            System.out.println("1 1");

            for (int i = 0; i < possible; i++) {
                System.out.println((i + 2) + " 1");
            }

            for (int i = 0; i < number; i++) {
                System.out.println((i + possible + 1) + " 0");
            }
        }
        
        scanner.close();
    }
}
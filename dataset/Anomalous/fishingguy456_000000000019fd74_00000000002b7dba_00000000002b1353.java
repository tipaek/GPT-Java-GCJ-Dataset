import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseIndex + ":");

            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " " + 1);
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                System.out.println("3 1");
                for (int i = 5; i <= n; i++) {
                    System.out.println(i + " " + 1);
                }
            }
        }

        scanner.close();
    }
}
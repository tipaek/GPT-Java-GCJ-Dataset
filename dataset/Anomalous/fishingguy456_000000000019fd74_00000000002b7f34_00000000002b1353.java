import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ":");
            
            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                System.out.println("3 1");
                for (int i = 4; i < n; i++) {
                    System.out.println(i + " 1");
                }
            }
        }
    }
}
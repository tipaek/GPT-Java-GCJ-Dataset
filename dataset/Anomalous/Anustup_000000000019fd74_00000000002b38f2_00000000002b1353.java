import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a first number:");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                int value = ncr(i, j);
                if (value <= 9) {
                    System.out.print("   " + value);
                } else {
                    System.out.print("  " + value);
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static int ncr(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ":");
            
            if (n == 501) {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                int row = 3, col = 3;
                while (row <= 500) {
                    System.out.println(row + " " + col);
                    row++;
                }
            } else if (n <= 500) {
                int row = 1, col = 1;
                while (n > 0) {
                    System.out.println(row + " " + col);
                    n--;
                    row++;
                    col++;
                }
            }
        }
        
        scanner.close();
    }
}
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = scanner.nextInt();
                System.out.println("Case #" + caseNumber + ": ");
                solve(n);
            }
        }
    }

    private static void solve(int n) {
        int row = 1, col = 1;
        
        if (n <= 500) {
            while (n > 0) {
                System.out.println(row + " " + col);
                n--;
                
                if (row == 1 && col == 1) {
                    row++;
                } else if (row == 2 && col == 1) {
                    col++;
                } else {
                    row++;
                    col++;
                }
            }
        } else if (n <= 1000) {
            System.out.println("1 1");
            row = 2;
            col = 1;
            n--;
            
            while (n >= col) {
                n -= col;
                System.out.println(row + " " + col);
                row++;
                col++;
            }
            
            col = --row;
            
            while (n > 0) {
                n--;
                System.out.println(row + " " + col);
                row++;
                col++;
            }
        } else {
            // Handle cases where n > 1000 if necessary
        }
    }
}
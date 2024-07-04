import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNum + ": ");
            processTestCase(n);
        }
    }

    private static void processTestCase(int n) {
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
            System.out.println(1 + " " + 1);
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
            // Handle cases where n > 1000 if needed.
        }
    }
}
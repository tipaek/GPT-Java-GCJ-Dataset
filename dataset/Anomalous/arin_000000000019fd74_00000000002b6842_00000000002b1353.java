import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");

            int row = 1;
            int col = 1;
            System.out.println(row + " " + col);
            n--;

            if (n > 0) {
                System.out.println((row + 1) + " " + col);
                row++;
                n--;
            }

            while (n > 0) {
                if (n >= 3) {
                    System.out.println((row + 1) + " " + (col + 1));
                    System.out.println(row + " " + col);
                    n -= 3;
                } else if (n == 2) {
                    System.out.println((row + 1) + " " + (col + 1));
                    n -= 2;
                } else if (n == 1) {
                    System.out.println((row + 1) + " " + col);
                    n -= 1;
                }
            }
        }
    }
}
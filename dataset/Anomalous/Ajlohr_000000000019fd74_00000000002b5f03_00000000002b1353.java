import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");
            System.out.println("1 1");
            n--;

            int row = 1;
            while (n > 200) {
                row++;
                System.out.println(row + " 2");
                n -= (row - 1);
            }

            if (row == 1) {
                row++;
            }

            while (n > 0) {
                System.out.println(row + " 1");
                row++;
                n--;
            }
        }
    }
}
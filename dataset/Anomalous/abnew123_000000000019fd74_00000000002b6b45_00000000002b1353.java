import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ":");

            if (n <= 501) {
                System.out.println("1 1");
                if (n == 501) {
                    System.out.println("2 2");
                    for (int j = 2; j <= 500; j++) {
                        System.out.println(j + " 1");
                    }
                } else {
                    for (int j = 1; j < n; j++) {
                        System.out.println((j + 1) + " 1");
                    }
                }
            } else {
                if (n < 998) {
                    for (int j = 0; j < 499; j++) {
                        if (j == n - 499) {
                            System.out.println((j + 1) + " 2");
                        } else {
                            System.out.println((j + 1) + " 1");
                        }
                    }
                }
                // The original code has an empty condition for n between 998 and 1000.
                // This can be left out if no specific operations are required.
            }
        }
    }
}
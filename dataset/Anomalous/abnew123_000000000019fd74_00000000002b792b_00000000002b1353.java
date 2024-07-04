import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + caseNum + ":");

            if (n < 501) {
                for (int i = 0; i < n; i++) {
                    System.out.println((i + 1) + " 1");
                }
            } else if (n < 998) {
                for (int i = 0; i < 499; i++) {
                    if (i == n - 499) {
                        System.out.println((i + 1) + " 2");
                    }
                    System.out.println((i + 1) + " 1");
                }
            } else if (n <= 1000) {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                System.out.println("4 2");
                for (int i = 4; i < 499; i++) {
                    if (i == n - 502) {
                        System.out.println((i + 1) + " 2");
                    }
                    System.out.println((i + 1) + " 1");
                }
            }
        }
    }
}
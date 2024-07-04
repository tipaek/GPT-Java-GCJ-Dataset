import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ":");

            if (n < 501) {
                for (int j = 0; j < n; j++) {
                    System.out.println((j + 1) + " 1");
                }
            } else {
                if (n < 998) {
                    for (int j = 0; j < 499; j++) {
                        if (j == n - 499) {
                            System.out.println((j + 1) + " 2");
                        }
                        System.out.println((j + 1) + " 1");
                    }
                } else if (n <= 1000) {
                    for (int k = 0; k < 4; k++) {
                        System.out.println("1 1");
                    }
                    for (int j = 0; j < 499; j++) {
                        if (j == n - 499) {
                            System.out.println((j + 1) + " 2");
                        }
                        System.out.println((j + 1) + " 1");
                    }
                }
            }
        }
    }
}
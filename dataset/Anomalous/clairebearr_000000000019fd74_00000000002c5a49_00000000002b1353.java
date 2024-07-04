import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");
            System.out.println("1 1");

            if (n == 1) {
                continue;
            }

            System.out.println("2 1");
            int sum = 2;
            int row = 3;

            if (sum < n) {
                System.out.println("3 2");
                sum += 2;

                if (n - sum < 7) {
                    while (sum < n) {
                        System.out.println(row + " " + 1);
                        row++;
                        sum++;
                    }
                } else {
                    System.out.println("4 2");
                    System.out.println("5 2");
                    sum = 11;

                    while (sum < n) {
                        System.out.println(row + " " + 1);
                        row++;
                        sum++;
                    }
                }
            }

            while (sum < n) {
                System.out.println(row + " " + 1);
                row++;
                sum++;
            }
        }

        scanner.close();
    }
}
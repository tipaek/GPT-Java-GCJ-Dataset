import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");

            if (N <= 501) {
                for (int i = 0; i < N; i++) {
                    System.out.println((i + 1) + " 1");
                }
            }
        }
    }
}
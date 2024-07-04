import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            System.out.println("Case #" + tc + ":");

            if (N <= 500) {
                for (int i = 1; i <= N; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                for (int i = 1; i <= N - 500; i++) {
                    System.out.println(i + " 1");
                }
                
                System.out.println((N - 500 + 2) + " 2");

                for (int i = N - 500 + 2; i < 500; i++) {
                    System.out.println(i + " 1");
                }
            }
        }

        scanner.close();
    }
}
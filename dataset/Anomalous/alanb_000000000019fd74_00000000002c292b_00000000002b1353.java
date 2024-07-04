import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + (t + 1) + ": ");
            
            if (n < 404) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " 1");
                }
            } else if (n < 911) {
                printPattern1();
                int total = 404;
                for (int i = 11; total < n; i++, total++) {
                    System.out.println(i + " 1");
                }
            } else {
                printPattern2();
                int total = 911;
                for (int i = 12; total < n; i++, total++) {
                    System.out.println(i + " 1");
                }
            }
        }
        
        scanner.close();
    }

    private static void printPattern1() {
        System.out.println("1 1\n" +
                           "2 1\n" +
                           "3 2\n" +
                           "4 2\n" +
                           "5 3\n" +
                           "6 3\n" +
                           "7 4\n" +
                           "8 4\n" +
                           "9 5\n" +
                           "10 5\n" +
                           "10 4\n" +
                           "10 3\n" +
                           "10 2\n" +
                           "10 1");
    }

    private static void printPattern2() {
        System.out.println("1 1\n" +
                           "2 1\n" +
                           "3 2\n" +
                           "4 2\n" +
                           "5 3\n" +
                           "6 3\n" +
                           "7 4\n" +
                           "8 4\n" +
                           "9 5\n" +
                           "10 5\n" +
                           "11 6\n" +
                           "11 5\n" +
                           "11 4\n" +
                           "11 3\n" +
                           "11 2\n" +
                           "11 1");
    }
}
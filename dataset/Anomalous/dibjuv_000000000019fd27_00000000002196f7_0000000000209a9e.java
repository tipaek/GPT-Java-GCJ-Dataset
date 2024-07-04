import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        int B = sc.nextInt(); // Length of the array

        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                handleCaseOfLength10(sc);
            } else if (B == 20) {
                handleCaseOfLength20(sc, B);
            }
        }
    }

    private static void handleCaseOfLength10(Scanner sc) {
        int[] ans = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            ans[i] = sc.nextInt();
        }
        printArray(ans);
        String ok = sc.next(); // Read the response
    }

    private static void handleCaseOfLength20(Scanner sc, int B) {
        int[] ans = new int[20];
        boolean[] same = new boolean[10];

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            ans[i] = sc.nextInt();
            System.out.println(B - i);
            System.out.flush();
            ans[B - i - 1] = sc.nextInt();
            same[i] = (ans[i] == ans[B - i - 1]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            System.out.flush();
            ans[i] = sc.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            ans[B - i - 1] = same[i] ? ans[i] : 1 - ans[i];
        }

        printArray(ans);
        String ok = sc.next(); // Read the response
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value);
        }
        System.out.println();
        System.out.flush();
    }
}
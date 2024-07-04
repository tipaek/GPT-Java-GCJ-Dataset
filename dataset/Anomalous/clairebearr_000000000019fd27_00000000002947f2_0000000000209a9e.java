import java.io.*;
import java.util.*;

public class Solution {

    static int b;
    static int[] arr;
    static boolean complement, reverse, comprev, none;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            b = sc.nextInt();
            arr = new int[b + 1];
            Arrays.fill(arr, -1);

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                arr[i] = sc.nextInt();
            }

            for (int i = b - 4; i <= b; i++) {
                System.out.println(i);
                arr[i] = sc.nextInt();
            }

            if (b == 10) {
                for (int i = 1; i <= b; i++) {
                    System.out.print(i);
                }
                System.out.println();
                continue;
            }

            test(1, 5, sc, false);

            for (int i = 6; i <= 10; i++) {
                System.out.println(i);
                arr[i] = sc.nextInt();
            }

            complement = reverse = comprev = none = true;
            int[] copy = Arrays.copyOf(arr, b + 1);

            for (int i = 6; i <= 10; i++) {
                System.out.println(i);
                int receive = sc.nextInt();
                if (receive != (arr[i] + 1) % 2) complement = false;
                if (receive != arr[i]) none = false;
                copy[i] = receive;
            }

            reverse = comprev = true;
            for (int i = 11; i <= 15; i++) {
                System.out.println(i);
                int receive = sc.nextInt();
                copy[i] = receive;
                if (receive != arr[b - i + 1]) reverse = false;
                if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
            }

            int count = 0;
            if (none) count++;
            if (complement) count++;
            if (reverse) count++;
            if (comprev) count++;

            if (count > 1) {
                complement = reverse = comprev = none = true;
                for (int i = 1; i <= 5; i++) {
                    int receive = sc.nextInt();
                    if (receive != (arr[i] + 1) % 2) complement = false;
                    if (receive != arr[i]) none = false;
                    if (arr[b - i + 1] != -1) {
                        if (receive != arr[b - i + 1]) reverse = false;
                        if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
                    }
                }
            }

            if (none) {
                System.arraycopy(copy, 1, arr, 1, b);
            } else if (complement) {
                for (int i = 1; i <= b; i++) {
                    arr[i] = (copy[i] + 1) % 2;
                    if (i > 5 && i <= 15) arr[i] = copy[i];
                }
            } else if (reverse) {
                for (int i = 1; i <= b; i++) {
                    arr[i] = copy[b - i + 1];
                    if (i > 5 && i <= 15) arr[i] = copy[i];
                }
            } else {
                for (int i = 1; i <= b; i++) {
                    arr[i] = (copy[b - i + 1] + 1) % 2;
                    if (i > 5 && i <= 15) arr[i] = copy[i];
                }
            }

            for (int i = 1; i <= b; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();

            if (sc.next().equals("N")) {
                return;
            }
        }
    }

    static void test(int start, int end, Scanner sc, boolean symmetry) {
        complement = reverse = comprev = none = true;
        int[] copy = Arrays.copyOf(arr, b + 1);

        for (int i = start; i <= end; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            if (receive != (arr[i] + 1) % 2) complement = false;
            if (receive != arr[i]) none = false;
            if (arr[b - i + 1] != -1) {
                if (receive != arr[b - i + 1]) reverse = false;
                if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
            }
        }

        if (!none) {
            if (complement) {
                for (int i = 1; i <= b; i++) {
                    arr[i] = (copy[i] + 1) % 2;
                }
            } else if (reverse) {
                for (int i = 1; i <= b; i++) {
                    arr[i] = copy[b - i + 1];
                }
            } else {
                for (int i = 1; i <= b; i++) {
                    arr[i] = (copy[b - i + 1] + 1) % 2;
                }
            }
        }

        if (symmetry && (none || complement || reverse || comprev)) {
            test(1, 5, sc, false);
        }
    }
}
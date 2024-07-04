import java.io.*;
import java.util.*;

public class Solution {
    
    static int b;
    static int[] arr;
    static boolean complement = true, reverse = true, comprev = true, none = true;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        b = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            arr = new int[b + 1];
            Arrays.fill(arr, -1);

            // Initial read for the first and last 5 elements
            readInitialElements(sc);

            if (b == 10) {
                printArrayAndCheck(sc);
                continue;
            }

            test(1, 5, sc, false);
            readMiddleElements(sc, 6, 10);
            determineTransformations(sc, 6, 10);

            if (multipleTransformations()) {
                determineTransformations(sc, 1, 5);
            }

            applyTransformations();
            printArrayAndCheck(sc);
        }
    }

    static void readInitialElements(Scanner sc) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            arr[i] = sc.nextInt();
        }
        for (int i = b - 4; i <= b; i++) {
            System.out.println(i);
            arr[i] = sc.nextInt();
        }
    }

    static void readMiddleElements(Scanner sc, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            arr[i] = sc.nextInt();
        }
    }

    static void determineTransformations(Scanner sc, int start, int end) {
        complement = true; reverse = true; comprev = true; none = true;
        int[] copy = Arrays.copyOf(arr, b + 1);

        for (int i = start; i <= end; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            if (receive != (arr[i] + 1) % 2) complement = false;
            if (receive != arr[i]) none = false;
            copy[i] = receive;
        }

        reverse = true; comprev = true;
        for (int i = start; i <= end; i++) {
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
            complement = true; reverse = true; comprev = true; none = true;
            for (int i = 1; i <= 5; i++) {
                int receive = sc.nextInt();
                if (receive != (arr[i] + 1) % 2) complement = false;
                if (receive != arr[i]) none = false;
                if (arr[b - i + 1] == -1) continue;
                if (receive != arr[b - i + 1]) reverse = false;
                if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
            }
        }
    }

    static boolean multipleTransformations() {
        int count = 0;
        if (none) count++;
        if (complement) count++;
        if (reverse) count++;
        if (comprev) count++;
        return count > 1;
    }

    static void applyTransformations() {
        int[] copy = Arrays.copyOf(arr, b + 1);

        if (none) {
            for (int i = 1; i <= b; i++) {
                arr[i] = copy[i];
            }
        } else if (complement) {
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

    static void printArrayAndCheck(Scanner sc) {
        for (int i = 1; i <= b; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        String str = sc.next();
        if (str.equals("N")) {
            System.exit(0);
        }
    }

    static void test(int start, int end, Scanner sc, boolean symmetry) {
        complement = true; reverse = true; comprev = true; none = true;
        int[] copy = Arrays.copyOf(arr, b + 1);

        for (int i = start; i <= end; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            if (receive != (arr[i] + 1) % 2) complement = false;
            if (receive != arr[i]) none = false;
            if (arr[b - i + 1] == -1) continue;
            if (receive != arr[b - i + 1]) reverse = false;
            if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
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

        if (symmetry) {
            int count = 0;
            if (none) count++;
            if (complement) count++;
            if (reverse) count++;
            if (comprev) count++;
            if (count > 0) {
                test(1, 5, sc, false);
            }
        }
    }
}
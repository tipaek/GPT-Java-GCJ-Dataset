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

            // Read initial 5 elements
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                arr[i] = sc.nextInt();
            }

            // Read last 5 elements
            for (int i = b - 4; i <= b; i++) {
                System.out.println(i);
                arr[i] = sc.nextInt();
            }

            if (b == 10) {
                printArray();
                if (sc.next().equals("N")) return;
                continue;
            }

            test(1, 5, sc, false);

            for (int i = 6; i <= 10; i++) {
                System.out.println(i);
                arr[i] = sc.nextInt();
            }

            int[] copy = Arrays.copyOf(arr, b + 1);
            evaluateFirstHalf(sc, copy);

            int[] received = new int[b + 1];
            evaluateSecondHalf(sc, copy, received);

            resolveAmbiguity(sc, copy);

            printArray();
            if (sc.next().equals("N")) return;
        }
    }

    static void test(int start, int end, Scanner sc, boolean symmetry) {
        complement = true;
        reverse = true;
        comprev = true;
        none = true;
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

        applyTransformation(copy);

        if (symmetry && (none || complement || reverse || comprev)) {
            test(1, 5, sc, false);
        }
    }

    static void evaluateFirstHalf(Scanner sc, int[] copy) {
        for (int i = 6; i <= 10; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            if (receive != (arr[i] + 1) % 2) complement = false;
            if (receive != arr[i]) none = false;
            copy[i] = receive;
        }
    }

    static void evaluateSecondHalf(Scanner sc, int[] copy, int[] received) {
        reverse = true;
        comprev = true;
        for (int i = 11; i <= 15; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            copy[i] = receive;
            if (receive != arr[b - i + 1]) reverse = false;
            if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
        }
    }

    static void resolveAmbiguity(Scanner sc, int[] copy) {
        int count = getTransformationCount();
        if (count > 1) {
            reevaluateFirstHalf(sc, copy);
        } else {
            applyTransformation(copy);
        }
    }

    static int getTransformationCount() {
        int count = 0;
        if (none) count++;
        if (complement) count++;
        if (reverse) count++;
        if (comprev) count++;
        return count;
    }

    static void reevaluateFirstHalf(Scanner sc, int[] copy) {
        complement = true;
        reverse = true;
        comprev = true;
        none = true;

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            if (receive != (arr[i] + 1) % 2) complement = false;
            if (receive != arr[i]) none = false;
            if (arr[b - i + 1] == -1) continue;
            if (receive != arr[b - i + 1]) reverse = false;
            if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
        }

        applyTransformation(copy);
    }

    static void applyTransformation(int[] copy) {
        if (none) {
            System.arraycopy(copy, 1, arr, 1, b);
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

    static void printArray() {
        for (int i = 1; i <= b; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
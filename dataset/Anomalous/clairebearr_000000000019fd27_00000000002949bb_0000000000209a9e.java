import java.io.*;
import java.util.*;

public class Solution {

    static int b;
    static int[] arr;
    static boolean complement = true, reverse = true, comprev = true, none = true;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        outer: for (int test = 1; test <= t; test++) {
            b = sc.nextInt();
            arr = new int[b + 1];
            Arrays.fill(arr, -1);

            initializeArray(sc, 1, 5);
            initializeArray(sc, b - 4, b);

            if (b == 10) {
                printArray();
                if (sc.next().equals("N")) {
                    return;
                }
                continue outer;
            }

            test(1, 5, sc, false);
            initializeArray(sc, 6, 10);

            boolean[] transformations = new boolean[4];
            int[] received = new int[b + 1];
            testTransformations(sc, 6, 10, received, transformations);

            if (Arrays.stream(transformations).filter(t -> t).count() > 1) {
                test(1, 5, sc, false);
            }

            applyTransformations(received, transformations);

            initializeArray(sc, 11, 15);
            transformations = new boolean[4];
            testTransformations(sc, 11, 15, received, transformations);

            applyTransformations(received, transformations);

            printArray();
            if (sc.next().equals("N")) {
                return;
            }
        }
    }

    static void initializeArray(Scanner sc, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            arr[i] = sc.nextInt();
        }
    }

    static void printArray() {
        for (int i = 1; i <= b; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    static void test(int start, int end, Scanner sc, boolean symmetry) {
        int[] copy = Arrays.copyOf(arr, b + 1);
        resetFlags();

        for (int i = start; i <= end; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            updateFlags(i, receive);
        }

        applyChanges(copy);

        if (symmetry && Arrays.stream(new boolean[]{none, complement, reverse, comprev}).filter(t -> t).count() > 0) {
            test(1, 5, sc, false);
        }
    }

    static void testTransformations(Scanner sc, int start, int end, int[] received, boolean[] transformations) {
        int[] copy = Arrays.copyOf(arr, b + 1);
        resetFlags();

        for (int i = start; i <= end; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            received[i] = receive;
            updateFlags(i, receive);
            copy[i] = receive;
        }

        transformations[0] = none;
        transformations[1] = complement;
        transformations[2] = reverse;
        transformations[3] = comprev;
    }

    static void applyTransformations(int[] received, boolean[] transformations) {
        int[] copy = Arrays.copyOf(arr, b + 1);

        if (transformations[0]) {
            arr = Arrays.copyOf(copy, b + 1);
        } else if (transformations[1]) {
            for (int i = 1; i <= b; i++) {
                arr[i] = (copy[i] + 1) % 2;
                if (i > 5 && i <= 15) {
                    arr[i] = copy[i];
                }
            }
        } else if (transformations[2]) {
            for (int i = 1; i <= b; i++) {
                arr[i] = copy[b - i + 1];
                if (i > 5 && i <= 15) {
                    arr[i] = copy[i];
                }
            }
        } else if (transformations[3]) {
            for (int i = 1; i <= b; i++) {
                arr[i] = (copy[b - i + 1] + 1) % 2;
                if (i > 5 && i <= 15) {
                    arr[i] = copy[i];
                }
            }
        }
    }

    static void resetFlags() {
        complement = true;
        reverse = true;
        comprev = true;
        none = true;
    }

    static void updateFlags(int i, int receive) {
        if (receive != (arr[i] + 1) % 2) complement = false;
        if (receive != arr[i]) none = false;
        if (arr[b - i + 1] == -1) return;
        if (receive != arr[b - i + 1]) reverse = false;
        if (receive != (arr[b - i + 1] + 1) % 2) comprev = false;
    }

    static void applyChanges(int[] copy) {
        if (none) {
            arr = Arrays.copyOf(copy, b + 1);
        } else if (complement) {
            for (int i = 1; i <= b; i++) {
                arr[i] = (copy[i] + 1) % 2;
            }
        } else if (reverse) {
            for (int i = 1; i <= b; i++) {
                arr[i] = copy[b - i + 1];
            }
        } else if (comprev) {
            for (int i = 1; i <= b; i++) {
                arr[i] = (copy[b - i + 1] + 1) % 2;
            }
        }
    }
}
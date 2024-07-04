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

            initializeArray(sc, 1, 5);
            initializeArray(sc, b - 4, b);

            if (b == 10) {
                printArray();
                if (sc.next().equals("N")) return;
                continue;
            }

            test(1, 5, sc, false);
            initializeArray(sc, 6, 10);

            complement = true;
            reverse = true;
            comprev = true;
            none = true;

            int[] copy = Arrays.copyOf(arr, b + 1);
            int[] received = new int[b + 1];

            updateArray(sc, 6, 10, received, copy);
            reverse = true;
            comprev = true;
            updateArray(sc, 11, 15, received, copy);

            int count = countTrueFlags();

            if (count > 1) {
                complement = true;
                reverse = true;
                comprev = true;
                none = true;
                updateArray(sc, 1, 5, received, copy);
                applyTransformation(copy);
            } else {
                applyTransformation(copy);
            }

            printArray();
            if (sc.next().equals("N")) return;
        }
    }

    static void initializeArray(Scanner sc, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            arr[i] = sc.nextInt();
        }
    }

    static void updateArray(Scanner sc, int start, int end, int[] received, int[] copy) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            int receive = sc.nextInt();
            received[i] = receive;
            if (receive != (arr[i] + 1) % 2) complement = false;
            if (receive != arr[i]) none = false;
            copy[i] = receive;
        }
    }

    static int countTrueFlags() {
        int count = 0;
        if (none) count++;
        if (complement) count++;
        if (reverse) count++;
        if (comprev) count++;
        return count;
    }

    static void applyTransformation(int[] copy) {
        if (none) {
            for (int i = 1; i <= b; i++) arr[i] = copy[i];
        } else if (complement) {
            for (int i = 1; i <= b; i++) arr[i] = (copy[i] + 1) % 2;
        } else if (reverse) {
            for (int i = 1; i <= b; i++) arr[i] = copy[b - i + 1];
        } else {
            for (int i = 1; i <= b; i++) arr[i] = (copy[b - i + 1] + 1) % 2;
        }
    }

    static void printArray() {
        for (int i = 1; i <= b; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
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

        if (symmetry) {
            int count = countTrueFlags();
            if (count > 0) test(1, 5, sc, false);
        }
    }
}
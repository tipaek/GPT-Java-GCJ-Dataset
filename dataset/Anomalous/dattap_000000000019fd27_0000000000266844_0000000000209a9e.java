import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] a1 = new int[B];
            int[] b2 = new int[10];

            // Read and process first 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                a1[i] = Integer.parseInt(sc.nextLine());
            }

            // Read and process next 10 bits
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                b2[i] = Integer.parseInt(sc.nextLine());
            }

            // Compare and print results
            if (checkAndPrintResult(a1, b2, B, sc)) continue;
            if (checkAndPrintResult(invertArray(a1), b2, B, sc)) continue;
            if (checkAndPrintResult(reverseArray(a1, B), b2, B, sc)) continue;
            if (checkAndPrintResult(invertArray(reverseArray(a1, B)), b2, B, sc)) continue;
        }
    }

    private static boolean checkAndPrintResult(int[] a, int[] b, int B, Scanner sc) {
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (b[i] == a[i]) cnt++;
        }

        if (cnt == 10) {
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                s1.append(a[i]);
            }
            System.out.println(s1.toString());
            String output = sc.nextLine();
            return output.equals("Y");
        }
        return false;
    }

    private static int[] invertArray(int[] array) {
        int[] inverted = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            inverted[i] = ~array[i];
        }
        return inverted;
    }

    private static int[] reverseArray(int[] array, int B) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[B - i - 1];
        }
        return reversed;
    }
}
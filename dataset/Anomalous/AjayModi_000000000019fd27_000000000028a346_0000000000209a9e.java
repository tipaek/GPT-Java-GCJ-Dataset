import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int it = 1; it <= t; it++) {
            int[] arr1 = new int[b];
            int[] arr2 = new int[b];
            int[] arr3 = new int[b];
            int[] arr4 = new int[b];

            Arrays.fill(arr1, -1);
            Arrays.fill(arr2, -1);
            Arrays.fill(arr3, -1);
            Arrays.fill(arr4, -1);

            for (int ch = 1; ch <= 150; ch += 5) {
                int[] temp = new int[5];
                for (int inp = 0; inp < 5; inp++) {
                    System.out.println(inp + 1);
                    temp[inp] = scanner.nextInt();
                }

                if (processArray(arr1, temp, b, scanner)) break;
                if (processArray(arr2, temp, b, scanner)) break;
                if (processArray(arr3, temp, b, scanner)) break;
                if (processArray(arr4, temp, b, scanner)) break;
            }
        }
    }

    private static boolean processArray(int[] arr, int[] temp, int b, Scanner scanner) {
        int ind = filled(arr);
        if (ind == 0) {
            fillArray(arr, temp, scanner, 5, 10);
        } else if (ind == b - 1 && match(arr, temp)) {
            return printAndCheck(arr, scanner);
        } else if (match(arr, temp)) {
            fillArray(arr, temp, scanner, filled(arr), filled(arr) + 5);
        }

        if (filled(arr) == b - 1) {
            return printAndCheck(arr, scanner);
        }
        return false;
    }

    private static void fillArray(int[] arr, int[] temp, Scanner scanner, int start, int end) {
        System.arraycopy(temp, 0, arr, start - 5, 5);
        for (int inp = start; inp < end; inp++) {
            System.out.println(inp + 1);
            arr[inp] = scanner.nextInt();
        }
    }

    private static boolean printAndCheck(int[] arr, Scanner scanner) {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
        return scanner.next().equals("N");
    }

    private static boolean match(int[] arr, int[] temp) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != temp[i]) return false;
        }
        return true;
    }

    private static int filled(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) return i;
        }
        return arr.length - 1;
    }
}
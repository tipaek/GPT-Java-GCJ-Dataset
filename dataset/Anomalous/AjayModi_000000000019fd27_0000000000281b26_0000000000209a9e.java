import java.util.*;

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

                if (processArray(arr1, temp, scanner, b, ch)) break;
                if (processArray(arr2, temp, scanner, b, ch)) break;
                if (processArray(arr3, temp, scanner, b, ch)) break;
                if (processArray(arr4, temp, scanner, b, ch)) break;
            }
        }
    }

    private static boolean processArray(int[] arr, int[] temp, Scanner scanner, int b, int ch) {
        int ind = filled(arr);
        if (ind == 0) {
            fillArray(arr, temp, scanner, b, ch);
            if (filled(arr) == b - 1) {
                return printAndCheck(arr, scanner, b);
            }
        } else if (ind == b - 1) {
            return printAndCheck(arr, scanner, b);
        } else {
            if (match(arr, temp)) {
                fillArrayFromIndex(arr, filled(arr), scanner, b, ch);
            }
        }
        return false;
    }

    private static void fillArray(int[] arr, int[] temp, Scanner scanner, int b, int ch) {
        System.arraycopy(temp, 0, arr, 0, 5);
        for (int inp = 5; inp < 10; inp++) {
            System.out.println(inp + 1);
            arr[inp] = scanner.nextInt();
        }
        ch += 5;
    }

    private static void fillArrayFromIndex(int[] arr, int startIndex, Scanner scanner, int b, int ch) {
        for (int inp = startIndex; inp < startIndex + 5; inp++) {
            System.out.println(inp + 1);
            arr[inp] = scanner.nextInt();
        }
        ch += 5;
    }

    private static boolean printAndCheck(int[] arr, Scanner scanner, int b) {
        for (int otp : arr) {
            System.out.print(otp);
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
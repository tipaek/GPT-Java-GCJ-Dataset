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

                if (processArray(scanner, arr1, temp, b, ch)) break;
                if (processArray(scanner, arr2, temp, b, ch)) break;
                if (processArray(scanner, arr3, temp, b, ch)) break;
                if (processArray(scanner, arr4, temp, b, ch)) break;
            }
        }
        scanner.close();
    }

    private static boolean processArray(Scanner scanner, int[] arr, int[] temp, int b, int ch) {
        int ind = filled(arr);
        if (ind == 0) {
            System.arraycopy(temp, 0, arr, 0, 5);
            for (int inp = 5; inp < 10; inp++) {
                System.out.println(inp + 1);
                arr[inp] = scanner.nextInt();
            }
            ch += 5;
            if (filled(arr) == b - 1) {
                printArray(arr);
                if (scanner.next().equals("N")) {
                    return true;
                }
            }
        } else if (ind == b - 1) {
            printArray(arr);
            if (scanner.next().equals("N")) {
                return true;
            }
        } else {
            int m = match(arr, temp);
            if (m == 1) {
                int fillin = filled(arr);
                for (int inp = fillin; inp < fillin + 5; inp++) {
                    System.out.println(inp + 1);
                    arr[inp] = scanner.nextInt();
                }
                ch += 5;
            }
        }
        return false;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
        }
        System.out.println();
    }

    public static int match(int[] arr, int[] temp) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != temp[i]) {
                return 0;
            }
        }
        return 1;
    }

    public static int filled(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return arr.length - 1;
    }
}
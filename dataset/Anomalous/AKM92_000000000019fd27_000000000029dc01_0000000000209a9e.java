import java.util.Scanner;

public class Solution {

    public static void printArray(int[] arr, int length, Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
        scanner.nextLine(); // Consume the newline character
    }

    public static void solve(Scanner scanner, int length, int queryCount, int[] arr) {
        if (length <= 9) {
            for (int i = 0; i < length; i++) {
                System.out.println((i + 1));
                arr[i] = scanner.nextInt();
            }
            printArray(arr, length, scanner);
        } else if (length == 10) {
            int[] arr1 = new int[length];
            int[] arr2 = new int[length];
            int[] arr3 = new int[length];

            for (int i = 0; i < length; i++) {
                System.out.println((i + 1));
                arr[i] = scanner.nextInt();
                arr1[i] = (arr[i] == 0) ? 1 : 0;
                arr2[length - i - 1] = arr[i];
                arr3[length - i - 1] = (arr[i] == 0) ? 1 : 0;
            }

            boolean first = true, second = true, third = true, fourth = true;
            int[] checkArr = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1));
                checkArr[i] = scanner.nextInt();
                if (first && arr[i] != checkArr[i]) first = false;
                if (second && arr1[i] != checkArr[i]) second = false;
                if (third && arr2[i] != checkArr[i]) third = false;
                if (fourth && arr3[i] != checkArr[i]) fourth = false;
            }

            if (first) {
                printArray(arr, length, scanner);
            } else if (second) {
                printArray(arr1, length, scanner);
            } else if (third) {
                printArray(arr2, length, scanner);
            } else if (fourth) {
                printArray(arr3, length, scanner);
            }
        } else {
            int[] arr1 = new int[length];
            printArray(arr1, length, scanner);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int length = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = -1;
            }
            System.out.println(1);
            arr[0] = scanner.nextInt();
            solve(scanner, length, 1, arr);
        }
    }
}
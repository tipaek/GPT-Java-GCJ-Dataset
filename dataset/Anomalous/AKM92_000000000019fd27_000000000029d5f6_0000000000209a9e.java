import java.util.Scanner;

public class Solution {

    private static void printArray(int[] arr, int length, Scanner sc) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
        sc.nextLine(); // Consume the remaining newline
        sc.nextLine(); // Consume the next expected input
    }

    private static void solve(Scanner sc, int length, int queryCount, int[] arr) {
        if (length <= 9) {
            for (int i = 0; i < length; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
            }
            printArray(arr, length, sc);
        } else if (length == 10) {
            int[] arr1 = new int[length];
            int[] arr2 = new int[length];
            int[] arr3 = new int[length];

            for (int i = 0; i < length; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
                arr1[i] = (arr[i] == 0) ? 1 : 0;
                arr2[length - i - 1] = arr[i];
                arr3[length - i - 1] = (arr[i] == 0) ? 1 : 0;
            }

            boolean[] matches = {true, true, true, true};
            int[] checkArr = new int[5];

            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1));
                checkArr[i] = sc.nextInt();
                if (matches[0] && arr[i] != checkArr[i]) matches[0] = false;
                if (matches[1] && arr1[i] != checkArr[i]) matches[1] = false;
                if (matches[2] && arr2[i] != checkArr[i]) matches[2] = false;
                if (matches[3] && arr3[i] != checkArr[i]) matches[3] = false;
            }

            if (matches[0]) {
                printArray(arr, length, sc);
            } else if (matches[1]) {
                printArray(arr1, length, sc);
            } else if (matches[2]) {
                printArray(arr2, length, sc);
            } else if (matches[3]) {
                printArray(arr3, length, sc);
            }
        } else {
            int[] arr1 = new int[length];
            printArray(arr1, length, sc);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int length = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] arr = new int[length];
            Arrays.fill(arr, -1);
            System.out.println(1);
            arr[0] = sc.nextInt();
            solve(sc, length, 1, arr);
        }
    }
}
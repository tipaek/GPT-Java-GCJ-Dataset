import java.util.*;

public class Solution {

    public static void printArray(int[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static void solve(Scanner sc, int length, int[] arr) {
        if (length < 10) {
            for (int i = 0; i < length; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
            }
            printArray(arr, length);
        } else if (length == 10) {
            int[] arr1 = new int[length];
            int[] arr2 = new int[length];
            int[] arr3 = new int[length];

            for (int i = 0; i < length; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
                arr1[i] = (arr[i] == 0 ? 1 : 0);
                arr2[length - i - 1] = arr[i];
                arr3[length - i - 1] = (arr[i] == 0 ? 1 : 0);
            }

            boolean isFirst = true, isSecond = true, isThird = true, isFourth = true;
            int[] checkArr = new int[9];
            for (int i = 0; i < 9; i++) {
                System.out.println((i + 1));
                checkArr[i] = sc.nextInt();
                if (isFirst && arr[i] != checkArr[i]) isFirst = false;
                if (isSecond && arr1[i] != checkArr[i]) isSecond = false;
                if (isThird && arr2[i] != checkArr[i]) isThird = false;
                if (isFourth && arr3[i] != checkArr[i]) isFourth = false;
            }
            if (isFirst) {
                printArray(arr, length);
            } else if (isSecond) {
                printArray(arr1, length);
            } else if (isThird) {
                printArray(arr2, length);
            } else if (isFourth) {
                printArray(arr3, length);
            }
        } else {
            int[] arr1 = new int[length];
            printArray(arr1, length);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];
            Arrays.fill(arr, -1);
            System.out.println(1);
            arr[0] = sc.nextInt();

            if (B < 10) {
                for (int j = 0; j < B; j++) {
                    System.out.println((j + 1));
                    arr[j] = sc.nextInt();
                }
                printArray(arr, B);
            } else if (B == 10) {
                int[] arr1 = new int[B];
                int[] arr2 = new int[B];
                int[] arr3 = new int[B];

                for (int j = 0; j < B; j++) {
                    System.out.println((j + 1));
                    arr[j] = sc.nextInt();
                    arr1[j] = (arr[j] == 0 ? 1 : 0);
                    arr2[B - j - 1] = arr[j];
                    arr3[B - j - 1] = (arr[j] == 0 ? 1 : 0);
                }

                boolean isFirst = true, isSecond = true, isThird = true, isFourth = true;
                int[] checkArr = new int[9];
                for (int j = 0; j < 9; j++) {
                    System.out.println((j + 1));
                    checkArr[j] = sc.nextInt();
                    if (isFirst && arr[j] != checkArr[j]) isFirst = false;
                    if (isSecond && arr1[j] != checkArr[j]) isSecond = false;
                    if (isThird && arr2[j] != checkArr[j]) isThird = false;
                    if (isFourth && arr3[j] != checkArr[j]) isFourth = false;
                }
                if (isFirst) {
                    printArray(arr, B);
                } else if (isSecond) {
                    printArray(arr1, B);
                } else if (isThird) {
                    printArray(arr2, B);
                } else if (isFourth) {
                    printArray(arr3, B);
                }
            } else {
                int[] arr1 = new int[B];
                printArray(arr1, B);
            }

            sc.nextLine();
            String response = sc.nextLine();
            if (response.charAt(0) == 'N') break;
        }
    }
}
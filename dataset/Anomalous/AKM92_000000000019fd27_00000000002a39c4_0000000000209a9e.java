import java.util.Scanner;

public class Solution {

    public static void printArray(int[] arr, int B) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    public static void solve(Scanner sc, int B, int[] arr) {
        if (B < 10) {
            for (int i = 0; i < B; i++) {
                System.out.println(i + 1);
                arr[i] = sc.nextInt();
            }
            printArray(arr, B);
        } else if (B == 10) {
            int[] arr1 = new int[B];
            int[] arr2 = new int[B];
            int[] arr3 = new int[B];

            for (int i = 0; i < B; i++) {
                System.out.println(i + 1);
                arr[i] = sc.nextInt();
                arr1[i] = (arr[i] == 0 ? 1 : 0);
                arr2[B - i - 1] = arr[i];
                arr3[B - i - 1] = (arr[i] == 0 ? 1 : 0);
            }

            boolean first = true, second = true, third = true, fourth = true;
            int[] checkArr = new int[9];
            for (int i = 0; i < 9; i++) {
                System.out.println(i + 1);
                checkArr[i] = sc.nextInt();
                if (first && arr[i] != checkArr[i]) first = false;
                if (second && arr1[i] != checkArr[i]) second = false;
                if (third && arr2[i] != checkArr[i]) third = false;
                if (fourth && arr3[i] != checkArr[i]) fourth = false;
            }

            if (first) {
                printArray(arr, B);
            } else if (second) {
                printArray(arr1, B);
            } else if (third) {
                printArray(arr2, B);
            } else if (fourth) {
                printArray(arr3, B);
            }
        } else {
            int[] arr1 = new int[B];
            printArray(arr1, B);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int p = 0; p < T; p++) {
            int[] arr = new int[B];
            for (int j = 0; j < B; j++) {
                arr[j] = -1;
            }

            if (B < 10) {
                for (int i = 0; i < B; i++) {
                    System.out.println(i + 1);
                    arr[i] = sc.nextInt();
                }
                printArray(arr, B);
            } else if (B == 10) {
                int[] arr1 = new int[B];
                int[] arr2 = new int[B];
                int[] arr3 = new int[B];

                for (int i = 0; i < B; i++) {
                    System.out.println(i + 1);
                    arr[i] = sc.nextInt();
                    arr1[i] = (arr[i] == 0 ? 1 : 0);
                    arr2[B - i - 1] = arr[i];
                    arr3[B - i - 1] = (arr[i] == 0 ? 1 : 0);
                }

                boolean first = true, second = true, third = true, fourth = true;
                int[] checkArr = new int[9];
                for (int i = 0; i < 9; i++) {
                    System.out.println(i + 1);
                    checkArr[i] = sc.nextInt();
                    if (first && arr[i] != checkArr[i]) first = false;
                    if (second && arr1[i] != checkArr[i]) second = false;
                    if (third && arr2[i] != checkArr[i]) third = false;
                    if (fourth && arr3[i] != checkArr[i]) fourth = false;
                }

                if (first) {
                    printArray(arr, B);
                } else if (second) {
                    printArray(arr1, B);
                } else if (third) {
                    printArray(arr2, B);
                } else if (fourth) {
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
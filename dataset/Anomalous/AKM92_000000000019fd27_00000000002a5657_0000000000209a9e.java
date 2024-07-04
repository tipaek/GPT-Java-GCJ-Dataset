package googlecodejam;

import java.util.*;

public class Solution {

    public static void printArray(int[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static void solveSegment(Scanner sc, int B, int[] arr, int start) {
        int[] arr1 = new int[B];
        int[] arr2 = new int[B];
        int[] arr3 = new int[B];

        for (int i = 0; i < 5; i++) {
            int index = (start + i) % B;
            System.out.println((index + 1));
            arr[index] = sc.nextInt();
            arr1[index] = arr[index] == 0 ? 1 : 0;
            arr2[B - index - 1] = arr[index];
            arr3[B - index - 1] = arr[index] == 0 ? 1 : 0;
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
            printArray(arr, B);
        } else if (matches[1]) {
            printArray(arr1, B);
        } else if (matches[2]) {
            printArray(arr2, B);
        } else {
            printArray(arr3, B);
        }
    }

    public static void solve(Scanner sc, int B, int[] arr) {
        if (B <= 9) {
            for (int i = 0; i < B; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
            }
            printArray(arr, B);
        } else if (B == 10) {
            solveSegment(sc, B, arr, 0);
        } else if (B <= 20) {
            solveSegment(sc, B, arr, 0);
            solveSegment(sc, B, arr, 5);
        } else {
            int[] arr1 = new int[B];
            printArray(arr1, B);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];
            Arrays.fill(arr, -1);
            solve(sc, B, arr);
            sc.nextLine();
            String response = sc.nextLine();
            if (response.charAt(0) == 'N') break;
        }
    }
}
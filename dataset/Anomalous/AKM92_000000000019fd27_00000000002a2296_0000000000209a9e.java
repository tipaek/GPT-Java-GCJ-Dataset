import java.util.Scanner;

public class Solution {

    public static void printArray(int[] arr, int B) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static void solve(Scanner sc, int B, int[] arr) {
        if (B <= 9) {
            for (int i = 0; i < B; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
            }
            printArray(arr, B);
        } else if (B == 10) {
            int[] arr1 = new int[B];
            int[] arr2 = new int[B];
            int[] arr3 = new int[B];

            for (int i = 0; i < B; i++) {
                System.out.println((i + 1));
                arr[i] = sc.nextInt();
                arr1[i] = (arr[i] == 0 ? 1 : 0);
                arr2[B - i - 1] = arr[i];
                arr3[B - i - 1] = (arr[i] == 0 ? 1 : 0);
            }

            boolean[] checks = {true, true, true, true};
            int[] checkArr = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1));
                checkArr[i] = sc.nextInt();
                if (checks[0] && arr[i] != checkArr[i]) checks[0] = false;
                if (checks[1] && arr1[i] != checkArr[i]) checks[1] = false;
                if (checks[2] && arr2[i] != checkArr[i]) checks[2] = false;
                if (checks[3] && arr3[i] != checkArr[i]) checks[3] = false;
            }

            if (checks[0]) {
                printArray(arr, B);
            } else if (checks[1]) {
                printArray(arr1, B);
            } else if (checks[2]) {
                printArray(arr2, B);
            } else if (checks[3]) {
                printArray(arr3, B);
            }
        } else {
            int[] arr1 = new int[B];
            printArray(arr1, B);
        }

        sc.nextLine();
        String response = sc.nextLine();
        if (response.charAt(0) == 'N') {
            return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int[] arr = new int[B];
            System.out.println(1);
            arr[0] = sc.nextInt();
            solve(sc, B, arr);
        }
    }
}
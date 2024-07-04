import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();

        for (int i = 0; i < t; i++) {
            int n = kb.nextInt();
            int[] b = new int[n];
            int[][] a = new int[n][2];

            for (int j = 0; j < n; j++) {
                a[j][0] = kb.nextInt();
                a[j][1] = kb.nextInt();
                b[j] = j + 1;
            }

            // Sort intervals by start time
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[j][0] > a[k][0]) {
                        swap(a, j, k);
                        swap(b, j, k);
                    }
                }
            }

            char[] c = new char[n];
            int C = -1, J = -1;
            boolean possible = true;

            for (int k = 0; k < n; k++) {
                if (a[k][0] >= C) {
                    c[k] = 'C';
                    C = a[k][1];
                } else if (a[k][0] >= J) {
                    c[k] = 'J';
                    J = a[k][1];
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                // Reorder the result to match the original order
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (b[j] > b[k]) {
                            swap(b, j, k);
                            swap(c, j, k);
                        }
                    }
                }

                String s = new String(c);
                System.out.println("Case #" + (i + 1) + ": " + s);
            }
        }
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
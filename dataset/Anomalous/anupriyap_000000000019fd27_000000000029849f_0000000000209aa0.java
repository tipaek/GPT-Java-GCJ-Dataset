import java.util.Scanner;

public class Solution {

    public static void findIndicium(int index, int n, int k) {
        int[][] arr = new int[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int temp = n - i;
            for (int j = 0; j < n; j++) {
                if (temp <= 0) {
                    temp = n;
                }
                arr[i][j] = temp;
                temp--;

                if (i == j) {
                    count += arr[i][j];
                }
            }
        }

        int tempIndex = index + 1;
        if (count == k) {
            System.out.println("Case #" + tempIndex + ": POSSIBLE");
            for (int[] row : arr) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Case #" + tempIndex + ": IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            findIndicium(i, n, k);
        }
    }
}
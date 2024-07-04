import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            int K = cin.nextInt();
            int firstElement;
            if (K % N != 0) System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else {
                firstElement = K / N;
                int[][] array = new int[N][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (k == 0) array[j][k] = firstElement;
                        if (k != 0 && k + 1 == firstElement) array[j][k] = 1;
                        if (k != 0 && k + 1 != firstElement) array[j][k] = k + 1;
                    }
                }


                for (int j = 0; j < N; j++)
                    for (int k = 0; k < j; k++)
                        array[j] = shift(array[j]);

                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(array[j][k] + " ");
                    }
                    System.out.println();
                }

            }

        }

    }

    public static int[] shift(int arr[]) {
        int b[] = new int[arr.length];
        b[0] = arr[arr.length - 1];
        System.arraycopy(arr, 0, b, 1, arr.length - 1);
        return b;
    }

}
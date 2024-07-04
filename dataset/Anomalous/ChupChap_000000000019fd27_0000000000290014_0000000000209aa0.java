import java.util.*;
import java.io.*;

public class Solution {

    public static void result(int N, int K) {
        int[][] arr = new int[N][N];
        boolean isPossible = false;

        for (int start = 1; start <= N; start++) {
            int sum = 0;
            int v = start;
            
            // Fill the matrix and calculate the diagonal sum
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = ((j + v) % N) + 1;
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
                v++;
            }

            // Check if the diagonal sum matches K
            if (sum == K) {
                System.out.println("POSSIBLE");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                isPossible = true;
                break;
            }
        }

        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Number of test cases
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            System.out.print("Case #" + i + ": ");
            result(N, K);
        }
    }
}
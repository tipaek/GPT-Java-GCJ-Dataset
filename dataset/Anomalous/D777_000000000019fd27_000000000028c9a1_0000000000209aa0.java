import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; ++i) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] arr = new int[N];
            int[][] matrix = new int[N][N];
            boolean isPossible = false;
            String result;

            for (int j = 0; j < N; j++) {
                arr[j] = j + 1;
            }

            if (K % N == 0 && K > N) {
                result = "POSSIBLE";
                isPossible = true;
                int pattern = K / N;

                for (int r = 0; r < N; r++) {
                    for (int p = 0; p < pattern - 1; p++) {
                        rotateArray(arr);
                    }
                    System.arraycopy(arr, 0, matrix[r], 0, N);
                }
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + result);
            if (isPossible) {
                for (int[] row : matrix) {
                    for (int elem : row) {
                        System.out.print(elem + " ");
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }

    private static void rotateArray(int[] arr) {
        int first = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        arr[arr.length - 1] = first;
    }
}
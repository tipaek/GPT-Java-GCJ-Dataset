import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int N = scanner.nextInt();
            int[][] arr = new int[N][N];
            int sum = 0;
            int rows = 0, cols = N;
            int[][] tmpCols = new int[N][N + 1];
            for (int j = 0; j < N; j++) {
                int[] tmp = new int[N + 1];
                boolean ind = true;
                for (int k = 0; k < N; k++) {
                    arr[j][k] = scanner.nextInt();
                    if(tmp[arr[j][k]] != 0) {
                        ind = false;
                    }
                    tmp[arr[j][k]]++;
                    if(tmpCols[k][0] == 0 && tmpCols[k][arr[j][k]] != 0) {
                        cols--;
                        tmpCols[k][0] = -1;
                    }
                    tmpCols[k][arr[j][k]]++;
                }
                if (ind) {
                    rows++;
                }
                sum += arr[j][j];
            }
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + (N - rows) + " " + (N - cols));
        }
    }
}

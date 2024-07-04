import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T, N;
            T = in.nextInt();
            for (int t = 1; t <= T; ++t) {
                int k = 0 , r = 0, c = 0;
                System.out.print("Case #" + t + ": ");
                N = in.nextInt();
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = in.nextInt();
                    }
                }
                for (int i = 0; i < N; i++) {
                    k += matrix[i][i];
                }
                int xor = 0;
                for (int i = 1; i <= N; i++) {
                    xor ^= i;
                }
                for (int i = 0; i < N; i++) {
                    int currentCol = 0, currentRow = 0;
                    for (int j = 0; j < N; j++) {
                        currentRow ^= matrix[i][j];
                        currentCol ^= matrix[j][i];
                    }
                    if (xor != currentCol){
                        c++;
                    }
                    if(xor != currentRow){
                        r++;
                    }
                }
                System.out.println(k + " " + r + " " + c);
            }
        }
    }
}
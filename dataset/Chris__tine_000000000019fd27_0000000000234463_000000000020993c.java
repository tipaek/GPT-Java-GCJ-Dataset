import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            int[] ans = helper(N, matrix);
            System.out.printf("Case #%d: %d %d %d\n", i + 1, ans[0], ans[1], ans[2]);
        }
    }
    
    public static int[] helper(int N, int[][] matrix) {
        int[] ans = new int[3];
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> setR = new HashSet<Integer>();
            boolean sR = false;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    k += matrix[i][j];
                }
                if (!setR.contains(matrix[i][j])) {
                    setR.add(matrix[i][j]);
                } else {
                    sR = true;
                }
            }
            if (sR) {
                r++;
                sR = false;
            }
        }
        
        for (int i = 0; i < N; i++) {
            Set<Integer> setC = new HashSet<Integer>();
            boolean sC = false;
            for (int j = 0; j < N; j++) {
                if (!setC.contains(matrix[j][i])) {
                    setC.add(matrix[j][i]);
                } else {
                    sC = true;
                }
            }
            if (sC) {
                c++;
                sC = false;
            }
        }
        ans[0] = k;
        ans[1] = r;
        ans[2] = c;
        return ans;
    }
}
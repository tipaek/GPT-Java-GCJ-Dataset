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
                for (int i = 0; i < N; i++) {
                    int[] colArr = new int[N], rowArr = new int[N];
                    boolean col = false, row = false;
                    for (int j = 0; j < N; j++) {
                        if (!col){
                            if (colArr[matrix[j][i]-1] == 0){
                                colArr[matrix[j][i]-1]++;
                            }else{
                                col = true;
                            }
                        }
                        if (!row){
                            if (rowArr[matrix[i][j]-1] == 0){
                                rowArr[matrix[i][j]-1]++;
                            }else{
                                row = true;
                            }
                        }
                    }
                    if (col) c++;

                    if (row) r++;
                }
                System.out.println(k + " " + r + " " + c);
            }
        }
    }
}
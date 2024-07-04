import java.util.*;
import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for(int tt = 0; tt < T; tt++) {
            int N = in.nextInt();
            int k,r,c;
            k = r = c = 0;
            int [][]matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                    if(i==j)
                        k += matrix[i][j];
                }
            }
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rows.add(matrix[i][j]);
                    cols.add(matrix[j][i]);
                }
                if (rows.size() != N){
                    r++;
                }
                if (cols.size() != N) {
                    c++;
                }
                rows.clear();
                cols.clear();
            }
            System.out.println("Case #" + (tt+1) + ": " + k + " " + r + " " + c);
        }
    }
    }
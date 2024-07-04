import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int q = 1; q <= T; q++) {
            int N = Integer.parseInt(br.readLine());
            String[] a = new String[N];
            for (int i = 0; i < N; i++) {
                a[i] = br.readLine();
            }
            int[][] mat = new int[N][N];
            int trace=0;
            for (int i = 0; i < N; i++) {
                String[] m = a[i].split(" ");
                for (int j = 0; j < N; j++) {
                    mat[i][j] = Integer.parseInt(m[j]);
                    if(i==j){
                        trace+=mat[i][j];
                    }
                }
            }
            int row_count=0,col_count=0;
            for(int i=0;i<N;i++) {
                Set<Integer> rows = new HashSet<Integer>();
                Set<Integer> col =new HashSet<>();
                for(int j=0;j<N;j++){
                    rows.add(mat[i][j]);
                    col.add(mat[j][i]);
                }
                if(rows.size()!=N){
                    row_count++;
                }
                if(col.size()!=N){
                    col_count++;
                }
            }
            String ans ="Case #"+q+": "+trace+" "+row_count+" "+col_count;
            System.out.println(ans);
        }
    }
}
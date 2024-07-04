import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int z = 1; z <= t; ++z) {
            int N = in.nextInt();
            int[][] mat = new int[N][N];
            int[][] Rcnt = new int[N][N];
            int[][] Ccnt = new int[N][N];
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    mat[i][j] = in.nextInt();
                }
            }
            int trace=0;
            for (int i=0;i<N;i++){
                trace+=mat[i][i];
            }
            int r=0,c=0;
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    Rcnt[i][mat[i][j]-1]++;
                    Ccnt[mat[j][i]-1][i]++;
                }
            }
            for (int i=0;i<N;i++){
                boolean row = false;
                boolean col = false;
                for (int j=0;j<N;j++){
                    if (Rcnt[i][j]==0)row=true;
                    if (Ccnt[j][i]==0)col=true;
                }
                if (row)r++;
                if (col)c++;
            }

            System.out.println("Case #" + z + ": " + trace + " " + r + " " + c );
        }
    }
}
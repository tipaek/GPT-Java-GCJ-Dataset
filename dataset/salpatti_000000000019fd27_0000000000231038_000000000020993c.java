import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    M[j][k] = in.nextInt();
                }
            }

            Set<Integer> rows = new HashSet<Integer>();
            Set<Integer> cols = new HashSet<Integer>();

            int[][] occorrenzeRows = new int[N][N];
            int[][] occorrenzeCols = new int[N][N];

            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    int v = M[j][k];
                    occorrenzeRows[j][v-1]+=1;
                    occorrenzeCols[k][v-1]+=1;
                    if(occorrenzeRows[j][v-1]>1){
                        rows.add(j);
                    }
                    if(occorrenzeCols[k][v-1]>1){
                        cols.add(k);
                    }
                }
            }

            int trace =0;
            for(int j=0;j<N;j++){
                trace += M[j][j];
            }

            int r = rows.size();
            int c = cols.size();

            System.out.println("Case #" + i + ": " + trace + " " + r + " "+c);
        }
    }
}

import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] rowsSquare=new int[n][n];
            int[][] columnsSquare=new int[n][n];
            int trace=0;
            int[] rows=new int[n];
            int[] columns=new int[n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    int x= in.nextInt();
                    if(rowsSquare[j][x-1]==0){
                        rows[j]+=x;
                        rowsSquare[j][x-1]=x;
                    }
                    if(columnsSquare[k][x-1]==0){
                       columns[k]+=x;
                        columnsSquare[k][x-1]=x;
                    }
                    if(k==j){
                        trace+= x;
                    }
                }
            }
            int sum=n*(n+1)/2;
            int dupRows=0,dupColumns =0;
            for(int j=0;j<n;++j){
                if(rows[j]!=sum) dupRows++;
                if(columns[j]!=sum) dupColumns++;
            }
            System.out.println("Case #" + i + ": " + trace + " " + dupRows+ " " + dupColumns);
        }
    }
}
 
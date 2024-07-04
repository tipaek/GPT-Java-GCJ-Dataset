import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int diagsum = 0;
            int[][] col = new int[n][n];
            int u = 0;
            for(int j = 0;j < n;j++)
            {
                int[] row = new int[n];
                HashMap<Integer,Integer> rowc = new HashMap<>();
                int x = 0;
                for(int k = 0;k < n;k++)
                {
                    int v = in.nextInt();
                    if(j==k)
                    {
                        diagsum+=v;
                    }
                    if(x == 0)
                    {
                        if(rowc.get(v) != null)
                        {
                            u++;
                            x++;
                        }
                    }
                    rowc.put(v,v);
                    row[k] = v;
                    col[k][j] = v;
                }
            }
            int uu = 0;
            for (int k = 0;k<col.length;k++) {

                HashMap<Integer,Integer> colc = new HashMap<>();
                int x = 0;
                for(int l = 0;l < col.length;l++)
                {
                    int v = col[k][l];
                    if(colc.get(v) != null)
                    {
                       uu++;
                       break;
                    }
                    colc.put(v,v);
                }
            }
            System.out.println("Case #"+i+": "+diagsum+" "+u+" "+uu);
        }
  }
}
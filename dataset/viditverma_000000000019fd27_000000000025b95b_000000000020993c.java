import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int cases = 1; cases <= test; ++cases) {
            int n =  in.nextInt();
            int ar[][] = new int[n+1][n+1];
            int r =0,c=0;
            for(int i = 0;i<n;i++)
            {
                boolean flag[] = new boolean[n+1];
                boolean DoubleFlag = false;
                for(int j =0;j<n;j++)
                {
                    ar[i][j] = in.nextInt();
                    if(flag[ar[i][j]] && !DoubleFlag)
                    {
                        r++;
                        DoubleFlag = true;
                    }
                    flag[ar[i][j]] = true;
                }
            }
            int diagonal = 0;
            for(int i = 0;i<n;i++)
            {
                diagonal += ar[i][i];
                boolean flag[] = new boolean[n+1];
                boolean DoubleFlag = false;
                for(int j=0;j<n;j++)
                {

                    if(flag[ar[j][i]] && !DoubleFlag)
                    {
                        c++;
                        DoubleFlag = true;
                    }
                    flag[ar[j][i]] = true;
                }
            }
            System.out.println("Case #"+cases+": "+diagonal+" "+r+" "+c);
        }
    }
}
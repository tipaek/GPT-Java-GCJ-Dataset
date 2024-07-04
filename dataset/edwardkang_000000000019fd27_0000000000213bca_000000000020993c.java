import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int r=0;
        int c=0;
        int temp;
        int num;
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] arr = new int[n+1];
            boolean[]columns = new boolean[n];
            boolean[]rows = new boolean[n];
            int trace = 0;
            for (int row =0; row<n; row++)
            {

                for (int col = 1; col<=n; col++)
                {

                    temp = in.nextInt();
                    if(col-row==1)
                    {
                        trace+=temp;
                    }
                    if(arr[temp]==1)
                    {
                        rows[row]=true;
                        columns[col-1]= true;
                    }
                    else
                    {
                        arr[temp]=1;
                    }

                }
                }

            System.out.println("Case #" + i + ": " +trace+" "+ (r ) + " " + (c ));
            }

        }
    }

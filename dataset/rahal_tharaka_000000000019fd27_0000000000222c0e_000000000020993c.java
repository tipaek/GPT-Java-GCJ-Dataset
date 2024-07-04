import java.util.*;
import java.io.*;

public class Solution 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int t=1; t<=tc; t++)
        {
            int n = Integer.parseInt(in.readLine());
            int[][] arr = new int[n][n];
            String[] data;
            int trace = 0, colCount = 0, rowCount = 0;

            ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>(n);
            ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>(n);
            for(int i=0; i<n; i++)
            {
                cols.add(new HashSet<Integer>());
                rows.add(new HashSet<Integer>());
            }

            for(int i=0; i<n; i++)
            {
                data = in.readLine().split(" ");
                for(int j=0; j<n; j++)
                {
                    arr[i][j] = Integer.parseInt(data[j]);
                    if (i==j) trace += arr[i][j];
                    rows.get(i).add(arr[i][j]);
                    cols.get(j).add(arr[i][j]);
                }
            }

            for(int i=0; i<n; i++)
            {
                if (cols.get(i).size()<n) colCount++;
                if (rows.get(i).size()<n) rowCount++;
            }

            System.out.println("Case #"+t+": "+trace+" "+rowCount+" "+colCount);
        }
    }
}
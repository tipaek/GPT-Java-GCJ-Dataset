import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int tt=1;tt<=t;tt++)
        {
            int n = s.nextInt();
            int[][] a = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    a[i][j] = s.nextInt();
            }
            int trace  = 0;
            for(int i=0;i<n;i++)
            trace += a[i][i];
            int row = 0;
            for(int i=0;i<n;i++)
            {
                Set<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++)
                    set.add(a[i][j]);
                if(set.size()!=n)
                    row++;
            }
            int col = 0;
            for(int i=0;i<n;i++)
            {
                Set<Integer> set = new HashSet<>();
                for(int j=0;j<n;j++)
                    set.add(a[j][i]);
                if(set.size()!=n)
                    col++;
            }
            System.out.println("Case #" + tt + ": " + trace + " "+row + " "+col);
        }
    }
}
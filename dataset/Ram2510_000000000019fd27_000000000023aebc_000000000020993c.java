import java.util.*;

public class Solution {
    
    public static int rows(int a[][])
    {
        int rc = 0;
        HashSet<Integer> set;
        for(int i=0;i<a.length;i++)
        {
            set = new HashSet<>();
            for(int j=0;j<a[0].length;j++)
            {
                if(set.contains(a[i][j])) {
                    rc++;
                    break;
                }
                else set.add(a[i][j]);
            }
        }
        return rc;
    }
    
    public static int cols(int a[][])
    {
        int cc = 0;
        HashSet<Integer> set;
        for(int j=0;j<a[0].length;j++)
        {
            set = new HashSet<>();
            for(int i=0;i<a.length;i++)
            {
                if(set.contains(a[i][j])) {
                    cc++;
                    break;
                }
                else set.add(a[i][j]);
            }
        }
        return cc;
    }
    
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int q=1;q<=t;q++) 
        {
            int n = scn.nextInt();
            int k = 0;
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    a[i][j] = scn.nextInt();
                k += a[i][i];
            }
            
            System.out.println("Case #" + q + ": " + k + " " + rows(a) + " " + cols(a));
        }
    }
}
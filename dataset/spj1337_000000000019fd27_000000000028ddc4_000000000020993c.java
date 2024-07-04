/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void solve()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][n];
        int trace = 0, row = 0, col = 0;
        
        for(int i = 0;i < n;i++)
        {
            for(int ii = 0;ii < n;ii++)
            {
                mat[i][ii] = sc.nextInt();
                if(i == ii) trace += mat[i][ii];
            }
        }
        for(int i = 0;i < n;i++)
        {
            Set<Integer> setrow = new HashSet<>();
            for(int j = 0;j < n;j++)
            {
                if(setrow.contains(mat[i][j]))
                {
                    ++row;
                    break;
                }
                setrow.add(mat[i][j]);
            }
        }
        
        for(int i = 0;i < n;i++)
        {
            Set<Integer> setcol = new HashSet<>();
            for(int j = 0;j < n;j++)
            {
                if(setcol.contains(mat[i][j]))
                {
                    ++col;
                    break;
                }
                setcol.add(mat[i][j]);
            }
        }
        
        
        System.out.println(trace + " " + row + " " + col );
    }
	public static void main (String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    int cnt = 1;
	    while(t-- > 0)
	    {
	        System.out.print("Case #" + cnt + ": ");
	        solve();
	        ++cnt;
	    }
	}
}

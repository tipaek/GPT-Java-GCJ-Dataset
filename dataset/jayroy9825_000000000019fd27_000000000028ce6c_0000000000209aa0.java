import java.io.*;
import java.util.*;

public class Solution{

    static int sqr[][]=new int[60][60];
    static int n, k, t;
    static boolean row_safe[][]=new boolean[60][60];
    static boolean col_safe[][]=new boolean[60][60];
    static boolean flag;

    static void solver(int row, int col, int m)
    {
        if(row==n && col==n+1 && m==k && !flag)
        {
            flag=true;
            System.out.println("Case #"+t+ ": POSSIBLE");
            for (int i = 1; i <= n; ++i)
            {
                for (int j = 1; j <= n; ++j)
                {
                    System.out.print(sqr[i][j]+ " ");
                }
                System.out.println();
            }
            return;
        }
        else if(row > n)
        {
            return;
        }
        else if(col > n)
        {
            solver(row + 1, 1, m);
        }
        for(int i = 1; i <= n && !flag; ++i)
        {
            if (!row_safe[row][i] && !col_safe[col][i])
            {
                row_safe[row][i] = col_safe[col][i] = true;
                if (row == col)
                {
                    m += i;
                }
                sqr[row][col] = i;

                solver(row, col + 1, m);

                row_safe[row][i] = col_safe[col][i] = false;
                if (row == col)
                {
                    m -= i;
                }
                sqr[row][col] = 0;
            }
        }
    }

   public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(t=1;t<=T;t++)
        {
            n=sc.nextInt();
            k=sc.nextInt();
            solver(1,1,0);
            if(!flag)
            {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }
            flag=false;
        }
    }
}
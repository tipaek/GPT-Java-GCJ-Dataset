
import java.util.Scanner;


public class Solution 
{
    static int q[][];
    static boolean css[][];
    static int n;
    static int k;
    static int x;
    static boolean done;
    static boolean rss[][];
    public static void sdk(int row, int col, int m) 
    {
        if (row == n && col == n + 1 && m == k && !done) 
        {
            done = true;
            System.out.println("Case #"+x+": "+"POSSIBLE");
            for (int i = 1; i <= n; ++i) 
            {
                for (int j = 1; j <= n; ++j) 
                {
                    System.out.print(q[i][j]+" ");
                }
                System.out.println("");
         }
         return;
        } 
        else if (row > n) 
        {
            return;
        } 
        else if (col > n) 
        {
            sdk(row + 1, 1, m);
        }
        for (int i = 1; i <= n && !done; i++)
        {
            if (!rss[row][i] && !css[col][i]) 
            {
                rss[row][i] = css[col][i]=true;
                if (row == col)
                {
                    m += i;
                }
                q[row][col] = i;
                sdk(row, col + 1, m);
                rss[row][i] = css[col][i]=false;
                if (row == col)
                {
                    m -= i;
                }
                q[row][col] = 0;
            }
        }
    }
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0)
        {
            x++;
            n=sc.nextInt();
            k=sc.nextInt();
            q=new int[n+2][n+2];
            rss=new boolean[n+2][n+2];
            css=new boolean[n+2][n+2];
            done=false;
            sdk(1,1,0);
            if (done==false)
            {
                System.out.println("Case #"+x+": "+"IMPOSSIBLE");
            }
        }
} 
}  


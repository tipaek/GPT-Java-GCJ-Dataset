import java.util.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder pc = new StringBuilder();
        int t = sc.nextInt();
        for(int x=1; x<=t; x=x+1)
        {
            int n = sc.nextInt();
            int r = 0;
            int c = 0;
            int k = 0;
            int a[][] = new int[n][n];
            for(int i=0; i<n; i=i+1)
            {
                HashSet<Integer> h = new HashSet<>(n);
                boolean is = true;
                for(int j=0; j<n; j=j+1)
                {
                    a[i][j] = sc.nextInt();
                    if(i==j)
                    {
                        k = k + a[i][j];
                    }
                    if(h.contains(a[i][j]) && is)
                    {
                        r=r+1;
                        is = false;
                    }
                    else
                    {
                        h.add(a[i][j]);
                    }
                }
            }
            
            for(int i=0; i<n; i=i+1)
            {
                HashSet<Integer> h = new HashSet<>(n);
                boolean is = true;
                for(int j=0; j<n; j=j+1)
                {
                    if(h.contains(a[j][i]) && is)
                    {
                        c=c+1;
                        is = false;
                    }
                    else
                    {
                        h.add(a[j][i]);
                    }
                }
            }
            pc.append("Case #" + x + ": " + k + " " + r + " " + c + "\n");
        }
        System.out.println(pc);
    }
}
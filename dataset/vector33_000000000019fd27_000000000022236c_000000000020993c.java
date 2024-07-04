import java.util.*;
class Solution
{
    public static void main(String s[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x=1;
        while(x++<=t)
        {
            int n = sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    a[i][j]=sc.nextInt();
            
            int diag=0;
            for(int i=0;i<n;i++)
                diag+=a[i][i];
                
            int rows=0,cols=0;
            
            for (int i = 0; i <n; i++)
            { 
                HashSet<Integer> hs = new HashSet<>();
                HashSet<Integer> hs2 = new HashSet<>();
                for (int j = 0; j <n; j++)
                {
                    hs.add(a[i][j]);
                    hs2.add(a[j][i]);
                }
                    
                if (hs.size() < n) 
                    rows++;
                if (hs2.size() < n) 
                    cols++;
            }
            System.out.println("Case #"+(x-1)+": "+diag+" "+rows+" "+cols);
        }
    }
    
}
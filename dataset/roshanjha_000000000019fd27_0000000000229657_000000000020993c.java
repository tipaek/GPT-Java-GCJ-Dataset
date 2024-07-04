import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int x=1; x<=t; x++)
        {
            int n = sc.nextInt();
            int a[][] = new int[n+1][n+1];
            int k=0, r=0, c=0;
            int row[] = new int[n+1];
            int col[] = new int[n+1];
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i=1; i<=n; i++)
            {
                k = k + a[i][i];
                for(int j=1; j<=n; j++)
                {
                    row[a[i][j]] = 1;
                    col[a[j][i]] = 1;
                }
                boolean flag = true;
                for(int j=1; j<=n; j++)
                {
                    if(row[j] == 0 && flag == true)
                    {    
                        r++;
                        flag=false;
                    }
                    row[j] = 0;
                }
                flag = true;
                for(int j=1; j<=n; j++)
                {
                    if(col[j] == 0 && flag == true)
                    {
                        c++;
                        flag = false;
                    }
                    col[j] = 0;
                }
            }
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
            
            
            
            
            
            
            
            
        }
    }
}
import java.util.*;
class mainClass
{
    public static void main(String args[])
    {
        int n;
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int c=1;
        while(c<=t)
        {   
            n = sc.nextInt();
            int trace =0;
            int a[][] = new int[n][n];
            boolean row[] = new boolean[n];
            boolean col[] = new boolean[n];
            int cc=0;
            int rc=0;
            boolean error = false;
            for(int i=0;i<n;i++)
            {
                error = false;
                row = new boolean[n];
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                    if(row[a[i][j]-1])
                        error = true;
                    else
                        row[a[i][j]-1] = true;
                }
                if(error)
                    rc++;
            }
            for(int j=0;j<n;j++)
            {   
                error = false;
                col = new boolean[n];
                for(int i=0;i<n;i++)
                {
                    if(col[a[i][j]-1])
                        error = true;
                    else
                        col[a[i][j]-1] = true;
                }
                if(error)
                    cc++;
            }
            System.out.println("Case #"+c+": "+trace+" "+rc+" "+cc);
            
            c++;
        }
    }
}
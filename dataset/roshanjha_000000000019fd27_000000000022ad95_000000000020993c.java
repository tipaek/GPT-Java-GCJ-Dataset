import java.util.Scanner;
class MainProg
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int x=1; x<=t; x++)
        {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            int k=0, r=0, c=0;
            int row[] = new int[n];
            int col[] = new int[n];
            for(int i=0; i<n; i++)
            {   
                row[i] = 0;
                col[i] = 0;
                for(int j=0; j<n; j++)
                {
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<n; i++)
            {
                k = k + a[i][i];
                for(int j=0; j<n; j++)
                {
                    row[a[i][j]-1] = 1;
                    col[a[j][i]-1] = 1;
                }
                boolean flag = true;
                for(int j=0; j<n; j++)
                {
                    if(row[j] == 0 && flag == true)
                    {    
                        r++;
                        flag=false;
                    }
                    row[j] = 0;
                }
                flag = true;
                for(int j=0; j<n; j++)
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
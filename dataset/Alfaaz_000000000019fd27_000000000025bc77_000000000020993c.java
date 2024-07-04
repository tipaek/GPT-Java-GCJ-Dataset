import java.util.Scanner;

class A
{
    public static void main(String[] args)
    {
        Scanner x=new Scanner(System.in);
        int t=x.nextInt();
        for(int q=1;q<=t;q++)
        {
            int n=x.nextInt();
            int a[][]= new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    a[i][j]=x.nextInt();
            }
            int i,j,s=0,fc=0,fr=0;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(i==j)
                        s=s+a[i][j];
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    for (int k = j+1; k < n; k++)  
                    { 
                        if (a[i][j]== a[i][k] && j != k)  
                        { 
                            fr++;
                            break;
                        } 
                    }
                    
                    for (int k = j+1; k < n; k++)  
                    { 
                        if (a[j][i]== a[k][i] && j != k)  
                        { 
                            fc++;
                            break;
                        } 
                    }
                }
            }
            System.out.println("Case #"+q+": "+s+fr+fc);
        }
    }
}
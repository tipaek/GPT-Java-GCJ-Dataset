import java.util.Scanner;
class Sid
{
    public static void main(String []args)
    {
        Scanner s=new Scanner(System.in);
        int t;
        t=s.nextInt();
        for (int i=1;i<=t;i++)
        {
            int n,m=0,r=0,c=0; 
            n=s.nextInt();
            int a[][] = new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k]=s.nextInt();
                    if (j==k)
                        m=m+a[j][k]; 
                }
            } 
            for (int x=0;x<n;x++)
            {
                outer:
                for(int y=0;y<n-1;y++)
                {
                    for(int z=y+1;z<n;z++)
                    {
                        if (a[x][y]==a[x][z])
                        {
                            r++;
                            break outer; 
                        }
                    }
                }
            }
            for (int p=0;p<n;p++){
                inner:
                for (int q=0;q<n-1;q++){
                    for (int u=q+1;u<n;u++){
                        if(a[q][p]==a[u][p]){
                            c++;
                            break inner;
                        }
                    }
                }
            }
            System.out.println("Case #"+i+": "+m+" "+r+" "+c); 
        }
    }
}

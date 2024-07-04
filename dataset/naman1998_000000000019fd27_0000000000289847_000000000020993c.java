import java.util.*;
class Naman
{
    public void main()
    {
        Scanner y=new Scanner(System.in);
        int t=y.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=y.nextInt();
            int a[][]=new int[n][n];
            int c[]=new int[n];
            int s=0,row=0,col=0,roww=0,coll=0,rt=1,ct=1;
            for(int j=0;j<n;j++)
            {
                c[j]=j+1;
            }
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k]=y.nextInt();
                    if(k==j)
                    s+=a[j][k];
                }
            }
             for(int j=0;j<n;j++)
            {
                for(int r=0;r<n;r++)
                {
                    row=0;col=0;
                for(int k=0;k<n;k++)
                {
                    if(c[r]==a[j][k])
                    row++;
                    if(c[r]==a[k][j])
                    col++;
                }
                if(row>1)
                roww++;
                if(col>1)
                coll++;
                }
            }
            System.out.println("Case #"+(t+1)+": "+s+" "+roww+" "+coll);
        }
    }
}
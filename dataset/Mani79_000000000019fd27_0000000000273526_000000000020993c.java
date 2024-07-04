import java.util.Scanner;
class Test
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int z,i,j,n,k,r,s,x=0,c=0;
        for(z=0;z<t;z++)
        {
            k=0;
            r=0;
            c=0;
            n=sc.nextInt();
            int a[][]=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    {
                        k=k+a[i][j];
                    }
                }
            }
            for(i=0;i<n;i++)
            {
               
                for(j=0;j<n;j++)
                {
                    for(s=j+1;s<n;s++)
                    {
                        if((a[i][j]==a[i][s])&&(s!=j))
                        {
                            r+=1;
                            x=2;
                            break;
                        }
                    }
                    if(x==2)
                    break;
                   
                }
            }
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    for(s=j+1;s<n;s++)
                    {
                        if((a[j][i]==a[s][i])&&(s!=j))
                        {
                            c+=1;
                            x=3;
                            break;
                        }
                        if(x==3)
                        {
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+(z+1)+":"+" "+k+" "+r+" "+c);
            
        }
    }
}
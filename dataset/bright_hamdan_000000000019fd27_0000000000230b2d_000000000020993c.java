import java.util.*;
class jam
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int tt[]=new int[t];
        int rr[]=new int[t];
        int cc[]=new int[t];
        for(int a=0;a<t;a++)
        {
            int n=sc.nextInt();
            int ar[][]=new int[n][n];
            int tr=0,r=0,c=0,z;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    ar[i][j]=sc.nextInt();
                    if(i==j)
                        tr=tr+ar[i][j];
                }
                for(int j=0;j<n-1;j++)
                {
                    z=0;
                    for(int k=j+1;k<n;k++)
                    {
                        if(ar[i][j]==ar[i][k])
                        {
                            r++;
                            z=1;
                            break;
                        }
                        if(z==1)
                            break;
                    }
                }
            }
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    z=0;
                    for(int k=j+1;k<n;k++)
                    {
                        if(ar[j][i]==ar[k][i])
                        {
                            c++;
                            z=1;
                            break;
                        }
                        if(z==1)
                            break;
                    }
                }
            }
            
            rr[a]=r;
            cc[a]=c;
            tt[a]=tr;
            System.out.println("Case #"+(a+1)+": "+tt[a]+" "+rr[a]+" "+cc[a]);
        }
        
        /*for(int a=0;a<t;a++)
        {
            System.out.println("Case #"+(a+1)+": "+tt[a]+" "+rr[a]+" "+cc[a]);
        }*/
        
    }
}

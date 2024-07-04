import java.util.*;
class Vestigium {
    public static void main(String args[])
    {
        int c=0,k=0,a=0,b=0;

        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        if((t>=1)&&(t<=100))
        {
            for(int x=1;x<=t;x++)
            {
                int n=in.nextInt();
                if((n>=2)&&(n<=100))
                {
                    int m[][]=new int[n][n];
                    int z[]=new int[n+1];
                    int y[]=new int[n+1];
                    for(int i=0;i<n;i++)
                    {
                        for(int j=0;j<n;j++)
                        {
                            m[i][j]=in.nextInt();
                            if((m[i][j]>=1)&&(m[i][j]<=n))
                                continue;
                            else
                            {
                                c=1;
                                break;
                            }

                        }
                        if(c==1)
                        {
                            c=0;
                            break;
                        }

                    }
                    for(int i=0;i<n;i++)
                        k=k+m[i][i];
                    int q=0,w=0;
                    for(int i=0;i<n;i++)
                    {
                        for(int j=0;j<n;j++)
                        {
                            z[m[i][j]]++;
                            y[m[j][i]]++;
                        }
                        for(int l=0;l<=n;l++)
                        {
                            if((z[l]>1)&&(q==0))
                            {
                                a++;
                                q=1;
                            }
                            if((y[l]>1)&&(w==0))
                            {
                                b++;
                                w=1;
                            }
                        }

                        for(int s=0;s<=n;s++)
                        {
                            z[s]=0;
                            y[s]=0;
                        }
                        q=0;
                        w=0;
                    }
                    System.out.println("Case #"+x+":"+k+" "+a+" "+b);
                    k=0;
                    a=0;
                    b=0;
                }
                else
                    System.out.println("INPUT OUT OF CONSTRAINTS");
            }
        }
        else
            System.out.println("INPUT OUT OF CONSTRAINTS");

    }
}

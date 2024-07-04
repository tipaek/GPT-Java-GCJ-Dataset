import java.util.Scanner;
class vestigium
{
    public void perform(int k[][])
    {
        int trace=dgsum(k);
        int r=rRep(k);
        int c=cRep(k);
        System.out.println(trace+" "+r+" "+c);
        
    }

    public int dgsum(int k[][])
    {
        int s=0;

        for(int j=0,i=0;j<k.length;j++,i++)
        {
            s+=k[i][j];
        }
        return s;
    }

    public int rRep(int k[][])
    {
        int r=0;
        outer:for(int i=0;i<k.length;i++)
        {
            for(int j=0;j<k.length;j++)
            {
                for(int l=0;l<k.length;l++)
                {
                    if(l==j)
                    continue;
                    if(k[i][j]==k[i][l])
                    {                    
                        r++;
                        continue outer;
                    }
                }
            }

        }
        return r;
    }

    public int cRep(int k[][])
    {
        int c=0;
        for(int i=0;i<k.length;i++)
        {
            outer:for(int j=0;j<k.length;j++)
            {
                for(int l=j+1;l<k.length;l++)
                {
                    if(k[j][i]==k[l][i])
                    {
                        c++;
                        break outer;
                    }
                }
            }

        }
        return c;

    }

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        
        int t=sc.nextInt();
        if(t>=1&&t<=100)
        {
            for(int tm=0;tm<t;tm++)
            {
                
                int n=sc.nextInt();
                if(n>=1&&n<=100)
                {
                    int ar[][]=new int[n][n];
                    int i;
                    boolean flag=true;
                    outer:
                    for(i=0;i<n;i++)
                    {
                        for(int j=0;j<n;j++)
                        {
                            int nm=sc.nextInt();
                            if(nm>=1&&nm<=n)
                            {
                                ar[i][j]=nm;
                            }
                            else
                            {
                                flag=false;
                                System.out.println("Limit Exceeded");
                                break outer;
                            }
                        }
                    }
                    if(flag)
                    {
                        vestigium ob=new vestigium();
                        ob.perform(ar);
                    }

                }
                
            }
        }
       
    }
}
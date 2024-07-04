import java.util.*;

class Solution
{
    static int mod = (int) 1e9 + 7;
    static int Infinity=Integer.MAX_VALUE;
    static int negInfinity=Integer.MIN_VALUE;
    static int j1[]=new int[2000];
    static int c[]=new int [2000];
    static int cc=0;
    static int jj=0;
    public static void main(String args[])
    {
        try
        {
            Scanner d= new Scanner(System.in);
            int t,i,n,j,z;
            String q;
            t=d.nextInt();
            for(i=1;i<=t;i++)
            {
                cc=jj=0;
                Arrays.fill(j1,0);
                Arrays.fill(c,0);
                z=0;
                n=d.nextInt();
                int s[]=new int[n];
                int e[]=new int[n];
                for(j=0;j<n;j++)
                {
                    s[j]=d.nextInt();
                    e[j]=d.nextInt();
                }
                q="";
                for(j=0;j<n;j++)
                {
                    if(check(s[j],e[j])==1)
                    q=q+"J";
                    else if(check1(s[j],e[j])==1)
                    q=q+"C";
                    else
                    {
                        z=1;
                        break;
                    }
                }
                if(z==1)
                System.out.println("Case #"+i+": IMPOSSIBLE");
                else
                System.out.println("Case #"+i+": "+q); 
            }
        }
        catch(Exception e)
        {
            System.out.println(0);
        }
    }
    static int check(int z,int x)
    {
        int i,q;
        q=0;
        for(i=0;i<2000-1;i++)
        {
            if((z>j1[i] && z<j1[i+1] )||(x>j1[i] && x<j1[i+1]))
            {
                q=1;
                break;
            }
        }
        if(q==1)
        return 0;
        else
        {
            j1[jj]=z;
            j1[jj+1]=x;
            jj+=2;
            return 1;
        }
    }
    static int check1(int z,int x)
    {
        int i,q;
        q=0;
        for(i=0;i<2000-1;i++)
        {
            if((z>c[i] && z<c[i+1]) || (x>c[i] && x<c[i+1]))
            {
                q=1;
                break;
            }
        }
        if(q==1)
        return 0;
        else
        {
            c[cc]=z;
            c[cc+1]=x;
            cc+=2;
            return 1;
        }
    }
}
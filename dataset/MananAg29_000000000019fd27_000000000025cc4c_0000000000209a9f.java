import java.util.*;
class Solution
{
    static int mod = (int) 1e9 + 7;
    static int Infinity=Integer.MAX_VALUE;
    static int negInfinity=Integer.MIN_VALUE;
    public static void main(String args[])
    {
        try
        {
            Scanner d= new Scanner(System.in);
            int t,i,l,j,k,p,q;
            t=d.nextInt();
            char ch;
            String s,s1;
            d.nextLine();
            for(i=1;i<=t;i++)
            {
                s=d.nextLine();
                l=s.length();
                j=p=0;
                s1="";
                while(j<l && s.charAt(j)=='0')
                {
                    s1=s1+"0";
                    j++;
                }
                for(k=j;k<l;k++)
                {
                    ch=s.charAt(k);
                    q=(int)ch-48;
                    while(p<q)
                    {
                        s1=s1+"(";
                        p++;
                    }
                    while(p>q)
                    {
                        s1=s1+")";
                        p--;
                    }
                    s1=s1+ch;
                }
                while(p>0)
                {
                    s1=s1+")";
                    p--;
                }
                System.out.println("Case #"+i+": "+s1); 
            }
        }
        catch(Exception e)
        {
            System.out.println(0);
        }
    }

    void sieveOfEratosthenes(int n) 
    { 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 

        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                System.out.print(i + " "); 
        } 
    } 	
} 
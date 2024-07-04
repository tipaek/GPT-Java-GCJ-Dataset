import java.util.*;
class Solution
{
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        int k=1;
        while(t-->0)
        {
            int n = in.nextInt();
            int x[] = new int[n];
            int y[] = new int[n];
            for(int i=0;i<n;i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            
        }
        int num[] = new int[n];
        for(int i=0;i<n;i++)
        num[i] = i;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(x[i]<x[j])
                {
                    int temp=x[i];
                    x[i] = x[j];
                    x[j] = temp;
                    
                    int temp1=y[i];
                    y[i] = y[j];
                    y[j] = temp1;
                    
                    int temp2=num[i];
                    num[i] = num[j];
                    num[j] = temp2;      
                }
            }
        }
        
        
        int Jl = y[0];
        int Cl = 0;
        String str = "J";
        int q;
        for(q=1;q<n;q++)
        {
            if(x[q]>=Jl)
            {str = str+"J"; Jl = y[q];}
            else if(x[q]>=Cl)
            {str = str+"C"; Cl = y[q];}
            else
            {System.out.println("Case #"+k+": IMPOSSIBLE");k++; q=n;}    
        }
        if(q==n+1)
        continue;
        char c[] = new char[n];
        for(int i=0;i<n;i++)
        {
         int a = num[i];
         c[a] = str.charAt(i); 
        }
        String sf="";
        for(int i=0;i<n;i++)
        sf = sf+c[i];
        
        System.out.println("Case #"+k+": "+sf);
        k++;
        }
    }
}
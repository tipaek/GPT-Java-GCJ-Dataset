import java.util.*;

class Verdict
{
    static int diagonal(int[][] m,int n)
    {
        int sum = 0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == j)
                {
                    sum = sum + m[i][j];
                }
            }
        }
        
        return sum;
    }
    
    static void fun(int[][] m,int n)
    {
        int d = diagonal(m,n);
        
        System.out.println(d+" "+0+" "+0);
        
    }
    
    
    public static void main(String args[])
    {
        Scanner x = new Scanner(System.in);
        int t = x.nextInt();
        
        while(t > 0)
        {
            int n = x.nextInt();
            
            int[][] m = new int[n][n];
            
            for(int i=0;i<n;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    m[i][j] = x.nextInt();
                }
            }
            
            fun(m,n);
            
            t--;
            
        }
        
    }
}
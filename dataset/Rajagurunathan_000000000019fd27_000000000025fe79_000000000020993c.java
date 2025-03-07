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
    
    
    static int rowDuplicate(int[][] m,int n)
    {
        int sum = 0;
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> l = new ArrayList<Integer>();
            int flag = 0;
            
            for(int j=0;j<n;j++)
            {
                if( l.contains(m[i][j]))
                {
                    flag=1;
                    break;
                }
                else
                {
                    l.add(m[i][j]);
                }
                
            }
            
            
            if(flag == 1)
            {
                sum++;
            }
            
        }
        
        return sum;
        
    }
    
    
    static int columnDuplicate(int[][] m,int n)
    {
        int sum = 0;
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> l = new ArrayList<Integer>();
            int flag = 0;
            
            for(int j=0;j<n;j++)
            {
                if( l.contains(m[j][i]))
                {
                    flag=1;
                    break;
                }
                else
                {
                    l.add(m[j][i]);
                }
                
            }
            
            
            if(flag == 1)
            {
                sum++;
            }
            
        }
        
        return sum;
        
    }
    
    
    
    
    static void fun(int[][] m,int n,int t)
    {
        int d = diagonal(m,n);
        int r = rowDuplicate(m,n);
        int c = columnDuplicate(m,n);
        
        System.out.println(d+" "+r+" "+c);
        
    }
    
    
    public static void main(String args[])
    {
        Scanner x = new Scanner(System.in);
        int t = x.nextInt();
        
        for(int i=1;i<=t;i++)
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
            
            System.out.print("Case #"+t+": ");
            
            fun(m,n,t);
            
            
        }
        
    }
}
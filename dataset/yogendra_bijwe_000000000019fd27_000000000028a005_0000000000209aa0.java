import java.util.*;
import java.io.*;

class Solution{
    
    static void showMatrix(int n,int k)
    {
         int d = k/n;
	        int i,j;
	        List<Integer> E = new ArrayList<Integer>();
	        for(i=1;i<=n;i++)
	        {
	            E.add(i);
	        }
	        E.remove(new Integer(d));
	        
	        int[][] mat = new int[n][n];
	        for(i=0;i<n;i++)
	        {
	            int x=0;
	            for(j=0;j<n;j++)
	            {
	                if(i == j)
	                {
	                    mat[i][j] = d;
	                }
	                else
	                {
	                    mat[i][j] = E.get(x);
	                    x++;
	                }
	            }
	            x=0;
	            Collections.rotate(E,1);
	        }
	        
	        for(i=0;i<n;i++)
	        {
	            for(j=0;j<n;j++)
	            {
	                System.out.print(mat[i][j]+" ");
	            }
	            System.out.println();
	        }
	        
    }
    
    static void Solver(int n,int k,int t)
    {
        if(k%n != 0 || n<2)
            System.out.println("Case #"+t+": IMPOSSIBLE");
        else
        {
            System.out.println("Case #"+t+": POSSIBLE");
            showMatrix(n,k);
        }
            
        System.out.println();
        
    }
    
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int test =1;
        while(test <= t)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            //System.out.println(n+" "+k);
            Solver(n,k,test);
            test++;
            //t--;
        }
    }
}
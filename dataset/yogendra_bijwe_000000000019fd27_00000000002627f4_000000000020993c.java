import java.util.*;
import java.io.*;

class Solution{

	static int rows(int[][] a,int n)
	{
		int i,j,rep=0,d=0;
		List<Integer> B = new ArrayList<Integer>();
		for(i=0;i<n;i++)
        {
        	for(j=0;j<n;j++)
        	{
        		B.add(a[j][i]);
        	}
        	for(int k=0;k<n;k++)
        	{
        		if(Collections.frequency(B, B.get(k)) > 1)
        			d++;
        	}
        	if(d>=1)
        		rep++;
        	
        	B.clear();
        	d=0;
        }
		
		return rep;
	}
	
	static int columns(int[][] a,int n)
	    {
	        int i,j,rep=0,c=0;
	       List<Integer> A = new ArrayList<Integer>();
	        for(i=0;i<n;i++)
	        {
	        	for(j=0;j<n;j++)
	        	{
	        		A.add(a[i][j]);
	        	}
	        	for(int k=0;k<n;k++)
	        	{
	        		if(Collections.frequency(A, A.get(k)) > 1)
	        			c++;
	        	}
	        	if(c>=1)
	        		rep++;
	        	
	        	A.clear();
	        	c=0;
	        }
	        
	        return rep;
	    }
	
    
    static int trace(int[][] a, int n)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == j)
                    sum += a[i][j];
            }
        }
        return sum;
    }
    
    static void Solver(int[][] a,int n,int t)
    {
        int tr = trace(a,n);
        int col = columns(a,n);
        int row = rows(a,n);
        
        System.out.println("Case #"+t+": "+tr+" "+col+" "+row);
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int test = 1;
        while(test <= t)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            String[] temp = new String[n];
            for(int i=0;i<n;i++)
            {
            	temp[i] = br.readLine();
            }
            
            for(int i=0;i<n;i++)
            {
            	String[] s = temp[i].split(" ");
            	for(int j=0;j<n;j++)
            	{
            		arr[i][j] = Integer.parseInt(s[j]);
            	}
            }
            
            Solver(arr,n,test);
            test++;
            //t--;
        }
    }
}
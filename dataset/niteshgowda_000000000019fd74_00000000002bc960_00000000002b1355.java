import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Solution{
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
	
	static class Pair
	{
		int r;
		int c;
		Pair(int r,int c)
		{
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        int t = sc.nextInt();
        int cnt = 0;
        while(t-- > 0)
        {	
        	cnt++;
        	int r = sc.nextInt();
        	int c = sc.nextInt();
        	
        	int mat[][] = new int[r][c];
        	
        	long il = 0L;
        	long ans = 0L;
        	for(int i = 0; i < r; i++)
        	{
        		for(int j = 0; j < c; j++)
        		{
        			mat[i][j] = sc.nextInt();
        			il += mat[i][j];
        		}
        	}
        	
        	int nl[][] = new int[r][c];
        	int nr[][] = new int[r][c];
        	int na[][] = new int[r][c];
        	int nb[][] = new int[r][c];
        	
        	
        	
        	for(int i = 0; i < r; i ++)
        	{
        		for(int j = 0; j < c; j++)
        		{	
        			int nn = 4;
        			if(i-1 < 0)
        			{
        				na[i][j] = 0;
        				nn--;
        			}
        			else
        			{
        				na[i][j] = mat[i-1][j];
        			}
        			
        			if(i+1 >= r)
        			{
        				nb[i][j] = 0;
        				nn--;
        			}
        			else
        			{
        				nb[i][j] = mat[i+1][j];
        			}
        			
        			if(j+1 >= c)
        			{
        				nr[i][j] = 0;
        				nn--;
        			}
        			else
        			{
        				nr[i][j] = mat[i][j+1];
        			}
        			
        			if(j-1 < 0)
        			{
        				nl[i][j] = 0;
        				nn--;
        			}
        			else
        			{
        				nl[i][j] = mat[i][j-1];
        			}
        			

        			
        		}
        	}
        	
        	ArrayList<Pair> ar = new ArrayList<>();
        	int tnt = 0;
        	//int rnt = 1000;
        	while(true)
        	{
        		
        	ans += il;
        	tnt = 0;
        	//System.out.println(ans+" ans");
        	for(int i = 0; i < r; i ++)
        	{
        		for(int j = 0; j < c; j++)
        		{	
        			int nn = 4;
        			if(na[i][j] == 0)
        			{
        				nn--;
        			}
        			if(nb[i][j] == 0)
        			{
        				nn--;
        			}
        			if(nl[i][j] == 0)
        			{
        				nn--;
        			}
        			if(nr[i][j] == 0)
        			{
        				nn--;
        			}
        			
        			if(nn == 0) continue;
        			double avg = 0.0D;
        			
        			avg += na[i][j]+nb[i][j]+nl[i][j]+nr[i][j];
        			
        			avg /= nn;
        			
        			if(avg > mat[i][j])
        			{	
        				//System.out.println(cnt+" "+i+" "+j);
        				ar.add(new Pair(i,j));
        				il -= mat[i][j];
        				//System.out.println(il);
        				tnt++;
        			}
        		}
        	}
        	
        	for(Pair pr:ar)
        	{
        		int i = pr.r;
        		int j = pr.c;
        		
        		if(na[i][j] != 0)
        		{
        			nb[i-1][j] = nb[i][j];
        		}
        		
        		if(nb[i][j] != 0)
        		{
        			na[i+1][j] = na[i][j];
        		}
        		if(nl[i][j] != 0)
        		{
        			nr[i][j-1] = nr[i][j];
        		}
        		if(nr[i][j] != 0)
        		{
        			nl[i][j+1] = nl[i][j];
        		}
        		
        		na[i][j] = 0;
        		nb[i][j] = 0;
        		nl[i][j] = 0;
        		nr[i][j] = 0;
        	}
        	if(tnt == 0) break;
        }
        	
        	
        	
        	
        	out.println("Case #"+cnt+": "+ans);
        }
        out.close();
	}

}

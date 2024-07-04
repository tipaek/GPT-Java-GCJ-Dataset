import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

 
 
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
		int p;
		int q;
		Pair(int p,int q)
		{
			this.p = p;
			this.q = q;
		}
	}
	
	static int gcd(int a,int b)
	{
		if(a == 0) return b;
		if(b == 0) return a;
		
		return gcd(b,a%b);
	}
	static long gcd(long a,long b)
	{
		if(a == 0) return b;
		if(b == 0) return a;
		
		return gcd(b,a%b);
	}
	static void preCompute(long fact[])
	{
		fact[0] = 1;
		for(int i = 1; i < fact.length; i++)
		{
			fact[i] = i*fact[i-1]%rem;
		}
	}
	static long power(long x, long y, long p) 
    { 
        long res = 1; 
        x = x % p; 
                      
        while (y > 0) 
        {
            if (y % 2 == 1) 
                res = (res * x) % p; 
 
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res; 
    } 
	static long modInverse(long n, long p) 
    { 
        return power(n, p-2, p); 
    }
	
	static long nCrModPFermat(int n, int r, long p) 
	{ 
 
		if (r == 0) 
			return 1; 
 
		return (fact[n]* modInverse(fact[r], p) % p * modInverse(fact[n-r], p) % p) % p; 
	}
	static long rem = (long)(1e9)+7;
	static long fact[];
	
 
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
		FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        
        int t = sc.nextInt();
        int tc = 0;
        while(t-- > 0)
        {	
        	tc++;
        	int n = sc.nextInt();
        	int mat[][] = new int[n][n];
        	
        	int trace = 0;
        	for(int i = 0; i < n; i++)
        	{
        		for(int j = 0; j < n; j++)
        		{
        			mat[i][j] = sc.nextInt();
        			if(i == j) trace += mat[i][j];
        		}
        	}
        	
        	HashSet<Integer> hs = new HashSet<>();
        	
        	int rc = 0;
        	boolean count = false;
        	for(int i = 0; i < n; i++)
        	{		
        		count = false;
        		hs.clear();
        		for(int j = 0; j < n; j++)
        		{
        			if(hs.contains(mat[i][j]))
        			{
        				if(!count)
        				{
        					count = true;
        					rc++;
        				}
        			}
        			
        			else
        			{
        				hs.add(mat[i][j]);
        			}
        		}
        	}
        	
        	int cc = 0;
        	
        	for(int i = 0; i < n; i++)
        	{		
        		count = false;
        		hs.clear();
        		for(int j = 0; j < n; j++)
        		{
        			if(hs.contains(mat[j][i]))
        			{
        				if(!count)
        				{
        					count = true;
        					cc++;
        				}
        			}
        			
        			else
        			{
        				hs.add(mat[j][i]);
        			}
        		}
        	}
        	
        	out.println("Case #"+tc+": "+trace+" "+rc+" "+cc);
        }
        out.close();
	}
 
}
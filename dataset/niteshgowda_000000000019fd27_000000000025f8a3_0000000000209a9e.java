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
	
    // 1,5 3,6 6,18  7,9
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
		FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        
        
        int t = sc.nextInt();
        int b = sc.nextInt();
        int tc = 0;
        outer: while(t-- > 0)
        {	
        	tc++;
        	
        	int ans[] = new int[b+1];
        	int ti[] = new int[b+1];
        	
        	int l = 1;
        	int r = b;
        	int q = 1;
        	int eq = 0;
        	int uneq = 0;
        	int peq = 0;
        	int puneq = 0;
        	for(int i = 0; i < 5; i++)
        	{
        		out.println(l);
        		q++;
        		out.flush();
        		ans[l] = sc.nextInt();
        	
        		
        		out.println(r);
        		q++;
        		out.flush();
        		ans[r] = sc.nextInt();
        		
        		if(ans[l] == ans[r] && eq == 0)
        		{
        			eq = l;
        			peq = ans[eq];
        		}
        		
        		if(ans[l] != ans[r] && uneq == 0)
        		{
        			uneq = l;
        			puneq = ans[uneq];
        		}
        		l++;
        		r--; 
        	}
        	ArrayList<Integer> ar = new ArrayList<>();
        	while(true)
        	{	
        		//initial 2 query for checking operation
        		//op -> 1,same 2,negate 3,swap 4,neg+swap
        		int op = -1;
        		if(eq > 0 && uneq > 0)
        		{	
        			out.println(eq);
        			out.flush();
        			int neq = sc.nextInt();
        			
        			if(peq == neq)
        			{
        				
        				out.println(uneq);
        				out.flush();
        				int nuneq = sc.nextInt();
        				
        				if(puneq == nuneq)
        				{
        					op = 1;
        				}
        				
        				else
        				{
        					op = 3;
        				}
        				puneq = nuneq;
        			}
        			
        			else
        			{
        				
        				out.println(uneq);
        				out.flush();
        				int nuneq = sc.nextInt();
        				
        				if(puneq == nuneq)
        				{
        					op = 4;
        				}
        				
        				else
        				{
        					op = 2;
        				}
        				puneq = nuneq;
        			}
        			peq = neq;
        			ar.add(op);
        			
        		}
        		
        		else if(eq > 0)
        		{
        			out.println(eq);
        			out.flush();
        			int neq = sc.nextInt();
        			
        			if(peq == neq)
        			{
        				op = 1;
        			}
        			else op = 2;
        			
        			ar.add(op);
        			out.println(eq);
        			out.flush();
        			int x = sc.nextInt();
        			peq = neq;
        		}
        		
        		else if(uneq > 0)
        		{
        			out.println(uneq);
        			out.flush();
        			int nuneq = sc.nextInt();
        			
        			if(puneq == nuneq)
        			{
        				op = 1;
        			}
        			else op = 2;
        			ar.add(op);
        			
        			puneq = nuneq;
        			out.println(uneq);
        			out.flush();
        			int x = sc.nextInt();
        		}
        		
        		System.out.println("op "+op);
        		System.out.flush();
        		for(int i = 1; i < l; i++)
        		{	
        			int li = i;
        			int ri = b-i+1;
        			if(op == 2)
        			{
        				ans[li] = 1-ans[li];
        				ans[ri] = 1-ans[ri];
        			}
        			
        			if(op == 3)
        			{
        				int temp = ans[li];
        				ans[li] = ans[ri];
        				ans[ri] = temp;
        			}
        			
        			if(op == 4)
        			{
        				int temp = ans[li];
        				ans[li] = 1-ans[ri];
        				ans[ri] = 1-temp;
        			}
        			System.out.println(li+" "+ri+" "+ans[li]+" "+ans[ri]);
            		System.out.flush();
        		}
        		
        		for(int i = 0; i < 4; i++)
        		{	
        			if(l > r) break;
        			out.println(l);
        			q++;
        			
        			out.flush();
        			ans[l] = sc.nextInt();
        			if(q == 151) break;
        			
        			out.println(r);
        			q++;
        			out.flush();
        			ans[r] = sc.nextInt();
        			if(ans[l] == ans[r] && eq == 0)
        			{
        				eq = l;
        				peq = ans[l];
        			}
        			if(ans[l] != ans[r] && uneq == 0)
        			{
        				uneq = l;
        				puneq = ans[l];
        			}
        			if(q == 151) break;
        			l++;
        			r--; 
        		}
        		
        		if(l > r || q > 150)
        		{
        			break;
        		}
        	}
        	
        	for(int i = 1; i <= b; i++)
        	{
        		out.print(ans[i]);
        	}
        	out.println();
        	out.flush();
        	char x = sc.nextLine().charAt(0);
        	if(x == 'N') break; 
        	
        }
        out.close();
	}
 
}
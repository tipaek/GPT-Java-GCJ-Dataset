import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;

public class Solution implements Runnable 
{
	static class InputReader 
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		public InputReader(InputStream stream) 
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
            
			if (curChar >= numChars) 
			{
				curChar = 0;
				try
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
                
				if(numChars <= 0)               
					return -1;
			}
			return buf[curChar++];
		}
     
		public String nextLine()
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
		public int[] nextArray(int n)
		{
			int arr[] = new int[n];
			int i;
			for(i=0;i<n;i++)
			{
				arr[i] = nextInt();
			}
			return arr;
		}
		public int nextInt() 
		{
			int c = read();
            
			while(isSpaceChar(c)) 
				c = read();
		
			int sgn = 1;
        
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
            
			int res = 0;
			do
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
        
			return res * sgn;
		}
        
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-')
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}	
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-')
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c))
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
    
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
            
			return res.toString();
		}
     
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
     
		public String next()
		{
			return readString();
		}
        
		public interface SpaceCharFilter
		{
			public boolean isSpaceChar(int ch);
		}
	}
	public static void main(String args[]) throws Exception 
	{
		new Thread(null, new Solution(),"Main",1<<27).start();
	}	
	
	static class Pair
	{
		int x,y,ind;
		public Pair(int x,int y,int ind)
		{
			this.x = x;
			this.y = y;
			this.ind = ind;
		}
	}
	
	public void run()	
	{
		InputReader in = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		int t = in.nextInt();
		int resid  = 1;
		while(t-->0)
		{
			StringBuilder s = new StringBuilder(in.next());
			int i,j,k;
			boolean flag = false;
			int a[] = {0,1,2,3,4,5,6,7,8,9};
			s.append("0");
			for(i=0;i<a.length;i++)
			{
				flag = false;
				j=0;
				k=0;
				while(k<s.length())
				{
					if(s.charAt(k)=='(')
					{
						j++;
						k++;
					}
					else if(s.charAt(k)==')')
					{
						if(!flag)
						{
							j++;
							k++;
						}
						else
						{
							s.insert(k,")");
							s.insert(j,"(");
							k = k+3;
							j=k;
							flag = false;
						}
					}
					else if(k==s.length()-1 && Integer.parseInt(s.substring(k,k+1))>a[i])
					{
						s.append(")");
						s.insert(j,"(");
						break;
					}
					else if(Integer.parseInt(s.substring(k,k+1))<=a[i] && !flag)
					{
						k++;
						j++;
					}
					else if(Integer.parseInt(s.substring(k,k+1))>a[i])
					{
						k++;
						flag=true;
					}
					else if(Integer.parseInt(s.substring(k,k+1))<=a[i] && flag)
					{
						s.insert(k,")");
						s.insert(j,"(");
						k+=3;
						j=k;
						flag = false;
					}
				}
			}
			s.delete(s.length()-1,s.length());
			w.println("Case #"+ resid +":" +  " " + s);
			resid++;
		}
		w.flush();
		w.close();
	}
}	
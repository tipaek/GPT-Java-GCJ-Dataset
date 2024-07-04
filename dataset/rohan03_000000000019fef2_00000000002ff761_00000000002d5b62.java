import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;
public class Solution
{
	static class Pair
	{
		int x;
		int y;
		Pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
	}
	static int mod=1000000007;
	public static int[] sort(int[] a)
	{
		int n=a.length;
		ArrayList<Integer> ar=new ArrayList<>();
		for(int i=0;i<a.length;i++)
		{
			ar.add(a[i]);
		}
		Collections.sort(ar);
		for(int i=0;i<n;i++)
		{
			a[i]=ar.get(i);
		}
		return a;
	}
	public static long pow(long a, long b)
    {
        long result=1;
        while(b>0)
        {
            if (b % 2 != 0)
            {
                result=(result*a);
                b--;
            } 
            a=(a*a);
            b /= 2;
        }   
        return result;
    }
	
    public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }   
	public static long lcm(long a, long b)
	{
		return a*(b/gcd(a,b));
	}
	static ArrayList<ArrayList<Integer>> graph;
	static public void main(String args[])throws IOException
	{
		int tt=i();
		StringBuilder sb=new StringBuilder();
		for(int ttt=1;ttt<=tt;ttt++)
		{
			int x=i();
			int y=i();
			if(x==0)
			{
				String s=Integer.toBinaryString(Math.abs(y));
				int count=0;
				for(int i=0;i<s.length();i++)
				{
					if(s.charAt(i)=='1')
						count++;
				}
				if(count!=s.length())
				{
					sb.append("Case #"+ttt+": "+"IMPOSSIBLE\n");
				}
				else
				{
					char[] ans=new char[s.length()];
					for(int i=s.length()-1;i>=0;i--)
					{
						if(y>=0)
							ans[s.length()-1-i]='N';
						else
							ans[s.length()-1-1]='S';
					}
					sb.append("Case #"+ttt+": ");
					for(int i=0;i<s.length();i++)
					{
						if(ans[i]=='E' || ans[i]=='W' || ans[i]=='S' || ans[i]=='N')
						{
							sb.append(ans[i]+"");
						}
					}
					sb.append("\n");
				}
			}
			else if(y==0)
			{
				String s=Integer.toBinaryString(Math.abs(x));
				int count=0;
				for(int i=0;i<s.length();i++)
				{
					if(s.charAt(i)=='1')
						count++;
				}
				if(count!=s.length())
				{
					sb.append("Case #"+ttt+": "+"IMPOSSIBLE\n");
				}
				else
				{
					char[] ans=new char[s.length()];
					for(int i=s.length()-1;i>=0;i--)
					{
						if(x>=0)
							ans[s.length()-1-i]='E';
						else
							ans[s.length()-1-1]='W';
					}
					sb.append("Case #"+ttt+": ");
					for(int i=0;i<s.length();i++)
					{
						if(ans[i]=='E' || ans[i]=='W' || ans[i]=='S' || ans[i]=='N')
						{
							sb.append(ans[i]+"");
						}
					}
					sb.append("\n");
				}
			}
			else
			{
				String s=Integer.toBinaryString(Math.abs(x));
				ArrayList<Integer> ar=new ArrayList<>();
				ArrayList<Integer> ar1=new ArrayList<>();
				char[] ans=new char[40];
				for(int i=s.length()-1;i>=0;i--)
				{
					if(s.charAt(i)=='1')
					{
						if(x>=0)
							ans[s.length()-1-i]='E';
						else
							ans[s.length()-1-i]='W';
					}
					else
					{
						ar.add((int)pow(2,s.length()-1-i));
						ar1.add(s.length()-1-i);
					}
				}
				if(ar.size()==0)
				{
					if(Math.abs(y)==pow(2,s.length()))
					{
						if(y>=0)
							ans[s.length()]='N';
						else
							ans[s.length()]='S';
						sb.append("Case #"+ttt+": ");
						for(int i=0;i<40;i++)
						{
							if(ans[i]=='E' || ans[i]=='W' || ans[i]=='S' || ans[i]=='N')
							{
								sb.append(ans[i]+"");
							}
						}
						sb.append("\n");
					}
					else
					{
						sb.append("Case #"+ttt+": "+"IMPOSSIBLE\n");
					}
				}
				else
				{
					int[] store=findArray(x,y,ar);
					if(store[0]!=0)
					{
						for(int i=0;i<ar.size();i++)
						{
							if(store[i]==1)
								ans[ar1.get(i)]='N';
							else
								ans[ar1.get(i)]='S';
						}
						sb.append("Case #"+ttt+": ");
						for(int i=0;i<40;i++)
						{
							if(ans[i]=='E' || ans[i]=='W' || ans[i]=='S' || ans[i]=='N')
							{
								sb.append(ans[i]+"");
							}
						}
						sb.append("\n");
					}
					else
					{
						ar.add((int)pow(2,s.length()));
						ar1.add(s.length());
						store=findArray(x,y,ar);
						if(store[0]==0)
						{
							sb.append("Case #"+ttt+": "+"IMPOSSIBLE\n");
						}
						else
						{
							for(int i=0;i<ar.size();i++)
							{
								if(store[i]==1)
									ans[ar1.get(i)]='N';
								else
									ans[ar1.get(i)]='S';
							}
							sb.append("Case #"+ttt+": ");
							for(int i=0;i<40;i++)
							{
								if(ans[i]=='E' || ans[i]=='W' || ans[i]=='S' || ans[i]=='N')
								{
									sb.append(ans[i]+"");
								}
							}
							sb.append("\n");
						}
					}
				}
			}
		}
		System.out.print(sb.toString());
	}
	static int[] findArray(int x, int y,ArrayList<Integer> ar)
	{
		int[] store=new int[ar.size()];
		int flag1=0;
		int size=(int)pow(2,ar.size());
		for(int i=0;i<size;i++)
		{
			int[] flag=new int[ar.size()];
			for(int j=0;j<ar.size();j++)
			{
				int num= ((int)pow(2,j) & i);
				if(num!=0)
				{
					flag[j]=1;
				}
			}
			long ans=0;
			for(int j=0;j<ar.size();j++)
			{
				if(flag[j]==1)
				{
					ans+=ar.get(j);
				}
				else
					ans-=ar.get(j);
			}
			if(ans==y)
			{
				flag1=1;
				for(int j=0;j<ar.size();j++)
				{
					if(flag[j]==1)
						store[j]=1;
					else
						store[j]=-1;
				}
			}
		}
		return store;
	}
			/**/
	static InputReader in=new InputReader(System.in);
	static OutputWriter out=new OutputWriter(System.out);
	public static long l()
	{
		String s=in.String();
		return Long.parseLong(s);
	}
	public static void pln(String value)
	{
		System.out.println(value);
	}
	public static int i()
	{
		return in.Int();
	}
	public static String s()
	{
		return in.String();
	}
}
	class InputReader 
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
	 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
	 
		public int read() {
			if (numChars== -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
	 
		public int Int() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
	 
		public String String() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() {
			return String();
		}
	 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	 
	class OutputWriter {
		private final PrintWriter writer;
	 
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
	 
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
	 
		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}
	 
		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}
	 
		public void close() {
			writer.close();
		}
	 
		public void flush() {
			writer.flush();
		}
	 
		}
	 
		class IOUtils {
	 
		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.Int();
			return array;
		}
	 
	} 


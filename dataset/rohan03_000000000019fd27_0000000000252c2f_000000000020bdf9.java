import java.util.*;
import java.io.*;
import java.math.*;
public class Solution
{
	static class Pair
	{
		int x;
		int y;
		int z;
		Pair(int x ,int y,int z)
		{
			this.x=x;
			this.y=y;
			this.z=z;
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
                result=(result*a)%mod;
                b--;
            } 
            a=(a*a)%mod;
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
	static ArrayList<ArrayList<Integer>> graph;
	static public void main(String args[])throws IOException
	{
		int tt=i();
		StringBuilder sb=new StringBuilder();
		for(int ttt=1;ttt<=tt;ttt++)
		{
			int n=i();
			int[] start=new int[n];
			int[] end=new int[n];
			Pair[] pair=new Pair[n];
			for(int i=0;i<n;i++)
			{
				start[i]=i();
				end[i]=i();
				pair[i]=new Pair(start[i],end[i],i);
			}
			Arrays.sort(pair,new Comparator<Pair>(){
				@Override
				public int compare(Pair p1, Pair p2)
				{
					if(p1.x<p2.x)
						return -1;
					if(p1.x==p2.x)
					{
						return p1.y-p2.y;
					}
					return 1;
				}
			});
			int pp=0;
			int flag=0;
			int[] ans=new int[n];
			ans[pair[0].z]=1;
			int index=0;
			int last=pair[0].y;
			int last0=0;
			int last1=pair[0].y;
			for(int i=1;i<n;i++)
			{
				if(last<=pair[i].x)
				{
					ans[pair[i].z]=ans[pair[index].z];
					if(ans[pair[i].z]==0)
					{
						if(last0>pair[i].x)
						{
							pp=1;
							break;
						}
						last0=pair[i].y;
					}
					else
					{
						if(last1>pair[i].x)
						{
							pp=1;
							break;
						}
						last1=pair[i].y;
					}
					last=pair[i].y;
					index=i;
				}
				else if(last>pair[i].x)
				{
					ans[pair[i].z]=1-ans[pair[index].z];
					if(ans[pair[i].z]==0)
					{
						if(last0>pair[i].x)
						{
							pp=1;
							break;
						}
						last0=pair[i].y;
					}
					else
					{
						if(last1>pair[i].x)
						{
							pp=1;
							break;
						}
						last1=pair[i].y;
					}
					if(last>pair[i].y)
					{
						if(i+1<n && pair[i+1].x<pair[i].y)
						{
							pp=1;
							break;
						}
						else
						{
							last=last;
						}
					}
					else if(last<=pair[i].y)
					{
						last=pair[i].y;
						index=i;
					}
				}
			}
			StringBuilder sb1=new StringBuilder();
			for(int i=0;i<n;i++)
			{
				if(ans[i]==0)
					sb1.append("C");
				else
					sb1.append("J");
			}
			if(pp==1)
				sb.append("Case #"+ttt+": "+"IMPOSSIBLE"+"\n");
			else
				sb.append("Case #"+ttt+": "+sb1.toString()+"\n");
		}
		System.out.print(sb.toString());
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


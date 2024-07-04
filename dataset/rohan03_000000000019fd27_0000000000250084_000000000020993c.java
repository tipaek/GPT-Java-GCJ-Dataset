import java.util.*;
import java.io.*;
import java.math.*;
public class Solution
{
	static class Pair
	{
		int x;
		long y;
		Pair(int x ,long y)
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
			int[][] a=new int[n][n];
			int sum=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=i();
					if(i==j)
					{
						sum+=a[i][j];
					}
				}
			}
			int row=0,col=0;
			for(int i=0;i<n;i++)
			{
				int[] count=new int[n+1];
				for(int j=0;j<n;j++)
					count[a[i][j]]++;
				int flag=0;
				for(int j=1;j<=n;j++)
					if(count[j]>1 || count[j]==0)
						flag=1;
				if(flag==1)
					row++;
			}
			for(int i=0;i<n;i++)
			{
				int[] count=new int[n+1];
				for(int j=0;j<n;j++)
					count[a[j][i]]++;
				int flag=0;
				for(int j=1;j<=n;j++)
					if(count[j]>1 || count[j]==0)
						flag=1;
				if(flag==1)
					col++;
			}
			sb.append("Case #"+ttt+": "+sum+" "+row+" "+col+"\n");
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


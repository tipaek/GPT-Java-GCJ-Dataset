import java.util.*;
import java.io.*;
import java.math.*;
public class Solution
{
	static int mod=1000000007;
	static class Pair
    {
        int x;
        int y;
		int z;
		Pair(int x, int y,int z)
        {
            this.x=x;
            this.y=y;
			this.z=z;
        }
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
	static ArrayList<ArrayList<Integer>> graph;
	static public void main(String args[])throws IOException
	{
		int tt=i();
		StringBuilder sb=new StringBuilder();
		for(int ttt=1;ttt<=tt;ttt++)
		{
			int n=i();
			String[] s4=new String[n];
			for(int i=0;i<n;i++)
			{
				s4[i]=s();
			}
			StringBuilder ans=new StringBuilder();
			int max=0;
			for(int i=0;i<n;i++)
			{
				int astric=0;
				for(int j=0;j<s4[i].length();j++)
				{
					if(s4[i].charAt(j)=='*')
					{
						astric++;
					}
				}
				max=Math.max(astric,max);
			}
			int flag=0;
			int tot_div=max+1;
			int[] length=new int[tot_div];
			for(int i=0;i<n;i++)
			{
				int count=0;
				int len=0;
				for(int j=0;j<s4[i].length();j++)
				{
					if(s4[i].charAt(j)=='*')
					{
						length[count]=Math.max(length[count],len);
						count++;
						len=0;
					}
					else
					{
						len++;
					}
				}
				length[count]=Math.max(length[count],len);
			}
			StringBuilder[] s=new StringBuilder[tot_div];
			boolean[] visited=new boolean[tot_div];
			for(int i=0;i<n;i++)
			{
				int count=0;
				int len=0;
				StringBuilder sb1=new StringBuilder();
				for(int j=0;j<s4[i].length();j++)
				{
					if(s4[i].charAt(j)=='*')
					{
						if(count!=0 && count!=len)
						{
							s[count].append(sb1.toString());
						}
						else if(count==0 || count==tot_div-1)
						{							
							if(length[count]==len && visited[count]==false)
							{
								s[count].append(sb1.toString());
								visited[count]=true;
							}
						}
						count++;
						len=0;
						sb1=new StringBuilder();
					}
					else
					{
						sb1.append(s4[i].charAt(j));
						len++;
					}
				}if(count!=0 && count!=len)
						{
							s[count].append(sb1.toString());
						}
						else if(count==0 || count==tot_div-1)
						{							
							if(length[count]==len && visited[count]==false)
							{
								s[count].append(sb1.toString());
								visited[count]=true;
							}
						}
			}
			for(int i=0;i<tot_div;i++)
			{
				ans.append(s[i]);
			}
			String s1=ans.toString();
			for(int i=0;i<n;i++)
			{
				String s2=s4[i];
				if(match(s1,s2)==false)
				{
					flag=1;
					break;
				}
			}
			if(flag==1)
			{
				sb.append("Case #"+ttt+": *"+"\n");
			}
			else
			{
				sb.append("Case #"+ttt+": "+ans.toString()+"\n");
			}
		}
		System.out.print(sb.toString());
	}
	static boolean match(String s1,String s2)
	{
		int astric=0;
		for(int i=0;i<s2.length();i++)
		{
			if(s2.charAt(i)=='*')
				astric++;
		}
		int tot=astric+1;
		StringBuilder sb1=new StringBuilder();
		String[] s=new String[tot];
		int count=0;
		for(int i=0;i<s2.length();i++)
		{
			if(s2.charAt(i)=='*')
			{
				s[count]=sb1.toString();
				count++;
				sb1=new StringBuilder();
			}
			else
			{
				sb1.append(s2.charAt(i));
			}
		}
		if(count<tot)
			s[count]=sb1.toString();
		StringBuilder sb=new StringBuilder();
		int index=0;
		if(!matchLeft(s1,s[0]) || !matchRight(s1,s[tot-1]))
			return false;
		
		return true;
	}
	static boolean matchLeft(String s1,String s2)
	{
		StringBuilder sb=new StringBuilder();
		StringBuilder sb1=new StringBuilder();
		for(int i=0;i<s2.length();i++)
		{
			if(s2.charAt(i)=='*')
				break;
			else
				sb.append(s2.charAt(i));
		}
		sb1.reverse();
		if(sb.toString().equals(s1.substring(0,sb.toString().length()))==false)
			return false;
		return true;
	}
	static boolean matchRight(String s1,String s2)
	{
		StringBuilder sb1=new StringBuilder();
		for(int i=s2.length()-1;i>=0;i--)
		{
			if(s2.charAt(i)=='*')
				break;
			else
				sb1.append(s2.charAt(i));
		}
		sb1.reverse();
		if(sb1.toString().equals(s1.substring(s1.length()-sb1.toString().length(),s1.length()))==false)
			return false;
		return true;
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
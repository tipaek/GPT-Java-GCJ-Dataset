import java.io.*;
import java.util.*;

public class Solution
{
	public static int get(String s, int i) {
		return Integer.parseInt(String.valueOf(s.charAt(i)));
	}
	public static void main(String[] args) throws IOException
	{
		Scan in = new Scan();
		Print out = new Print();
		int t = in.scanInt();
		for(int c = 1; c <= t; c++)
		{
			out.print("Case #" + c + ": ");
			String s = in.scanString();
			StringBuilder sb = new StringBuilder();
			int n = s.length();
			int open = 0;
			for(int i=0; i<n; i++) {
				int x = get(s, i);
				for(int j=open; j<x; j++) {
					sb.append("(");
				}
				open = x;
				sb.append(x);
				if(i<(n-1)) {
					for(int j=open; j>get(s, i+1); j--) {
						sb.append(")");
						open--;
					}
				}
			}
			for(int i=0; i<open; i++) {
				sb.append(")");
			}
			out.println(sb);
		}
		out.close();
	}
}

class Scan
{
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	public Scan()
	{
		in=System.in;
	}
	public int scan()throws IOException
	{
		if(total<0)
			throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
				return -1;
		}
		return buf[index++];
	}
	public int scanInt()throws IOException
	{
		int integer=0;
		int n=scan();
		while(isWhiteSpace(n))
			n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n))
		{
			if(n>='0'&&n<='9')
			{
				integer*=10;
				integer+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		return neg*integer;
	}
	public double scanDouble()throws IOException
	{
		double doub=0;
		int n=scan();
		while(isWhiteSpace(n))
			n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n)&&n!='.')
		{
			if(n>='0'&&n<='9')
			{
				doub*=10;
				doub+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		if(n=='.')
		{
			n=scan();
			double temp=1;
			while(!isWhiteSpace(n))
			{
				if(n>='0'&&n<='9')
				{
					temp/=10;
					doub+=(n-'0')*temp;
					n=scan();
				}
				else throw new InputMismatchException();
			}
		}
		return doub*neg;
	}
	public String scanString()throws IOException
	{
		StringBuilder sb=new StringBuilder();
		int n=scan();
		while(isWhiteSpace(n))
			n=scan();
		while(!isWhiteSpace(n))
		{
			sb.append((char)n);
			n=scan();
		}
		return sb.toString();
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
			return true;
		return false;
	}
}

class Print
{
	private final BufferedWriter bw;
	public Print()
	{
		this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void print(Object object)throws IOException
	{
		bw.append(""+object);
	}
	public void println(Object object)throws IOException
	{
		print(object);
		bw.append("\n");
	}
	public void close()throws IOException
	{
		bw.close();
	}
}
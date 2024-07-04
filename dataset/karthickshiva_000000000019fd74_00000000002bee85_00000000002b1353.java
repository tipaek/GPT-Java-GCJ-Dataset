import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		Scan in = new Scan();
		Print out = new Print();
		int t = in.scanInt();
		int cs = 0;
		while(t-- > 0)
		{
			cs++;
			out.println("Case #" + cs + ":");
			int n = in.scanInt();
			int ind = 1;
			int sum = 1;
			int side = 0;
			while(n>0)
			{
				if(n>sum)
				{
					if(side != 0)
						for(int i=0; i<ind; i++)
							out.println(ind + " " + (i+1));
                    else
						for(int i=0; i<ind; i++)
							out.println(ind + " " + (i+1));
						n -= sum;
						side ^= 1;
				}
				else
				{
					if(side != 0)
						out.println(ind + " " + ind);
					else
						out.println(ind + " " + 1);
					n--;
				}
				ind++;
				sum*=2;
			}
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
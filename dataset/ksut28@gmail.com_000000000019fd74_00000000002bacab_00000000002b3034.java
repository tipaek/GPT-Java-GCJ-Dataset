
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scan sc = new Scan();
		int testCases = sc.scanInt();
		
		for (int  t = 1; t<=testCases; t++) {
	  		int i,j,k,n, ind, flag=0, flag2=0;
	  		n = sc.scanInt();
	  		String ans="",temp="" ;
	  		List<Character> l = new ArrayList<>();
	  		List<Character> l1 = new ArrayList<>();
	  		
	  		String []s = new String[n];
	  		for(i = 0;i<n;i++) {
	  			s[i] = sc.scanString();
	  		}
	  		
	  		for(i = 0;i<n;i++)
	  		{
	  			k=0;
	  			j=0;
	  			ind=l.size();
	  			flag=0;
	  			flag2=0;
	  			while(s[i].charAt(j)!='*' && j<s[i].length())
	  			{
	  				if(j<ind && l.get(j)!=s[i].charAt(j))
	  				{
	  					flag=1;
	  					break;
					  }
					if(j>=ind)
					{
						l.add(s[i].charAt(j));
					}
	  				j++;
				  }
				if(flag>0)
				{
					flag2=1;
					break;
				}
	  			
			  }
			  if(flag2>0)
			  {
				  System.out.println("*");
			  	continue ;
			  }
			  for(i = 0;i<n;i++)
	  		{
	  			k=0;
	  			j=s[i].length()-1;
	  			ind=l1.size();
	  			flag=0;
	  			flag2=0;
	  			while(s[i].charAt(j)!='*' && j>=0)
	  			{
	  				if(s[i].length()-1-j<ind && l1.get(s[i].length()-1-j)!=s[i].charAt(j))
	  				{
	  					flag=1;
	  					break;
					  }
					if(s[i].length()-1-j >=ind)
					{
						l1.add(s[i].charAt(j));
					}
	  				j--;
				  }
				if(flag>0)
				{
					flag2=1;
					break;
				}
	  			
			  }
			  if(flag2>0)
			  {
			  	System.out.println("*");
			  	continue ;
			  }
			  
			  for(i = 0;i<n;i++)
			  {
			  	flag=0;
			  	j=0;
			  	while(j<s[i].length())
			  	{
			  		if(s[i].charAt(j)=='*')
			  		{
			  			flag=1;
			  			j++;
					  }
					if(flag>0)
					{
						while(j<s[i].length() && s[i].charAt(j)!='*')
						{
							temp+=s[i].charAt(j);
							j++;
						}
						if(j!=s[i].length())
						{
							ans+=temp;
							temp="";
						}
						flag=0;
					}
					else
					{
						j++;
					}
					  
					  
				  }
			  }
			  for(i = 0;i<l.size();i++)
			  {
			  	ans=l.get(l.size()-1-i)+ans;
			  }
			  for(i = 0;i<l1.size();i++)
			  {
			  	ans=ans+l1.get(l1.size()-1-i);
			  }
			  System.out.println("Case #"+t+": "+ans);
	  	
		}
	}
}

class Scan {
	private byte[] buf = new byte[1024];
	private int index;
	private InputStream in;
	private int total;

	public Scan() {
		in = System.in;
	}

	public int scan() throws IOException {
		if (total < 0)
			throw new InputMismatchException();
		if (index >= total) {
			index = 0;
			total = in.read(buf);
			if (total <= 0)
				return -1;
		}
		return buf[index++];
	}

	public int scanInt() throws IOException {
		int integer = 0;
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		return neg * integer;
	}

	public double scanDouble() throws IOException {
		double doub = 0;
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n) && n != '.') {
			if (n >= '0' && n <= '9') {
				doub *= 10;
				doub += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		if (n == '.') {
			n = scan();
			double temp = 1;
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					temp /= 10;
					doub += (n - '0') * temp;
					n = scan();
				} else
					throw new InputMismatchException();
			}
		}
		return doub * neg;
	}

	public String scanString() throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		while (!isWhiteSpace(n)) {
			sb.append((char) n);
			n = scan();
		}
		return sb.toString();
	}

	private boolean isWhiteSpace(int n) {
		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
			return true;
		return false;
	}
}

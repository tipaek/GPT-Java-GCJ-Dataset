import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;


public class Solution {

	public static Scan fr = new Scan();
	public static OutputWriter op = new OutputWriter();

	public static String s1,s2;
	public static int l1,l2;
	public static Map<String,op> dp;
	public static int mn,df;
	public static String ans;

	public static void main(String[] args) throws IOException {

		int i,j,k;
		int T;
		T=fr.scanInt();
		dp = new HashMap<>();
		for (int cs = 1; cs <= T; cs++) {

			s1 = fr.scanString();
			s2 = fr.scanString();
			l1 = s1.length();
			l2 = s2.length();
			dp.clear();
			df=mn = 1000000000;
			
			System.out.print("Case #"+cs+": ");			
			
			fun1(0,0,0,"");
			
			System.out.println(ans);
			
		}
	}
	public static op fun1(int p1, int p2, int cur, String curStr) {
		op o = null;
		if(dp.containsKey(p1+":"+p2+":"+cur)) {
			o = dp.get(p1+":"+p2+":"+cur);
		} else {
			o = new op();
			if(p1==l1) {
				o.rem = l2-p2;
				o.st = "";
			}
			else if(p2==l2) {
				o.rem = l1-p1;			
				o.st = s1.substring(p1);
			}
			else {
				op n;
				if(s1.charAt(p1) == s2.charAt(p2)) {
					n = fun1(p1+1,p2+1,cur, curStr+s1.charAt(p1));
					o.rem = n.rem;
					o.st=s1.substring(p1);
				} else {
					n = fun1(p1+1,p2,cur+1, curStr);
					o.rem=n.rem;
					o.st=s1.substring(p1);
					
					n = fun1(p1,p2+1,cur+1, curStr+s2.charAt(p2));
					if(n.rem<o.rem) {
						o.rem=n.rem;
						o.st=s1.substring(p1);
					}
					n = fun1(p1+1,p2+1,cur+1, curStr+s2.charAt(p2));
					if(n.rem<o.rem) {
						o.rem=n.rem;
						o.st=s1.substring(p1);
					}
					o.rem++;
				}
			}
			dp.put(p1+":"+p2+":"+cur, o);
		}
		if(cur+o.rem < mn) {
			mn = cur+o.rem;
			df = Math.abs(cur-o.rem);
			ans = curStr + s1.substring(p1);
//			System.out.println("ans="+ans+" p1="+p1+" p2="+p2+" cur="+cur+" rem="+o.rem);
		} else if(cur+o.rem == mn && Math.abs(cur-o.rem) < df) {
			mn = cur+o.rem;
			df = Math.abs(cur-o.rem);
			ans = curStr + s1.substring(p1);			
//			System.out.println("ans="+ans+" p1="+p1+" p2="+p2+" cur="+cur+" rem="+o.rem);
		}
		
		return o;
	}

	
	public static op fun(int p1, int p2, int cur, String curStr) {
		op o = null;
		if(dp.containsKey(p1+":"+p2+":"+cur)) {
			o = dp.get(p1+":"+p2+":"+cur);
		} else {
			o = new op();
			if(p1==l1) {
				o.rem = l2-p2;
				o.st = "";
			}
			else if(p2==l2) {
				o.rem = l1-p1;			
				o.st = "";
			}
			else {
				if(s1.charAt(p1) == s2.charAt(p2)) {
					o = fun(p1+1,p2+1,cur, curStr+s1.charAt(p1));
					o.st = s1.charAt(p1) + o.st;
				} else {
					o = fun(p1+1,p2,cur+1, curStr);
					op n = fun(p1,p2+1,cur+1, curStr);
					if(n.rem<o.rem)
						o=n;
					n = fun(p1+1,p2+1,cur+1, curStr+s1.charAt(p1));
					if(n.rem<o.rem) {
						o=n;
						o.st = s1.charAt(p1)+o.st;
					}
				}
			}
			dp.put(p1+":"+p2+":"+cur, o);
		}
		if(cur+o.rem < mn) {
			mn = cur+o.rem;
			df = Math.abs(cur-o.rem);
			ans = curStr + s1.substring(p1);
		} else if(cur+o.rem == mn && Math.abs(cur-o.rem) < df) {
			mn = cur+o.rem;
			df = Math.abs(cur-o.rem);
			ans = curStr + s1.substring(p1);			
		}
		
		return o;
	}
	static class op {
		int rem;
		String st;
	}
	
	static class OutputWriter {
		private final PrintWriter writer;
 
		public OutputWriter() {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));			
		}
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

	
	static class Scan
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
	    public long scanLong()throws IOException
	    {
	        long integer=0;
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
}

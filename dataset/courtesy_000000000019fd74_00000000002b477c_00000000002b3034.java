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


	public static void main(String[] args) throws IOException {

		int i,j,k;
		int T;
		T=fr.scanInt();
		for (int cs = 1; cs <= T; cs++) {
			int N = fr.scanInt();
			String[] ss = new String[N];
			for(i=0;i<N;i++)
				ss[i]=fr.scanString();

			System.out.print("Case #"+cs+": ");			

			boolean retF = false;
			StringBuilder sbF = new StringBuilder();
			for(i=0;i<N;i++) {
				for(j=0;j<ss[i].length() && j<sbF.length();j++) {
					if(ss[i].charAt(j) == '*')
						break;
					if(ss[i].charAt(j) != sbF.charAt(j)) {
						retF = true;
						break;
					}
				}
				if(retF)
					break;
				
				for(;j<ss[i].length() && ss[i].charAt(j)!='*';j++) {
					sbF.append(ss[i].charAt(j));
				}
				
			}
			if(retF) {
				System.out.println("*");
				continue;
			}
			
			retF = false;
			StringBuilder sbE = new StringBuilder();
			for(i=0;i<N;i++) {
				for(j=ss[i].length()-1,k=0;j>=0 && k<sbE.length();j--,k++) {
					if(ss[i].charAt(j) == '*')
						break;
					if(ss[i].charAt(j) != sbE.charAt(k)) {
						retF = true;
						break;
					}
				}
				if(retF)
					break;
				
				for(;j>=0  && ss[i].charAt(j)!='*';j--) {
					sbE.append(ss[i].charAt(j));
				}
				
			}
			if(retF) {
				System.out.println("*");
				continue;
			}
			
			List<StringBuilder> sbL = new ArrayList<>();
			for(i=0;i<N;i++) {
				String[] sl = ss[i].split("\\*");
				if(sl.length >= 3) {
					for(j=1;j<sl.length-1;j++) {
						StringBuilder sb = null;
						if(j-1<sbL.size()) {
							sb = sbL.get(j-1);
						} else {
							sb = new StringBuilder();
							sbL.add(sb);
						}
						sb.append(sl[j]);
					}
				}
			}
			StringBuilder ans = new StringBuilder();
			ans.append(sbF);
			for(StringBuilder sb : sbL) {
				ans.append(sb);
			}
			ans.append(sbE.reverse());
			
			System.out.println(ans.toString());
			
		}
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

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
			long[][] P = new long[N][2];
			for(i=0;i<N;i++) {
				P[i][0]=fr.scanLong();
				P[i][1]=fr.scanLong();
			}
			int ans = fun(N,P);
			
			
			
			System.out.println("Case #"+cs+": "+ans);			
		}
	}
	
	private static int fun(int N, long[][] P) {
		int i,j,k;
		int mx=1;
		for(i=0;i<N;i++) {
			for(j=i+1;j<N;j++) {
				boolean[] F = new boolean[N];
				
				int pairs = 0;
				int rem = 0;
				for(k=0;k<N;k++) {
					if(F[k])
						continue;
					
					F[k]=true;
					int cur = 1;
					for(int kk=0;kk<N;kk++) {
						if(F[kk])
							continue;
						if(same(i,j,k,kk,P)) {
							F[kk]=true;
							cur++;
						}
					}
					pairs+=cur/2;
					if(cur>1 && cur%2==1)
						rem++;
				}
				int tot = pairs*2;
				if(rem%2==0)
					tot+=rem;
				else
					tot+=rem-1;
				tot = Math.min(tot+2, N);
				mx=Math.max(mx, tot);
			}
		}
		return mx;
		
	}

	private static boolean same(int p11, int p12, int p21, int p22, long[][] p) {
		int i,j,k;
		int t1,t2,t3;
		if(p[p11][1]>p[p12][1]) {
			k=p11;
			p11=p12;
			p12=k;
		}
		if(p[p21][1]>p[p22][1]) {
			k=p21;
			p21=p22;
			p22=k;
		}
		long x1d = p[p12][0]-p[p11][0];
		long y1d = p[p12][1]-p[p11][1];
		long x2d = p[p22][0]-p[p21][0];
		long y2d = p[p22][1]-p[p21][1];
		if(y1d*x2d == y2d*x1d)
			return true;
		
		return false;
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

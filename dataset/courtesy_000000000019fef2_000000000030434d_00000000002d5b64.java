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
			int R = fr.scanInt();
			int S = fr.scanInt();
			if(R*S>20)
				return;
			List<Pair> ans = fun(R,S);
			System.out.println("Case #"+cs+": ");
			for(Pair p : ans) {
				System.out.println(p.x+" "+p.y);
			}
		}
	}
	
	
	
	private static List<Pair> fun(int R, int S) {
		Map<String,Pair> dp = new HashMap<>();
		String st = "";
		String en = "";
		int i,j,k;
		for(i=0;i<S;i++) {
			for(j=1;j<=R;j++)
				st+=j;
		}
		for(i=1;i<=R;i++) {
			for(j=0;j<S;j++)
				en+=i;
		}
		dp.put(st, new Pair(0,0));
		Queue<String> Q = new LinkedList<>();
		Q.add(st);
		boolean found = false;
		while(!Q.isEmpty()) {
			String cur = Q.remove();
			for(i=1;i<cur.length();i++) {
				for(j=1;i+j<=cur.length();j++) {
					String nw = cur.substring(i, i+j) + cur.substring(0,i);
					if(i+j<cur.length())
						nw+=cur.substring(i+j);
					if(!dp.containsKey(nw)) {
						dp.put(nw, new Pair(i,j));
						Q.add(nw);
					}
					if(nw.equals(en)) {
						found = true;
						break;
					}
				}
				if(found)
					break;
			}
			if(found)
				break;
		}
		List<Pair> ans = new ArrayList<>();
		while(!en.equals(st)) {
			Pair p = dp.get(en);
			i=p.y;j=p.x;
			String nw = en.substring(i, i+j) + en.substring(0,i);
			if(i+j<en.length())
				nw+=en.substring(i+j);
			ans.add(p);
			en=nw;
		}
		
 		Collections.reverse(ans);
 		return ans;
	}



	static class Pair {
		int x,y;
		Pair(int xx,int yy) {
			x=xx;y=yy;
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

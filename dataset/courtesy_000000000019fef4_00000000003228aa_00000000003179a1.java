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


	public static void main(String[] args) throws Exception {

		int i,j,k;
		int T;
		T=fr.scanInt();
		for (int cs = 1; cs <= T; cs++) {
			int U = fr.scanInt();
			Map<Character,Set<Integer>> map = new HashMap<>();
			
			for(i=0;i<10000;i++) {
				String M = fr.scanString();
				String R = fr.scanString();
				fun(M,R,map);
			}
			String ans = fnd1(map);
			System.out.println("Case #"+cs+": "+ans);			
		}
	}
	
	private static void fun(String m, String r, Map<Character, Set<Integer>> map) {
		for(int i=0;i<r.length();i++) {
			if(!map.containsKey(r.charAt(i))) {
				Set<Integer> st = new HashSet<>();
				map.put(r.charAt(i),st);
				for(int j=0;j<=9;j++) {
					st.add(j);
				}											
			}
		}
		if(m.length() == r.length()) {
			Set<Integer> st = map.get(r.charAt(0));
			int k = m.charAt(0)-'0';
			st.remove(0);
			for(int i=k+1;i<=9;i++) {
				st.remove(i);
			}				
		}
	}
	private static String fnd1(Map<Character, Set<Integer>> map) throws Exception {
		int i,j,k;
		char[] ans = new char[10];
		Set<Integer> taken = new HashSet<>();
		for(i=0;i<10;i++) {
			List<Character> pos = new ArrayList<>();
			for(j=0;j<26;j++) {
				char cur = (char) ('A'+j);
				if(map.containsKey(cur)) {
					Set<Integer> st = map.get(cur);
					st.removeAll(taken);
					if(st.contains(i)) {
						if(st.size()==1) {
							pos.clear();
							pos.add(cur);
							break;
						}
						pos.add(cur);						
					}
				}
			}
			if(pos.size()>1) {
				
				throw new Exception();
			}
			taken.add(i);
			ans[i] = pos.get(0);
//			System.out.println(i+" -> "+pos.get(0));
		}
		return new String(ans);
	}

	private static String fnd(Map<Character, Set<Integer>> map) throws Exception {
		int i,j,k;
		char[] ans = new char[10];
		Set<Integer> taken = new HashSet<Integer>();
		for(i=0;i<10;i++) {
			int mx = 20;
			char an = '1';
			for(j=0;j<26;j++) {
				char cur = (char) ('A'+j);
				if(map.containsKey(cur)) {
					Set<Integer> st = map.get(cur);
					st.removeAll(taken);
					if(st.size()<mx) {
						mx=st.size();
						an=cur;
					}
				}
			}
			Set<Integer> st = map.get(an);
			if(st.size()>1) {
				throw new Exception();
								
			}
			k=st.iterator().next();
			ans[k] = an;
			taken.add(k);
			System.out.println(k+" -> "+an);
		}
		return new String(ans);
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

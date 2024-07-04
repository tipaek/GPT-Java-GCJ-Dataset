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
			Map<Character, Integer> map = new HashMap<>();
			Set<Character> st = new HashSet<>();
			for(i=0;i<10000;i++) {
				String M = fr.scanString();
				String R = fr.scanString();
				
				int ct = map.getOrDefault(R.charAt(0), 0);
				map.put(R.charAt(0), ct+1);
				
				for(char c:R.toCharArray()) {
					st.add(c);
				}
			}
			char[] ans = new char[10];
			for(i=1;i<10;i++) {
				int mx = -1;
				char c = '1';
				for(char cur : st) {
					int ct = map.containsKey(cur)?map.get(cur):-1;
					if(ct > mx) {
						mx=ct;
						c=cur;
					}
				}
				ans[i]=c;
				map.put(c, -1);
				st.remove(c);
			}
			ans[0]=st.iterator().next();
			
//			String ans = fnd1(map);
			System.out.println("Case #"+cs+": "+new String(ans));			
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
			int d = -1;
			for(j=0;j<9;j++) {
				if(!taken.contains(j)) {
					List<Character> pos = poses(j,map);
					if(pos.size() == 1) {
						d=j;
						break;
					}
				}
			}
			if(d==-1) {
				throw new Exception();
			}
			List<Character> pos = poses(d,map);
			ans[d]=pos.get(0);
			taken.add(d);
			
			for(Map.Entry<Character, Set<Integer>> e : map.entrySet()) {	
				e.getValue().remove(d);
			}			
		}
		return new String(ans);
	}
	private static List<Character> poses(int d, Map<Character, Set<Integer>> map) {
		List<Character> ans = new ArrayList<>();
		for(Map.Entry<Character, Set<Integer>> e : map.entrySet()) {				
			if(e.getValue().contains(d)) {
				if(e.getValue().size() == 1) {
					ans.clear();
					ans.add(e.getKey());
					return ans;
				}
				ans.add(e.getKey());
			}
		}
		return ans;
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

import java.io.*;
import java.util.*;
     
class Solution{
	public static void main(String[] args) throws Exception {
	IO io = new IO();
	PrintWriter out = new PrintWriter(System.out);
	Solver sr = new Solver();
	sr.solve(io,out);
	out.flush();
	out.close();
    	}

	static class Solver
	{
        boolean findPattern(String[] str, int i, int n, int max, StringBuilder sb)
        {
            HashSet<Character> hs = new HashSet<>();
            boolean sign = false;
            int flag=0;
            for(int u=0 ; u<n ; u++)
            {
                if(str[u].length()<=i)
                {
                    if(str[u].charAt(0)!='*')
                        sign = true;
                    continue;
                }
                    
                char ch = str[u].charAt(str[u].length()-1-i);

                if(ch!='*')
                    hs.add(ch);
                else
                    flag++;
            }
            if(hs.size()==0 && i>=max)
                return true;
            if(hs.size()>1 || (hs.size()!=0 && sign))
                return false;

            for(char ch : hs)
                sb.append(ch+"");
            if(flag==n)
                sb.append("C");
            return findPattern(str, i+1, n, max, sb);
        }
        void solve(IO io, PrintWriter out)
	    {
            int t = io.nextInt();
            for(int k=1 ; k<=t ; k++)
            {
                int n = io.nextInt();
                String[] s = new String[n];
                int max = Integer.MIN_VALUE;
                for(int i=0 ; i<n ; i++){
                    s[i] = io.next();
                    max = Math.max(max,s[i].length());
                }
                
                StringBuilder sb = new StringBuilder("");

                if(findPattern(s, 0, n, max, sb))
                    out.println("Case #"+k+": "+sb.reverse().toString());
                else
                    out.println("Case #"+k+": *");
            }
	    }
    	
	}
	//Special thanks to Petr (on codeforces) who inspired me to implement IO class!
	static class IO
	{
    	BufferedReader reader;
        StringTokenizer tokenizer;
    	public IO() {
                reader = new BufferedReader(new InputStreamReader(System.in));
                tokenizer = null;
            }
     
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public String nextLine() {
            String s="";
            try {
                    s=reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            return s;
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    
        public long nextLong() {
            return Long.parseLong(next());
        }
    	double nextDouble()
    	{
    		return Double.parseDouble(next());
    	}
	}
}
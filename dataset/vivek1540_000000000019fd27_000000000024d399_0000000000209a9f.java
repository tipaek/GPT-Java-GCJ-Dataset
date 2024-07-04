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
        void putParentheses(StringBuilder sb, int curr, boolean flag)
        {
            for(int i=0 ; i<curr ; i++)
            {
                if(flag)
                    sb.append("(");
                else
                    sb.append(")");
            }
                
        }
        void solve(IO io, PrintWriter out)
	    {
            int t = io.nextInt();
            for(int k=1 ; k<=t ; k++)
            {
                String s = io.next();
                int n = s.length();
                
                StringBuilder sb = new StringBuilder("");
                int curr = Integer.parseInt(s.charAt(0)+"");
                putParentheses(sb, curr,true);
                sb.append(curr+"");

                int opened=curr, closed=0;
                for(int i=1 ; i<n ; i++)
                {
                    char ch = s.charAt(i);
                    int val = Integer.parseInt(ch+"");
                    
                    if(val>curr)
                    {
                        putParentheses(sb, val-curr,true);
                        opened+=val-curr;
                    }
                    else
                    if(val<curr)
                    {
                        putParentheses(sb, curr-val,false);
                        closed+=curr-val;
                    }
                    sb.append(ch+"");
                    curr = val;
                }
                putParentheses(sb, opened-closed, false);
                out.println("Case #"+k+": "+sb.toString());
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
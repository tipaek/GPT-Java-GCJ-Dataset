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
                boolean flag=false;
                for(int i=0 ; i<n ; i++)
                {
                    if(s[i].charAt(0)!='*')
                    {
                        int c=0;
                        for(char ch : s[i].toCharArray())
                        {
                            if(ch=='*')
                                break;
                            c++;
                            if(sb.length()<c)
                                sb.append(ch+"");
                            else
                            if(sb.toString().charAt(c-1)!=ch)
                                flag=true;
                        }
                    }
                    if(flag)
                        break;
                }
                if(flag){
                    out.println("Case #"+k+": *");
                    continue;
                }
                StringBuilder sb1 = new StringBuilder("");
                for(int i=n-1 ; i>=0 ; i--)
                {
                    if(s[i].charAt(s[i].length()-1)!='*')
                    {
                        int c=0;
                        for(int j = s[i].length()-1 ; j>=0 ; j--)
                        {
                            char ch = s[i].charAt(j);
                            if(ch=='*')
                                break;
                            c++;
                            if(sb1.length()<c)
                                sb1.append(ch+"");
                            else
                            if(sb1.toString().charAt(c-1)!=ch)
                                flag=true;
                        }
                    }
                    if(flag)
                        break;
                }
                if(flag){
                    out.println("Case #"+k+": *");
                }
                else
                    out.println("Case #"+k+": "+sb.toString()+sb1.reverse().toString());
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
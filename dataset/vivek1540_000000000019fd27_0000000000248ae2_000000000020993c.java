import java.io.*;
import java.util.*;
import java.math.*;
     
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
                int[][] ar = new int[n][n];
                for(int i=0 ; i<n ; i++)
                    for(int j=0 ; j<n ; j++)
                        ar[i][j] = io.nextInt();
                        
                int r=0, c=0, x=0;        
                for(int i=0 ; i<n ; i++)
                {
                    HashSet<Integer> hs1 = new HashSet<>();
                    HashSet<Integer> hs2 = new HashSet<>();
                    int c1=0, c2=0;
                    x+=ar[i][i];
                    for(int j=0 ; j<n ; j++)
                    {
                        if(hs1.contains(ar[i][j]))
                            c1++;
                        if(hs2.contains(ar[j][i]))
                            c2++;
                        hs1.add(ar[i][j]);
                        hs2.add(ar[j][i]);
                        if(c1>1 && c2>1)
                            break;
                    }
                    if(c1>0)
                        r++;
                    if(c2>0)
                        c++;
                }
                out.println("Case #"+k+": "+ x +" "+r+" "+c);
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
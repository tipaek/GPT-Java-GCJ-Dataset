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
        class Pair
        {
            int x, y;
            Pair(int a, int b)
            {
                x=a;
                y=b;
            }
        }
        void findEqualMatrix(int[][] ans, int n, int x)
        {
            for(int i=0 ; i<n ; i++)
                ans[i][i] = x/n;
            int i=0;
            while(i<n)
            {
                int val=1;
                for(int s=i+1 ; s<n ; s++){
                    if(val==ans[0][0])
                        val++;
                    ans[i][s] = val++;
                }
                val=n;
                for(int s=i+1 ; s<n ; s++){
                    if(val==ans[0][0])
                        val--;
                    ans[s][i] = val--;
                }
                i++;
            }
        }
        void findUnequalMatrix(int[][] ans, int n, int x)
        {
            for(int i=0 ; i<n ; i++)
                ans[0][i] = i+1;
            for(int i=1 ; i<n ; i++)
            {
                for(int j=0 ; j<n-1 ; j++)
                {
                    ans[i][j] = ans[i-1][j+1];
                }
                ans[i][n-1] = ans[i-1][0];
            }
        }
        void solve(IO io, PrintWriter out)
	    {
            int t = io.nextInt();
            for(int k=1 ; k<=t ; k++)
            {
                int n = io.nextInt();
                int x = io.nextInt();

                if(x%n!=0 || (n%2!=0 && n*(n+1)!=2*x)){
                    out.println("Case #"+k+": IMPOSSIBLE");
                    continue;
                }
                int[][] ans = new int[n][n];
                if(n%2==0)
                    findEqualMatrix(ans,n,x);
                else
                    findUnequalMatrix(ans,n,x);
                StringBuilder sb = new StringBuilder("");
                for(int i=0 ; i<n ; i++)
                {
                    for(int j=0 ; j<n ; j++)
                    {
                        sb.append(ans[i][j]+" ");
                    }
                    sb.append("\n");
                }
                out.print("Case #"+k+": POSSIBLE\n"+sb.toString());
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
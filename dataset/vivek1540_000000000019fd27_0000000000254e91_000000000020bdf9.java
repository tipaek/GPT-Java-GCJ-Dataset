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
        boolean isOverlap(ArrayList<Pair> hp, int s, int e)
        {
            for(Pair num : hp)
            {
                if((num.x<=s && num.y>s) || (num.x<e && num.y>=e) || (num.x<=s && num.y>=e))
                    return true;
            }
            return false;
        }
        void solve(IO io, PrintWriter out)
	    {
            int t = io.nextInt();
            for(int k=1 ; k<=t ; k++)
            {
                int n = io.nextInt();
                
                boolean flag=false;
                StringBuilder sb = new StringBuilder("");
                HashMap<Character,ArrayList<Pair>> hp = new HashMap<>();

                hp.put('C',new ArrayList<Pair>());  hp.put('J',new ArrayList<Pair>());

                for(int i=0 ; i<n ; i++)
                {
                    int s = io.nextInt();
                    int e = io.nextInt();
                    
                    boolean first = isOverlap(hp.get('C'), s, e);
                    boolean second = isOverlap(hp.get('J'), s, e);

                    if(first && second)
                        flag=true;
                    else
                    {
                        if(!first){
                            hp.get('C').add(new Pair(s,e));
                            sb.append('C');
                        }
                        else{
                            hp.get('J').add(new Pair(s,e));
                            sb.append('J');
                        }
                    }
                }
                if(flag)
                    out.println("Case #"+k+": IMPOSSIBLE");
                else
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
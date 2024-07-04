import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

class first
{
    public static void main(String args[]) {
        new Thread(null, new Runnable() {
            public void run() {
                try{
                    solve();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    }
    
    @SuppressWarnings("unchecked")
    public static void solve() 
    {
    	InputReader in =new InputReader(System.in);
    	int t = in.nextInt();
    	int x = 1;
    	while(t-->0) 
    	{
    	int n = in.nextInt();
    	int ar[][]=new int[n][n];
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    			ar[i][j] = in.nextInt();
    	}
    	System.out.println("Case #"+x+":"+trace(ar,n)+" "+rowCheck(ar,n)+" "+colCheck(ar,n));
    	x++;
    	}
    }
    public static int rowCheck(int ar[][], int n) {
    	boolean[] visited = new boolean[n];
    	int count = 0;
    	for(int i=0;i<n;i++)
    	{
    		Arrays.fill(visited,false);
    		for(int j=0;j<n;j++)
    		{
    			visited[ar[i][j]-1]=true;
    		}
    		for(int j=0;j<n;j++)
    		{
    			if(!visited[j])
    			{
    				count++;
    				break;
    			}
    		}
    	}
    	return count;
    }
    public static int colCheck(int ar[][], int n) {
    	boolean[] visited = new boolean[n+1];
    	int count = 0;
    	for(int j=0;j<n;j++)
    	{
    		Arrays.fill(visited,false);

    		for(int i=0;i<n;i++)
    		{
    			visited[ar[i][j]-1]=true;
    		}
    		for(int i=0;i<n;i++)
    		{
    			if(!visited[i])
    			{
    				count++;
    				break;
    			}
    		}
    	}
    	return count;
    }
    
    public static long trace(int ar[][], int n) {
    	long sum = 0;
    	for(int i=0;i<n;i++)
    		sum+=ar[i][i];
    	return sum;
    }
    static class InputReader {
 
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public int nextCh()
        {
            int c=snext();
            while(isSpaceChar(c))
                c=snext();
            return c;
        }
        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
 
            int res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
 
            long res = 0;
 
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
 
            return res * sgn;
        }
 
        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}

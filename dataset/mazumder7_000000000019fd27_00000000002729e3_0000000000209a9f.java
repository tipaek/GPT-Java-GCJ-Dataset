import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

class Solution 
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
    public static void solve() {
    	InputReader in =new InputReader(System.in);
    	int t = in.nextInt();
    	while(t-->0) {
    		String s = in.readString();
    		//System.out.println(s);
    		s.trim();
    		int n = s.length();
    		String nstr = "";
    		int open = 0;
    		int close = 0;
    		int prev = 0;
    		for(int i=0;i<n;i++)
    		{
    			int d = s.charAt(i)-48;
    			//System.out.println(open+" "+d+" "+nstr);
    			if(i==0)
    			{
    				open = d;
    				while(d-->0)
    					nstr = "("+nstr;
    			}
    			else if(d<open)
    			{
    				int diff = open-d;
    				while(diff-->0)
    					nstr += ")";
    				open=d;
    			}
    			else if(d==open)
    			{
    				
    			}
    			else
    			{
    				int diff = d-open;
    				while(diff-->0)
    					nstr += "(";
    				open=d;
    			}
    			nstr += s.charAt(i);
    			prev = d;
    		}
    		int d = s.charAt(n-1)-48;
    		while(d-->0)
    			nstr+=")";
    		System.out.println(nstr);
    	}
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

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
    	int b = in.nextInt();
    	int x =1;
    	while(t-->0) {
    		int[] c1 = new int[b+1];
    		int[] c2 = new int[b+1];
    		int[] c3 = new int[b+1];
    		int[] c4 = new int[b+1];
    		int[] trial = new int[b+1];
    		boolean[] done = new boolean[5];
    		for(int i=1;i<=b;i++)
    		{
    			System.out.println(i);
    			int bit = in.nextInt();
    			c1[i] = 1-bit;
    			c2[b-i+1] = bit;
    			c3[b-i+1] = 1-bit;
    			c4[i] = bit;
    		}
    		for(int i=1;i<=b;i++)
    		{
    			System.out.println(i);
    			int bit = in.nextInt();
    			trial[i]=bit;
    		}
    		done[check(trial,c1,c2,c3,c4)]=true;
    		for(int i=1;i<=b;i++)
    		{
    			System.out.println(i);
    			int bit = in.nextInt();
    			trial[i]=bit;
    		}
    		done[check(trial,c1,c2,c3,c4)]=true;
    		for(int i=1;i<=b;i++)
    			System.out.print(trial[i]);
    		char ch = (char)in.nextCh();
    		if(ch=='N')
    			System.exit(1);
    		x++;
    	}
    }
    static int check(int[] trail, int[] c1, int[] c2, int[] c3, int[] c4) {
    	if(Arrays.toString(trail).equals(Arrays.toString(c1))) return 1;
    	if(Arrays.toString(trail).equals(Arrays.toString(c2))) return 2;
    	if(Arrays.toString(trail).equals(Arrays.toString(c3))) return 3;
    	return 4;
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

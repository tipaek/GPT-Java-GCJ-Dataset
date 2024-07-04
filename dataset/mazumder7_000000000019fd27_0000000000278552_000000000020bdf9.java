import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;

class Solution
{
	static class Pair{
		int start, end, id;
		Pair(int start, int end, int id){
			this.start=start;
			this.end=end;
			this.id=id;
		}
		@Override
		public String toString() {
			return "("+start+", "+end+", "+", "+id+")";
		}
	}
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
    	int x =1;
    	while(t-->0) {
    		int n = in.nextInt();
    		Pair ar[]=new Pair[n];
    		for(int i=0;i<n;i++)
    			ar[i]=new Pair(in.nextInt(),in.nextInt(),i);
    		Arrays.sort(ar,new Comparator<Pair>() {
				@Override
				public int compare(Pair arg0, Pair arg1) {
					return (arg0.start!=arg1.start)?arg0.start-arg1.start:arg0.end-arg1.end;
				}
    		});
    		int C = -1, J=-1;
    		boolean imp=false;
    		//System.out.println(Arrays.toString(ar));
    		char[] ans = new char[n];
    		for(int i=0;i<n;i++)
    		{
    			if(ar[i].start>=C)
    			{
    				ans[ar[i].id]='C';
    				C=ar[i].end;
    			}
    			else if(ar[i].start>=J)
    			{
    				ans[ar[i].id]='J';
    				J=ar[i].end;
    			}
    			else
    			{
    				//ans="IMPOSSIBLE".toCharArray();
    				imp=true;
    				break;
    			}
    		}
    		String a="";
    		for(int i=0;i<n;i++)
    			a+=ans[i];
    		if(imp)
        		System.out.println("Case #"+x+": "+"IMPOSSIBLE");
    		else
    			System.out.println("Case #"+x+": "+a);
    		x++;
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

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        // -------------------------------------------------------------------------
        // Initializing...
        new Solution();
        // -------------------------------------------------------------------------
        // put your code here... :)
        int tests = in.readInt();
        for (int te = 1; te <= tests; te++) {
		
        	int n = in.readInt();
        	int[][] tasks =  new int[n][2]; 
        	
        	for (int i = 0; i < n; i++) {
        		tasks[i][0] = in.readInt();
        		tasks[i][1] = in.readInt();
			}
        	int ans = -1;
        	for (int i = 0; i <= (1<<n); i++) {
        		if (check(i,tasks)) {
        			ans = i;
        			break;
        		}
				
			}
        	out.println("Case #"+te+": "+ans(ans, tasks));
		}
        // -------------------------------------------------------------------------
        // closing up
        end();
        // --------------------------------------------------------------------------

    }

    private static boolean check(int ans, int[][] tasks) {
    	boolean [][] time = new boolean[24*60+1][2];
    	for (int t = 0; t < tasks.length; t++) {
    		int character = (ans>>t)%2;
    		for (int i = tasks[t][0]; i < tasks[t][1]; i++) {
				if (time[i][character]) return false;
				time[i][character]=true;
			}
			
		}
		return true;
	}

	private static String ans(int ans,int[][] tasks) {
		// TODO Auto-generated method stub
		if (ans==-1) return "IMPOSSIBLE";
		String ret = "";
		for (int t = 0; t < tasks.length; t++) {
    		if ((ans>>t)%2 == 0){
    			ret += 'C';
    		}else {
    			ret += 'J';
    		}
    		
		}
		return ret;
	}

	public Solution() throws IOException {
        // Input Output for Console to be used for trying the test samples of
        // the problem
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
//      in = new InputReader(new FileInputStream("grant.in"));
//      out = new PrintWriter("grant.out");
    }

    private static void end() throws IOException {
        out.flush();
        out.close();
        System.exit(0);
    }

    class InputReader {
        private boolean finished = false;

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0)
                s = readLine0();
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines)
                return readLine();
            else
                return readLine0();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value == -1;
        }

        public String next() {
            return readString();
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

    }

    private interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
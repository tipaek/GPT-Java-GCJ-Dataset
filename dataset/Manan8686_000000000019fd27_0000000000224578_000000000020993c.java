import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Manan Patel
 */
class Solution{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        solution solver = new solution();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, w);
        w.close();
    }

    static class solution {
    	public void solve(int testNumber, InputReader sc, PrintWriter w) {
    		int m = sc.nextInt() , trace = 0 , row = 0 , col = 0;
    		int a[][] = new int[m][m];
    		for(int i = 0 ; i < m ; i++){
    			for(int j = 0; j < m ; j++){
    				a[i][j] = sc.nextInt();
    				if(i == j)
    					trace += a[i][j];
    			}
    		}
    		for(int i = 0 ; i < m ; i++){
    			HashSet<Integer> hs = new HashSet<>();
    			for(int j = 0; j < m ; j++){
    				hs.add(a[i][j]);
    			}
    			if(hs.size() != m)
    				row++;
    		}
    		for(int i = 0 ; i < m ; i++){
    			HashSet<Integer> hs = new HashSet<>();
    			for(int j = 0; j < m ; j++){
    				hs.add(a[j][i]);
    			}
    			if(hs.size() != m)
    				col++;
    		}
    		w.printf("Case #%d: %d %d %d",testNumber,trace,row,col);
            w.println();
       	}
	}
	

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

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

        public int nextInt() {
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
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
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
            }
            while (!isSpaceChar(c));
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
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
    
}


import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
      public static void main(String[] args) {
          InputStream inputStream = System.in;
          InputReader in = new InputReader(inputStream);
          IndiciumSolver solver = new IndiciumSolver();
          int num = Integer.parseInt(in.next());
          for(int i = 1; i <= num; i++) {
        	  solver.solve(i, in);
          }
      }
      
      static void printst(String s) {
    	  System.out.println(s);
      }
      
      static class IndiciumSolver {
    	  public void solve(int num, InputReader in) {
    		  int n = in.readInt();
    		  int c = in.readInt();
    		  if(n <= 2 || c <= 2) {
    			  printst("Case #"+num+": IMPOSSIBLE");
    			  return;
    		  }
    		  if(c > n * n) {
    			  printst("Case #"+num+": IMPOSSIBLE");
    			  return;
    		  }
    		  if(c % n == 0) {
        		  printst("Case #"+num+": POSSIBLE");
        		  int s = c / n + n;
        		  StringBuilder row = new StringBuilder();
        		  for(int i = 0; i < n; i++) {
        			  row.setLength(0);
        			  for(int j = 0; j < n; j++) {
            			  int r = (s + j) % n;
            			  if(r == 0) r = n;
            			  row.append(r);
            			  if(j < n -1) row.append(" ");
        			  }
        			  printst(row.toString());
        			  s -= 1;
        		  }
    		  } else printst("Case #"+num+": IMPOSSIBLE");
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
              if (numChars == -1) {
                  throw new InputMismatchException();
              }
              if (curChar >= numChars) {
                  curChar = 0;
                  try {
                      numChars = stream.read(buf);
                  } catch (IOException e) {
                      throw new InputMismatchException();
                  }
                  if (numChars <= 0) {
                      return -1;
                  }
              }
              return buf[curChar++];
          }

          public int readInt() {
              int c = read();
              while (isSpaceChar(c)) {
                  c = read();
              }
              int sgn = 1;
              if (c == '-') {
                  sgn = -1;
                  c = read();
              }
              int res = 0;
              do {
                  if (c < '0' || c > '9') {
                      throw new InputMismatchException();
                  }
                  res *= 10;
                  res += c - '0';
                  c = read();
              } while (!isSpaceChar(c));
              return res * sgn;
          }

          public String readString() {
              int c = read();
              while (isSpaceChar(c)) {
                  c = read();
              }
              StringBuilder res = new StringBuilder();
              do {
                  if (Character.isValidCodePoint(c)) {
                      res.appendCodePoint(c);
                  }
                  c = read();
              } while (!isSpaceChar(c));
              return res.toString();
          }

          public boolean isSpaceChar(int c) {
              if (filter != null) {
                  return filter.isSpaceChar(c);
              }
              return isWhitespace(c);
          }

          public static boolean isWhitespace(int c) {
              return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
          }

          public BigInteger readBigInteger() {
              try {
                  return new BigInteger(readString());
              } catch (NumberFormatException e) {
                  throw new InputMismatchException();
              }
          }

          public String next() {
              return readString();
          }

          public interface SpaceCharFilter {
              public boolean isSpaceChar(int ch);

          }

      }
}
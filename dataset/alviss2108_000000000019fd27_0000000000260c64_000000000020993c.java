import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
      public static void main(String[] args) {
          InputStream inputStream = System.in;
          InputReader in = new InputReader(inputStream);
          VestigiumSolver solver = new VestigiumSolver();
          int num = Integer.parseInt(in.next());
          for(int i = 1; i <= num; i++) {
        	  solver.solve(i, in);
          }
      }
      
      static void printst(String s) {
    	  System.out.println(s);
      }
      
      static class VestigiumSolver {
    	  public void solve(int num, InputReader in) {
    		  int n = in.readInt();
    		  int rR = 0;
    		  int rC = 0;
    		  int cheo = 0;
    		  int[][] table = new int[n][n];
    		  for(int i = 0; i < n; i++) {
    			  int[] row = new int[n + 1];
    			  boolean isDup = false;
        		  for(int j = 0; j < n; j++) {
        			  int ij = in.readInt();
        			  if(i == j) cheo += ij;
        			  table[i][j] = ij;
        			  if(row[ij] == 0) row[ij] = 1;
        			  else isDup = true;
        		  }
        		  if(isDup) rR++;
    		  }
    		  for(int i = 0; i < n; i++) {
    			  boolean isDup = false;
    			  int[] col = new int[n + 1];
        		  for(int j = 0; j < n; j++) {
        			  int pos = table[j][i];
        			  if(col[pos] == 0) col[pos] = 1;
        			  else isDup = true;
        		  }
        		  if(isDup) rC++;
    		  }
    		  printst("Case #"+num+": " + cheo + " " + rR + " " + rC);
    	  }
      }

      static class OutputWriter {
          private final PrintWriter writer;

          public OutputWriter(OutputStream outputStream) {
              writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
          }

          public OutputWriter(Writer writer) {
              this.writer = new PrintWriter(writer);
          }

          public void print(Object... objects) {
              for (int i = 0; i < objects.length; i++) {
                  if (i != 0) {
                      writer.print(' ');
                  }
                  writer.print(objects[i]);
              }
          }

          public void printLine(Object... objects) {
              print(objects);
              writer.println();
          }

          public void close() {
              writer.close();
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
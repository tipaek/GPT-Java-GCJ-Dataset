import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
      public static void main(String[] args) {
          InputStream inputStream = System.in;
          InputReader in = new InputReader(inputStream);
          NestingDepthSolver solver = new NestingDepthSolver();
          int num = Integer.parseInt(in.next());
          for(int i = 1; i <= num; i++) {
        	  solver.solve(i, in);
          }
      }
      
      static void printst(String s) {
    	  System.out.println(s);
      }
      
      static class NestingDepthSolver {
    	  public void solve(int num, InputReader in) {
    		  StringBuilder builder = new StringBuilder();
    		  String line = in.readString();
    		  int len = line.length();
    		  if(len == 1) {
    			  int x = Character.getNumericValue(line.charAt(0));
        		  for(int i = 0; i < x; i++) {
        			  builder.append("(");
        		  }
        		  builder.append(x);
        		  for(int i = 0; i < x; i++) {
        			  builder.append(")");
        		  }
    		  } else {
        		  for(int i = 0; i < len; i++) {
        			  int pos = Character.getNumericValue(line.charAt(i));
        			  if(i == 0) {
                		  for(int j = 0; j < pos; j++) {
                			  builder.append("(");
                		  }
        			  }
        			  builder.append(pos);
        			  if(i == len - 1) {
                		  for(int j = 0; j < pos; j++) {
                			  builder.append(")");
                		  }
        			  } else {
        				  int next = Character.getNumericValue(line.charAt(i + 1));
        				  if(next > pos) {
        					  int dif = next - pos;
                    		  for(int j = 0; j < dif; j++) {
                    			  builder.append("(");
                    		  }
        				  } else if (next < pos){
        					  int dif = pos - next;
                    		  for(int j = 0; j < dif; j++) {
                    			  builder.append(")");
                    		  }
        				  }
        			  }
        		  }
    		  }
    		  printst("Case #"+num+": " + builder.toString());
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
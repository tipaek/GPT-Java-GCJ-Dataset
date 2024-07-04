import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
      public static void main(String[] args) {
          InputStream inputStream = System.in;
          InputReader in = new InputReader(inputStream);
          ParentingSolver solver = new ParentingSolver();
          int num = Integer.parseInt(in.next());
          for(int i = 1; i <= num; i++) {
        	  solver.solve(i, in);
          }
      }
      
      static void printst(String s) {
    	  System.out.println(s);
      }
      
      static class ParentingSolver {
    	  public void solve(int num, InputReader in) {
    		  StringBuilder res = new StringBuilder();
    		  int acti = in.readInt();
    		  boolean isPossible = true;
    		  int c = 0;
    		  int j = 0;
    		  ArrayList<ActiControl> listActi = new ArrayList<>();
    		  for(int i = 0; i < acti; i++) {
    			  int start = in.readInt();
    			  int end = in.readInt();
    			  listActi.add(new ActiControl(i, start, end));
    		  }
    		  ActiControl.sortByStart = true;
    		  Collections.sort(listActi);
    		  for(int i = 0; i < listActi.size(); i++) {
    			  ActiControl item = listActi.get(i);
    			  if(item.start >= c) {
    				  item.setPerson("C");
    				  c = item.end;
    			  } else if(item.start >= j) {
    				  item.setPerson("J");
    				  j = item.end;
    			  } else {
    				  isPossible = false;
    			  }
    		  }
    		  if(isPossible) {
        		  ActiControl.sortByStart = false;
        		  Collections.sort(listActi);
        		  for(int i = 0; i < listActi.size(); i++) {
        			  res.append(listActi.get(i).person);
        		  }
    		  } else {
    			  res.append("IMPOSSIBLE");
    		  }
    		  printst("Case #"+num+": "+res.toString());
    	  }
      }
      
      static class ActiControl implements Comparable<ActiControl>{
    	  Integer pos;
    	  Integer start;
    	  Integer end;
    	  String person;
    	  static boolean sortByStart = true;
    	  ActiControl(int pos, int start, int end) {
    		  this.pos = pos;
    		  this.start = start;
    		  this.end = end;
    	  }
    	  
    	  void setPerson(String person) {
    		  this.person = person;
    	  }
    	  
    	  void setSortByPos() {
    		  sortByStart = false;
    	  }

		@Override
		public int compareTo(ActiControl arg) {
			// TODO Auto-generated method stub
			if(sortByStart) {
				return this.start.compareTo(arg.start);
			} else return this.pos.compareTo(arg.pos);
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
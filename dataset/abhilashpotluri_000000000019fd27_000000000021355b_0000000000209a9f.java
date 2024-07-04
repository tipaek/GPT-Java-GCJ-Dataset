import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int numTestCases = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int test = 0; test < numTestCases; test++) {
            String s = in.nextLine();
            StringBuilder newSb = new StringBuilder();
            int prev = Character.getNumericValue(s.charAt(0));
            for(int i = 0; i < prev; i++) {
               newSb.append("(");
            }
            newSb.append(prev);
            
            for(int i = 1; i < s.length(); i++) {
               int curr = Character.getNumericValue(s.charAt(i));
               if(curr == 0) {
                  for(int j = 0; j < prev; j++) {
                     newSb.append(")");
                  }
               }
               else {
                  String charToAdd = curr < prev ? ")" : "(";
                  int numAdd = Math.abs(prev - curr);
                  for(int j = 0; j < numAdd; j++) {
                     newSb.append(charToAdd);
                  }
               }
               newSb.append(curr);
               prev = curr;
            }

            for(int i = 0; i < prev; i++) {
               newSb.append(")");
            }

            sb.append("Case #" + (test + 1) + ": " + newSb.toString() + "\n");
        }
        System.out.println(sb.toString());
    }
}

class FastScanner{
    private InputStream stream;                                                                                         
    private byte[] buf = new byte[1024];                                                                                
    private int curChar;                                                                                                
    private int numChars;                                                                                               
 
    public FastScanner(InputStream stream)
    {
       this.stream = stream;                                                                                            
    }
 
    int read()
    {
       if (numChars == -1)
          throw new InputMismatchException();                                                                           
       if (curChar >= numChars){
          curChar = 0;                                                                                                  
          try{
             numChars = stream.read(buf);                                                                               
          } catch (IOException e) {
             throw new InputMismatchException();                                                                        
          }
          if (numChars <= 0)
             return -1;                                                                                                 
       }
       return buf[curChar++];                                                                                           
    }
 
    boolean isSpaceChar(int c)
    {
       return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;                                                                 
    }
 
    boolean isEndline(int c)
    {
       return c=='\n'||c=='\r'||c==-1;                                                                                  
    }
 
    int nextInt()
    {
       return Integer.parseInt(next());                                                                                 
    }
 
    long nextLong()
    {
       return Long.parseLong(next());                                                                                   
    }
 
    double nextDouble()
    {
       return Double.parseDouble(next());                                                                               
    }
 
    String next(){
       int c = read();                                                                                                  
       while (isSpaceChar(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isSpaceChar(c));                                                                                         
       return res.toString();                                                                                           
    }
 
    String nextLine(){
       int c = read();                                                                                                  
       while (isEndline(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isEndline(c));                                                                                           
       return res.toString();                                                                                           
    }
 }
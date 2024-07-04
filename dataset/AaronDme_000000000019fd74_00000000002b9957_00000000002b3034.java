import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(input.readLine());
        for(int i = 1; i <= t; i++){
            System.out.print("Case #" + i + ": ");
           int n = Integer.parseInt(input.readLine());
           String out = input.readLine().substring(1);
           boolean isPossible = true;
           for(int j = 1; j < n; j++){
             String s = input.readLine().substring(1);
             if(isPossible){
              if(out.length() >= s.length()){
                isPossible = s.equals(out.substring(out.length() - s.length()));
              }
              else{
                isPossible = out.equals(s.substring(s.length() - out.length()));
                out = s;
              }
             }
           }
           if(isPossible)
            System.out.println(out);
           else
            System.out.println("*");
           
        }
    }
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static int getInt() throws IOException{
        int c = skipSpace();
        boolean isNeg = (char) c == '-';
        int out = 0;
        if(isNeg)
          c = input.read();
        do {
          out *= 10;
          out += c - '0';
          c = input.read();
        } while (c <= '9' && c >= '0');
        return (isNeg)? -out: out;
      }
    public static int skipSpace() throws IOException{
        int s = input.read();
        while(s == ' ' || s == '\n' || s == '\r') {
          s = input.read();
        }
        return s;
      }
}
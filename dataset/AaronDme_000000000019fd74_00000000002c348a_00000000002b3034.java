import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(input.readLine());
        for(int i = 1; i <= t; i++){
            System.out.print("Case #" + i + ": ");
            Deque<String> out = new LinkedList<String>();
            out.add("");
            out.add("");
           int n = Integer.parseInt(input.readLine());
           boolean isPossible = true;
           for(int j = 0; j < n; j++){
             String s = input.readLine();
             int l = 0;
             int r = s.length() - 1;
             if(s.charAt(l) != '*'){
              while(l < s.length() - 1 && s.charAt(l + 1) != '*'){
                l++;
              }
              String w = out.peekFirst();
              String z = s.substring(0, l + 1);
              if(w.length() == 0){
                out.pollFirst();
                out.addFirst(z);
              }
        
              else if(w.length() >= z.length()){
                isPossible = z.equals(w.substring(0, z.length()));
              }
              else{
                isPossible = w.equals(z.substring(0, w.length()));
                out.pollFirst();
                out.addFirst(z);
              }
             }
             if(s.charAt(r) != '*'){
              while(r > 0 && s.charAt(r - 1) != '*'){
                r--;
              }
              String w = out.peekLast();
              String z = s.substring(r, s.length());
              if(w.length() == 0){
                out.pollLast();
                out.addLast(z);
              }
              else if(w.length() >= z.length()){
                isPossible = z.equals(w.substring(w.length() - z.length()));
              }
              else{
                isPossible = w.equals(z.substring(z.length() - w.length()));
                out.pollLast();
                out.addLast(z);
              }
             }
             String temp = out.pollLast();
            out.addLast(s.substring(l + 1, r));
            out.addLast(temp);
           }
           if(isPossible){
            for(String s : out){
              char[] q = s.toCharArray();
              for(char x : q){
                if(x != '*')
                  System.out.print(x);
              }
            }
            System.out.println("");
           }
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
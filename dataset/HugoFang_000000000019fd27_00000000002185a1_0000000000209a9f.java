 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          StringBuilder res = new StringBuilder();
          String s = in.nextLine();
          helper(res, s, 0);
          //System.out.println(s);
          System.out.println("Case #" + i + ": " 
                                        + res.toString());
        }
      }
      public static void addPar(StringBuilder res, boolean rightPar, int count){
       
          for(int i = 0; i < count; ++i) res.append(rightPar? ')' : '(');

          return;
      }
      public static void helper(StringBuilder res, String s, int depth){
          int len = s.length();
          
          int min = 1, start = 0;
          for(int i = 0; i < len; ++i){
              int ord = s.charAt(i) - '0';
              
              if(ord - depth == 0){
                  if(i - start > 0){
                      addPar(res, false, min - depth);
                      helper(res, s.substring(start, i), min);
                      addPar(res, true, min - depth);
                  }
                  start = i + 1;
                  min = 1;
                  res.append(s.charAt(i));
              }else{
                  min = Math.min(min, ord);
              }
          }
          
          if(len - start > 0){
            addPar(res, false, min - depth);
            helper(res, s.substring(start, len), min);
            addPar(res, true, min - depth);
          }
      }
    }
  

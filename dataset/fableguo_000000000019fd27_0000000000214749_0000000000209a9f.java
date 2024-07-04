import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String input = "";
        input = in.nextLine();
        for (int i = 1; i <= t; ++i) {
        //   int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
          
        //   for(int j = 0; j < n; j++){
            input = in.nextLine();
        //   }
          char cur = '0';
          char pre = '0';
          String result = "";
          for(int j = 0; j < input.length(); j++){
              cur = input.charAt(j);
              if(pre == cur){
                  result += pre;
              }else{
                  char c = 't';
                  if(cur > pre){
                    c = '(';
                  }else{
                    c = ')';  
                  }
                  for(int k = 0; k < Math.abs(pre - cur); k++){
                      result += c;
                  }
                  result += cur;
                  pre = cur;
              }
          }
          for(int k = 0; k < Math.abs(cur-'0'); k++){
            result += ')';
          }
          
          System.out.println("Case #" + i + ": " + (result));
        }
      }
    }
  
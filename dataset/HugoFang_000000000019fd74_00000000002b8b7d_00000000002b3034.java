import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int N = in.nextInt();
          in.nextLine();
          String[] input = new String[N];
          for(int j = 0; j < N; ++j) input[j] = in.nextLine();
          System.out.println("Case #" + i + ": " + helper(input));
        }
      }
      
      public static String helper(String[] input){
          int N = input.length;
          StringBuilder res = new StringBuilder();
          int[] index = new int[N];
          
          //int maxIdx = Integer.MIN_VALUE;
          
          for(int i = 0; i < N; ++i){
              index[i] = input[i].length() - 1;
              //maxIdx = Math.max(maxIdx, index[i]);
          }
          
          boolean append = true;
          
          while(true){
            char c = ' ';
            append = true;
            for(int i = 0; i < N; ++i){
               if(index[i] == 0) continue;
               
               if(c == ' '){
                   c = input[i].charAt(index[i]);
               }else if(c != input[i].charAt(index[i])){
                   return "*";
               }
               
               --index[i];
            }
            
            if(c == ' ') break;
            else res.append(c);
          }
          
          return res.reverse().toString();
      }
    }
  
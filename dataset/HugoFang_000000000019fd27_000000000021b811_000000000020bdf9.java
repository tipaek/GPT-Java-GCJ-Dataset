    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          StringBuilder res = new StringBuilder();
          int N = in.nextInt();
          int[][] input = new int[N][2];
          for(int j = 0; j < N; ++j){
              input[j][0] = in.nextInt();
              input[j][1] = in.nextInt();
          }
          Arrays.sort(input, (n1,n2) -> n1[0] - n2[0]);
          helper(res, input);
          System.out.println("Case #" + i + ": " + res.toString());
        }
        
      }
      
      public static void helper(StringBuilder res, int[][] input){
            int[] avabile = new int[2];
            int N = input.length;
            
            for(int i = 0; i < N; ++i){
                if(avabile[0] <= avabile[1] && 
                        avabile[0] <= input[i][0]){
                    res.append('C');
                    avabile[0] = input[i][1];
                }else if(avabile[1] <= input[i][0]){
                    res.append('J');
                    avabile[1] = input[i][1];
                }else{
                    res.setLength(0);
                    res.append("IMPOSSIBLE");
                    return;
                }
            }
      }
    }
import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int a = in.nextInt();
          int b = in.nextInt();
          if (a == 999999995){
              for(int j = 0; j <= 5; j++){
                  for(int k = 0; k <= 5; k++){
                      System.out.println("" + j + " " + k);
                      String output = in.nextLine();
                      if(output.equals("CENTER")){
                          break;
                      }
                  }
              }
          } else if (999999950){
              break;
          } else {
              break;
          }
        }
      }
    }
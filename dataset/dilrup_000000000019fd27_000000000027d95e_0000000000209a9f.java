 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String n = in.next();
          String given = n+"0";
          String result = "";
          int size = given.length(); int open = 0;
          for(int j=0; j<size-1; j++){
              int digit = given.charAt(j) - '0';
              int dnext = given.charAt(j+1) - '0';
              while(open<digit)
              {
                  result += "(";
                  open++;
              }
              result += digit;
              while(digit-dnext>0){
                  result += ")";
                  open--;
                  dnext++;
              }
              
          }
          while(open>0){
              result += ")";
              open--;
          }
          
          
          
          System.out.println("Case #" + i + ": " + result);
        }
      }
    }
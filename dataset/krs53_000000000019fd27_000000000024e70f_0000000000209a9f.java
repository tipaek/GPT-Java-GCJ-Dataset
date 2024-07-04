import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String finalString = "";
          String digitString = in.nextLine();
          int previousDigit = 0;
          for(int j = 0; j <= digitString.length(); j++){
              if(j == digitString.length()){
                  finalString = appendParentheses(')', finalString, previousDigit);
              } else {
              int currentDigit = Character.getNumericValue(digitString.charAt(j));
              if(currentDigit - previousDigit > 0){
                  finalString = appendParentheses('(', finalString, currentDigit - previousDigit);
              } else {
                  finalString = appendParentheses(')', finalString, previousDigit - currentDigit);
              }
              finalString += currentDigit;
              previousDigit = currentDigit;
              }
          }
          
          System.out.println("Case #" + i + ": " + finalString);
        }
      }
      
      private static String appendParentheses(char parantheses, String finalString, int count){
          for(int i = 0; i < count; i++){
              finalString += parantheses;
          }
          return finalString;
      }
    }
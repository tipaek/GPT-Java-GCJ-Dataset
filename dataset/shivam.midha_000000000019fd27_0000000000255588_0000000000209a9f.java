import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String outputString = "";
      String input = in.next();
      int inputParanthesis = 0;

      for(int len=0; len<input.length(); len++) {
        int number = input.charAt(len) - '0';

        if(number == '0') {
          while (inputParanthesis != 0) {
            outputString += ")";
            inputParanthesis--;
          }
        } else if(number > inputParanthesis) {
          while (number != inputParanthesis){
            outputString += "(";
            inputParanthesis++;
          }
        } else if(number < inputParanthesis) {
          while (number != inputParanthesis){
            outputString += ")";
            inputParanthesis--;
          }
        }
        outputString += input.charAt(len);
      }
      while (inputParanthesis != 0) {
        outputString += ")";
        inputParanthesis--;
      }
      System.out.println("Case #"+i+": "+outputString);
    }
  }
}
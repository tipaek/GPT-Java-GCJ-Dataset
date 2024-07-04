import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
          String input = in.nextLine();
          input = "0" + input + "0";
          String answer = "";
          for(int a = 1; a < input.length(); a++){
            char previous = input.charAt(a-1);
            char current = input.charAt(a);
            int helper = current - previous;
            if(helper > 0){
                while(helper > 0){
                    answer = answer + "(";
                    helper--;
                }
            }
            else if(helper < 0){
                while(helper < 0){
                    answer = answer + ")";
                    helper++;
                }
            }
            answer = answer + current;
          }
          answer = answer.substring(0,answer.length()-1);
          System.out.println("Case #" + i + ": " + answer);
        }
      }
}
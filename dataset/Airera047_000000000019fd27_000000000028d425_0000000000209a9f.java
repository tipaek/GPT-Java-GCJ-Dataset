import java.util.*;
import java.io.*;

public class Solution{
  
  public static void main(String[] args) throws IOException {
    Solution fd = new Solution();
    Scanner input= new Scanner(System.in);
    int testN = input.nextInt();
    for(int i = 0; i < testN; i++){
      String input1 = input.next();
      int depth = 0;
      String output;
      StringBuilder str = new StringBuilder(); 
      for(int j = 0; j < input1.length(); j++){
        if(input1.charAt(j) == '('){
          depth += 1;
          str.append("(");
        }
        if(input1.charAt(j) == ')'){
          depth -= 1;
          str.append(")");
        }
        if(depth != (int)input1.charAt(j)-48){
          int diff = (int)input1.charAt(j)-48 - depth;
          for(int k = 0; k < diff; k++){
            str.append("(");
          }
          str.append(input1.charAt(j));
          for(int k = 0; k < diff; k++){
            str.append(")");
          }
        }
        else{
          str.append(input1.charAt(j));
        }
      }
      output = str.toString();
      output = output.replace(")(", "");
      output = output.replace(")(", "");
      int test = i + 1;
      System.out.println("Case #" + test + ": "  + output);
    }
  }
}
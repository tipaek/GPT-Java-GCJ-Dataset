import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt();
    String result[] = new String[t];
    for (int j = 0; j < t; ++j) {
      // taking input
      String pre_input = scan.next();
      
      // Process
      int len = pre_input.length();
      // Converting to character array
      char[] input = pre_input.toCharArray();
      String output = "";
      
      for(int i = 0; i < len; ++i) {
          if (i == 0){
              if (input[i] == '0'){
                    output = output.concat("0");
              }
              if (input[i] == '1'){
                    output = output.concat("(1");
              }
          }
          if (i > 0 && i < (len - 1)) {
              if (input[i] > input[i - 1]) {
                  output = output.concat("(").concat(Character.toString(input[i]));
              }
              if (input[i] == input[i - 1]) {
                  output = output.concat(Character.toString(input[i]));
              }
              if (input[i] < input[i - 1]) {
                  output = output.concat(")").concat(Character.toString(input[i]));
              }
          }
          if ( i == (len - 1)) {
              if (input[i] > input[i - 1]) {
                  output = output.concat("(").concat(Character.toString(input[i]));
              }
              if (input[i] == input[i - 1]) {
                  output = output.concat(Character.toString(input[i]));
              }
              if (input[i] < input[i - 1]) {
                  output = output.concat(")").concat(Character.toString(input[i]));
              }
          }
          
      }
      
      System.out.println(output);
      // Storing Output
      //result[i] = ;
    }
    // Printing Values
    //for(int i = 0; i < t; ++i){
        //System.out.println("Case #" + (i + 1) + ": " + result[i][0] + " " + result[i][1] + " " + result[i][2]);   
    //}
  }
}
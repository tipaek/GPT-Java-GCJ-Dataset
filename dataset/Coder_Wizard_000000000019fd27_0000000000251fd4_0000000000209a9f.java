import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt();
    //String result[] = new String[t];
    for (int i = 0; i < t; ++i) {
      // taking input
      String pre_input = scan.next();
      
      // Process
      int len = pre_input.length();
      
      // Converting to character array
      char[] input = pre_input.toCharArray();
      String output = ""; // Creating a output string
      
      // Declaring a largest variable
      int largest = 0;
      
      for(int j = 0; j < len; ++j) {
          //converting the element to string
          String Char = Character.toString(input[j]);
          //converting the element to integer
          int integer = Integer.parseInt(Char);
          
          if(j == 0){
              largest = integer;
          }
          
          if(input[j] != '0' && j == 0){
              for(int k = 1; k <= integer; ++k){
                  output = output.concat("(");
              }
          }
          if(input[j] == '0')
          {
              if(j != 0){
                  if(input[j] != input[j - 1]){
                      int diff = input[j - 1] - input[j];
                      for(int k = 1; k <= diff; ++k){
                          output = output.concat(")");
                      }
                  }
              }
              output = output.concat("0");
          }
          if(input[j] != '0'){
              if(j != 0){
                  if(input[j] != input[j - 1]){
                      if(input[j] < input[j - 1]){
                            int diff = input[j - 1] - input[j];
                            for(int k = 1; k <= diff; ++k){
                                output = output.concat(")");
                            }
                            if(largest < integer)
                            {
                                largest = integer;
                            }
                      }
                      if(input[j] > input[j - 1]){
                          int diff = 0;
                          if(largest < integer)
                            {
                                largest = integer;
                                diff = input[j] - input[j - 1];
                            }
                          if(largest > integer)
                            {
                                diff = largest - input[j - 1];
                            }
                            for(int k = 1; k <= diff; ++k){
                                output = output.concat("(");
                            }
                      }
                  }
              }
              output = output.concat(Char);
              if(j == len - 1){
                  output = output.concat(")");
              }
          }
      }
      // Printing Output
      System.out.println("Case #" + (i + 1) + ": " + output);
    }
  }
}
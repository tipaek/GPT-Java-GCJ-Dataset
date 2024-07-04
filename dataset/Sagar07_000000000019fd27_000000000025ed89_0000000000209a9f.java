import java.util.*;
import java.io.*;
public class Solution 
{
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt();
    
    for (int i = 0; i < t; ++i) 
    {
      String nextinput = scan.next();
      int length = nextinput.length();
      
      char[] input = nextinput.toCharArray();
      String output = ""; 
      
      for(int j = 0; j < length; ++j) 
      {
          String Char = Character.toString(input[j]);
          int integer = Integer.parseInt(Char);
          if(input[j] != '0' && j == 0)
          {
              for(int k = 1; k <= integer; ++k)
              {
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
                      }
                      if(input[j] > input[j - 1]){
                            int diff = input[j] - input[j - 1];
                            for(int k = 1; k <= diff; ++k){
                                output = output.concat("(");
                            }
                      }
                  }
              }
              output = output.concat(Char);
              if(j == length - 1){
                    for(int k = 1; k <= integer; ++k){
                          output = output.concat(")");
                    }
                }
          }
      }
     
      System.out.println("Case #" + (i + 1) + ": " + output);
    }
  }
}
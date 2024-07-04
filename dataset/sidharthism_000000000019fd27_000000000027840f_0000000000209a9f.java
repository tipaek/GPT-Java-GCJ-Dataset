import java.util.*;
import java.io.*;
public class Nestingdepth {
  public static void main(String[] args) {
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int m = s.nextInt();
    
    for (int i = 0; i < m; ++i) {
      // taking input
      String pre_input = s.next();
      
      // Process
      int l = pre_input.length();
      
      // Converting to character array
      char[] inp = pre_input.toCharArray();
      String outp = ""; // Creating a output string
      
      for(int j = 0; j < l; ++j) {
          //converting the element to string
          String Ch = Character.toString(inp[j]);
          //converting the element to integer
          int intej = Integer.parseInt(Ch);
          if(inp[j] != '0' && j == 0){
              for(int k = 1; k <= intej; ++k){
                  outp = outp.concat("(");
              }
          }
          if(inp[j] == '0')
          {
              if(j != 0){
                  if(inp[j] != inp[j - 1]){
                      int dif = inp[j - 1] - inp[j];
                      for(int k = 1; k <= dif; ++k){
                          outp = outp.concat(")");
                      }
                  }
              }
              outp = outp.concat("0");
          }
          if(inp[j] != '0'){
              if(j != 0){
                  if(inp[j] != inp[j - 1]){
                      if(inp[j] < inp[j - 1]){
                            int dif = inp[j - 1] - inp[j];
                            for(int k = 1; k <= dif; ++k){
                                outp = outp.concat(")");
                            }
                      }
                      if(inp[j] > inp[j - 1]){
                            int dif = inp[j] - inp[j - 1];
                            for(int k = 1; k <= dif; ++k){
                                outp = outp.concat("(");
                            }
                      }
                  }
              }
              outp = outp.concat(Ch);
              if(j == l - 1){
                    for(int k = 1; k <= intej; ++k){
                          outp = outp.concat(")");
                    }
                }
          }
      }
      // Printing Output
      System.out.println("Case #" + (i + 1) + ": " + outp);
    }
  }
}
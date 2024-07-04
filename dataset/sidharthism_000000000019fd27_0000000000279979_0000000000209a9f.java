import java.util.*;
import java.io.*;
public class Nesting {
  public static void main(String[] args) {
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int m = s.nextInt();
    
    for (int i = 0; i < m; ++i) {
      String pre_inp = s.next();
      
      int l = pre_inp.length();
      
      char[] inp = pre_inp.toCharArray();
      String outp = ""; 
      
      for(int j = 0; j < l; ++j) {

          String Ch = Character.toString(inp[j]);
  
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
      System.out.println("Case #" + (i + 1) + ": " + outp);
    }
  }
}
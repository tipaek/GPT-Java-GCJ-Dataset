import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
    
  public static String nestingDepth(String input){
      int depth = 0;
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<input.length();i++){
          if(Integer.valueOf(input.charAt(i)-48)==depth){
              sb.append(input.charAt(i));
              continue;
          }else if(Integer.valueOf(input.charAt(i)-48)>depth){
              int openBraces = Integer.valueOf(input.charAt(i) -48) - depth;
              for(int j=0;j<openBraces;j++){
                  sb.append("(");
              }
              depth +=openBraces;
          }else{
              int closingBraces = depth - Integer.valueOf(input.charAt(i) - 48);
              for(int j=0;j<closingBraces;j++){
                  sb.append(")");
              }
              depth -=closingBraces;
          }
          sb.append(input.charAt(i));
      }
      
      while(depth > 0){
           sb.append(")");
           depth--;
      }
      
      return sb.toString();
  }
    
  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) {
            String inputString = in.next();
            
            System.out.println("Case #"+i+": "+ nestingDepth(inputString));
        }
     }
}
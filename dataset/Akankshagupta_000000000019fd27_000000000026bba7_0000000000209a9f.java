import java.util.Scanner;
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int cases = Integer.parseInt(in.nextLine());
    for(int  i = 1; i<=cases;i++){
      String str = in.nextLine();
      StringBuilder builder = new StringBuilder();
      Integer prev = null;
      for(int j = 0; j< str.length();j++){
        int val = str.charAt(j)-'0';
        if(prev == null){
          for(int k = 0; k< val;k++){
            builder.append("(");
          }
          builder.append(val);
          prev = val;
          continue;
        }
        if(prev < val){
          for(int k = 0; k< prev;k++) {
            builder.append(")");
          }
          for(int k = 0; k< val;k++){
            builder.append("(");
          }
        }else if(prev > val){
          int diff = prev - val;
          for(int k = 0; k< diff;k++) {
            builder.append(")");
          }
        }
        builder.append(val);
        prev = val;
      }
      for(int k = 0; k< prev;k++) {
        builder.append(")");
      }
      System.out.println("Case #"+i+": " + builder.toString());
      }
    }
}

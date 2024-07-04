import java.util.Scanner;
import java.util.Stack;
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int cases = Integer.parseInt(in.nextLine());
    for(int  i = 1; i<=cases;i++){
      String str = in.nextLine();
      StringBuilder builder = new StringBuilder();
      int count = 0;
      Integer prev = null;
      for(int j = 0; j< str.length();j++){
        int val = str.charAt(j)-'0';
        if(prev == null){
          count = val;
          prev = val;
          for(int k = 0; k< val;k++){
            builder.append("(");
          }
        }
        if (prev > val) {
          int diff = prev - val;
          count -= diff;
          for (int k = 0; k < diff; k++) {
            builder.append(")");
          }
        }
        else if (prev < val) {
          int diff = val - prev;
          count += diff;
          for (int k = 0; k < diff; k++) {
            builder.append("(");
          }
        }
        builder.append(val);
        prev = val;
      }
      for(int k = 0; k< count;k++) {
        builder.append(")");
      }
      System.out.println("Case #"+i+": " + builder.toString());
      }
    }
}

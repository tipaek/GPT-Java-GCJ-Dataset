import java.util.Scanner;
public class Solution {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int testTotal = Integer.parseInt(in.nextLine());
    for(int  i = 1; i<=testTotal;i++){
      String input = in.nextLine();
      StringBuilder builder = new StringBuilder();
      Integer first = null;
      for(int j = 0; j< input.length();j++){
        int val = input.charAt(j)-'0';
        if(first == null){
          for(int k = 0; k< val;k++){
            builder.append("(");
          }
          builder.append(val);
          first = val;
          continue;
        }
        if(first < val){
          for(int k = 0; k< first;k++) {
            builder.append(")");
          }
          for(int k = 0; k< val;k++){
            builder.append("(");
          }
        }else if(first > val){
          int diff = first - val;
          for(int k = 0; k< diff;k++) {
            builder.append(")");
          }
        }
        builder.append(val);
        first = val;
      }
      for(int k = 0; k< first;k++) {
        builder.append(")");
      }
      System.out.println("Case #"+i+": " + builder.toString());
      }
    }
}

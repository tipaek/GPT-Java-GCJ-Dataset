
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    sc.nextLine();
    for (int k = 1; k <= t; k++) {
      String str = sc.nextLine();
      StringBuilder s = new StringBuilder();
      boolean one = false;
      int n = str.length();
      for(int i = 0; i < n; i++){
        if(str.charAt(i) == '1'){
          if(!one){
            one = true;
            s.append("(");
          }
        }
        else if(str.charAt(i) == '0' && i > 0 && str.charAt(i-1) == '1'){
          one = false;
          s.append(")");
        }
        s.append(str.charAt(i));
      }
      if(one){
        s.append(")");
      }
      System.out.println("Case #" + k + ": " + s.toString());
    }
  }
}

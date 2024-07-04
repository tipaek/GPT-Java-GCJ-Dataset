import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i1 = 0; i1 < t; i1++) {
       char[] s = br.readLine().toCharArray();
       String ans = "";
       int prev = 0;
       int lval = 0;
       for(int i=0;i<s.length;i++) {
         int val = (int)(s[i] - '0');
         if(val>lval) {
           ans = addLeft(ans, val, lval);
           ans+=val;
           lval = val;
         }
         else if(val==lval) {
           ans+=val;
           lval = val;
         }
         else {
           ans = addRight(ans, val , lval);
           ans+=val;
           lval = val;
         }
         if(i==s.length-1)
           ans = addRight(ans, 0, val);
       }
       System.out.println("Case #" + (i1 + 1) + ": " + ans);
    }
  }
  
  public static String addLeft(String ans, int curr, int last) {
    for(int i = last; i<curr; i++) {
      ans+="(";
    }
    return ans;
  }
  
  public static String addRight(String ans, int curr, int last) {
    for(int i = curr; i<last; i++) {
      ans+=")";
    }
    return ans;
  }
}

import java.util.*;

public class Solution
{
    public static void main (String [] args) {
        Solution s = new Solution();
        s.run();
    }
    
    public void run()
    {
      Scanner scan = new Scanner(System.in);
      int T = Integer.parseInt(scan.nextLine());
      for (int a = 0; a < T; a++) {
        String s = scan.nextLine();
        String ans = "";
        int prev = s.charAt(0) - '0';
        for (int i = 0; i < prev; i++) ans += "(";
        ans += s.charAt(0);
        int depth = prev;
        for (int i = 1; i < s.length(); i++) {
          int num = s.charAt(i) - '0';
          if (num > prev) {
            for (int j = 0; j < num-depth; j++) ans += "(";
            depth += (num-depth);
          } else if (num < prev) {
            for (int j = 0; j < depth-num; j++) ans += ")";
            depth -= (depth-num);
          } 
          ans += (""+num);
          
          
          
          prev = num;
        }
        for (int i = 0; i < depth; i++) ans += ")";
        System.out.println(ans);
      }
    }
}
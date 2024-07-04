import java.io.*; 
import java.util.*;
class Solution 
{ 
  public static void main(String[] args)throws Exception 
  { 
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int n = sc.nextInt();
    for (int i = 1; i <= n; ++i) {
        String str = sc.next();
        String res = "";
        int prev = (int) str.charAt(0) - 48;
        for (int k = 0; k < prev - 0; ++k) {
            res += "(";
        }
        res+=prev;
        for (int j = 1; j < str.length(); ++j) {
            int cur = (int) str.charAt(j) - 48;;
            int hieu = cur - prev;
            if (hieu < 0) {
                for (int k = 0; k > hieu; --k) {
                    res += ")";
                }
            } else
            if (hieu > 0) {
                for (int k = 0; k < hieu; ++k) {
                    res += "(";
                }
            }
            res += cur;
            prev = cur;
        }
        for (int k = 0; k < prev; ++k) {
            res += ")";
        }
        System.out.println("Case #" + i + ": " + res);
    }
  }
} 
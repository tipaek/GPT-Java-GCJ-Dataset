import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      String result = "";
      int cnt = 0;
      int prevTmp = -1;
      for(int j = 0; j < s.length(); j++) {
        
        int tmp = Integer.parseInt(String.valueOf(s.charAt(j)));
        if(j==0) {
            for(int k = 0; k < tmp; k++) {
                result += "(";
                cnt++;
            }
        } else {
            if(prevTmp == tmp) {
                // Do Nothing
            } else if(prevTmp > tmp) {
                int diff = prevTmp - tmp;
                for(int k = 0; k < diff; k++) {
                    result += ")";
                    cnt--;
                }
            } else {
                int diff = tmp - prevTmp;
                for(int k = 0; k < diff; k++) {
                    result += "(";
                    cnt++;
                }
            }
        }
        result += tmp;
        prevTmp = tmp;
      }
      if(cnt > 0) {
        for(int k = 0; k < cnt; k++) {
            result += ")";
        }
      }

      System.out.println("Case #" + i +": "+ result);
    }
    in.close();
  }
} 
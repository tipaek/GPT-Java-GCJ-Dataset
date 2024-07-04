import java.util.*;
import java.io.*;
class Solution {
  public static void main(String[] args) throws IOException{
    BufferedReader b1 = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(b1.readLine());
    int cases = 1;
    while(t-->0) {
      String s = b1.readLine();
      String res = s;
      int shift = 0; //this is how much the other indices get shifted by in res
      for(int i = 0; i<s.length(); i++) {
        int cnt = 0;
        while(i == 0 && cnt != Integer.parseInt(String.valueOf(s.charAt(0)))) {
          res = "(" + res;
          cnt++;
          shift++;
        }
        if(i == 0) {
          continue;
        }
        else {
          int left = Integer.parseInt(String.valueOf(res.charAt(shift+i-1)));
          int right = Integer.parseInt(String.valueOf(res.charAt(shift+i)));
          if(left > right) {
            while(left != right) {
              res = res.substring(0, shift+i) + ")" + res.substring(shift+i);
              shift++;
              left--;
            }
          }
          else if(left < right) {
            while(left != right) {
              res = res.substring(0, shift+i) + "(" + res.substring(shift+i);
              shift++;
              right--;
            }
          }
          else {
            continue;
          }
        }
      }
      int right = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
      while(right != 0) {
        res+=")";
        right--;
      }
      System.out.println("Case #" + cases + ": " + res);
      cases++;
    }
  }
}
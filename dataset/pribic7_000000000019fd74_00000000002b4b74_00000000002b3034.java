//package Q2020.rount1A.patternmatching;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
        int N = sc.nextInt();
        String[] str = new String[N];
        int maxL = Integer.MIN_VALUE;
        String maxS = "";
      for (int j = 0; j < N; j++) {
        str[j] = sc.next();
        int ll = str[j].length();
        if(ll > maxL) {
          maxL = ll;
          maxS = str[j];
        }
      }
      boolean flag = true;
      maxS = maxS.substring(1);
      for(String s : str) {
        String sss = s.substring(1);
        if(!maxS.endsWith(sss)) {
          flag = false;
          break;
        }
      }
      if(flag) {
        System.out.println(String.format("Case #%d: %s", i, maxS));
      } else {
        System.out.println(String.format("Case #%d: %s", i, "*"));
      }
      
    }
    sc.close();
  }
}

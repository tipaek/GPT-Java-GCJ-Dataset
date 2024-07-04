//package Q2020.rount1A.patternmatching;

import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
        int N = sc.nextInt();
        String[] strFirst = new String[N];
        String[] strLast = new String[N];
        int maxF = Integer.MIN_VALUE;
        int maxL = Integer.MIN_VALUE;
        String maxFS = "";
        String maxLS = "";
      for (int j = 0; j < N; j++) {
        String str = sc.next();
        int index = str.indexOf("*");
        strFirst[j] = str.substring(0, index);
        if(index == str.length() -1) {
          strLast[j] = "";
        } else {
          strLast[j] = str.substring(index + 1);
        }
        
        int fl = strFirst[j].length();
        int ll = strLast[j].length();
        
        if(fl > maxF) {
          maxF = fl;
          maxFS = strFirst[j];
        }
        if(ll > maxL) {
          maxL = ll;
          maxLS = strLast[j];
        }
      }
      boolean flag = true;
     // maxFS = maxFS.substring(1);
      for(String s : strFirst) {
       // String sss = s.substring(1);
        if(!maxFS.startsWith(s)) {
          flag = false;
          break;
        }
      }

      boolean flag1 = true;
      //maxLS = maxLS.substring(1);
      for(String s : strLast) {
       // String sss = s.substring(s.);
        if(!maxLS.endsWith(s)) {
          flag = false;
          break;
        }
      }
      
      if(flag && flag1) {
        System.out.println(String.format("Case #%d: %s", i, maxFS + maxLS));
      } else {
        System.out.println(String.format("Case #%d: %s", i, "*"));
      }
      
    }
    sc.close();
  }
}

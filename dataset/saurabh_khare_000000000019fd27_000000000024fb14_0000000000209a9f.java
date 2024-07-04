import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String s=in.next();
          String par=abc(s);
          System.out.println("Case #"+i+" "+par);
        }
      }
      public static String abc(String s){
          String re="";
          for(int i=0;i<s.length();i++){
              int a=Integer.parseInt(s.substring(i,i+1));
              for(int j=1;j<=a;j++){
                  re=re+"(";
              }
              re=re+s.charAt(i);
              for(int k=1;k<=a;k++){
                  re=re+")";
              }
          }
        return re;
      }
    }
  
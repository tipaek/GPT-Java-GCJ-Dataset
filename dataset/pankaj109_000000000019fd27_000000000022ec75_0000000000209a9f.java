import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          String S=in.next();
          int length=S.length();
          String S1="";
          int nextDigit=0;
          for(int k=0;k<length;k++){
              int previousDigit=nextDigit;
              nextDigit=Integer.parseInt(String.valueOf(S.charAt(k)));
              int n=Math.abs(nextDigit-previousDigit);
              for(int j=0;j<n;j++){
                  S1+=nextDigit-previousDigit>0?"(":")";
              }
              S1+=nextDigit;
          }
          for(int j=0;j<nextDigit;j++){
                  S1+=")";
              }
          System.out.println("Case #" + i + ": " + S1);
        }
      }
    }
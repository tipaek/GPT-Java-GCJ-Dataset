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
          int count=0;
          for(int i=0;i<s.length()-1;i++){
              int a=Integer.parseInt(s.substring(i,i+1));
             
              for(int j=1;j<=a;j++){
                  if(count<a)
                  re=re+"(";
                  count++;
              }
              
              re=re+s.charAt(i);
              
              if(a==Integer.parseInt(s.substring(i+1,i+2)))
              continue;
              for(int k=1;k<=a;k++){
                  re=re+")";
              }
          }
          if(s.charAt(s.length()-1)=='0')
          re=re+'0';
          else{
              for(int i=1;i<=1;i++){
                  re=re+"(";
              }
              re=re+s.charAt(s.length()-1);
              for(int i=1;i<=1;i++){
                  re=re+")";
              }
          }
        return re;
      }
    }
  
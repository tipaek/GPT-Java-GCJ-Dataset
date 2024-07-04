import java.util.*;
import java.io.*;
public class Solution {
  	public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int i,j;
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    //System.out.println(t);
    for (j = 1; j <= t; ++j) {
        //System.out.println("hi");
      String s = in.next();
      //System.out.println(s);
      String r="";
      int n = s.length();
      for(i=0;i<n;){
          if(s.charAt(i)=='1'){
              r+='(';
              while(i<n && s.charAt(i)=='1'){
                  r+='1';
                  i++;
              }
              r+=')';
          }else{
              r+='0';
              i++;
          }
      }
      System.out.println("Case #" + j + ": " +r);
    }
  }
}
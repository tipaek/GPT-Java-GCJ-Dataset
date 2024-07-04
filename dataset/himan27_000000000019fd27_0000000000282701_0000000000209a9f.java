import java.util.*;
import java.io.*;
public class Solution {
  	public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int i,j,b,diff;
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    //System.out.println(t);
    for (j = 1; j <= t; ++j) {
        int open=0,close=0;
        
        //System.out.println("hi");
      String s = in.next();
      int n=s.length();
      String r="";
      if(s.length()==1){
          for(i=0;i<(s.charAt(0)-'0');i++){
              r+='(';
          }
          r+=s.charAt(0);
          for(i=0;i<(s.charAt(0)-'0');i++){
              r+=')';
          }
      }else{
            int curr=0;
            for(i=0;i<(s.charAt(0)-'0');i++){
              r+='(';
              open++;
          }
          r+=s.charAt(0);
            for(i=1;i<n;i++){
            diff = s.charAt(i)-s.charAt(i-1);
            if(diff>0){
                for(b=0;b<diff;b++){
                    r+='(';
                    open++;
                }
                r+=s.charAt(i);
            } else{
                diff*=-1;
                for(b=0;b<diff;b++){
                    r+=')';
                    close++;
                }
                r+=s.charAt(i);
            }
            
      }
      
      diff = open - close;
      while(diff!=0){
          r+=')';
          diff--;
      }
      
      }
      //System.out.println(s);
      
      
     
      System.out.println("Case #" + j + ": " +r);
    }
  }
}
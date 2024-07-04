import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
          String b= s.next();
          StringBuilder m = new StringBuilder(""); 
          int f=0;
        for(int j=0;j<b.length();j++){
        if(b.charAt(j)=='1' && f==0)
          {m.append("(1");
          f=1;}
        else if(b.charAt(j)=='0'&& f==1)
          {m.append(")0");
         f=0;}
          else
          m.append(String.valueOf(b.charAt(j)));
        
        }if(f==1)
      m.append(")");
        System.out.println("Case #"+(i+1)+": "+m);
        }
  }
}
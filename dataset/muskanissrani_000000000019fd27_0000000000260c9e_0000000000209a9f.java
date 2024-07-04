import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Case #"+(i+1)+": ");
          String b= s.next();
          String m="";
          int f=0,k=0;
          for(int j=0;j<b.length();j++){
        if(b.charAt(j)=='1' && f==0)
          {m=m.concat("(1");
          f=1;}
        else if(b.charAt(j)=='0'&& f==1)
          {m=m.concat(")0");
         f=0;}
          else
          m=m.concat(String.valueOf(b.charAt(j)));
        
        }if(f==1)
       m= m.concat(")");
        System.out.println(m);
        }
  }
}
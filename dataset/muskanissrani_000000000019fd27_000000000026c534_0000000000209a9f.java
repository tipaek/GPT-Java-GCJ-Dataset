import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
          String b= s.next();
          int f=0;
        for(int j=0;j<b.length();j++){
            if(b.charAt(j)=='1' && f==0)
            {
            b=b.substring(0,j)+'('+b.substring(j,b.length());f=1;continue;}
            else if(b.charAt(j)=='0' && f==1)
            {b=b.substring(0,j)+')'+b.substring(j,b.length());f=0;continue;}
        }
        if(f==1)
        b=b+')';
        
        System.out.println("Case #"+(i+1)+": "+b);
        }
  }
}
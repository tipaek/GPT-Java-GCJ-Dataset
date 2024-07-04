import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Case #"+(i+1)+": ");
          String b= s.next();
          int f=0;
          for(int j=0;j<b.length();j++){
        if(b.charAt(j)=='1' && f==0)
          {System.out.print("(1");f=1;}
        else if(b.charAt(j)=='0'&& f==1)
          {System.out.print(")0");f=0;}
          else
          System.out.print(b.charAt(j));
        
        }if(f==1)
        System.out.println(")");
        else
        System.out.println();
        }
  }
}
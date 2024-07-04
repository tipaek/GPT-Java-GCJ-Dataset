import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();  
    for (int l = 1; l <= t; l++) 
    {
      String s=sc.next();
      String ans="";
      int dep=0;
      for(int i=0;i<s.length();i++)
      {
          int currd=s.charAt(i)-'0';
          while(currd>dep)
          {
              ans+="{";
              dep++;
          }
          while(currd<dep)
          {
              ans+="}";
              dep--;
          }
          ans+=s.charAt(i);
      }
          while(dep>0)
          {
              ans+="}";
              dep--;
          }
      
  
      
      
      System.out.println("Case #" + l + ": " +ans);
    }
  }
}
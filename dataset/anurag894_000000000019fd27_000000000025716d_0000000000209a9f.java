import java.util.*;
import java.io.*;
import java.lang.*;
class Solution
{
public static void main(String [] args)
{
  Scanner s=new Scanner(System.in);
  int T=s.nextInt();
  s.nextLine();
  for(int t=1;t<=T;t++)
  {
     String S=s.nextLine();
     int N=S.length();
     int d=0;
     String A="";
     for(int i=0;i<N;i++)
     {
         int cd=S.charAt(i)-'0';
         while(cd>d)
         {
             ++d;
             A+="(";
         }
         while(cd<d)
         {
             --d;
             A+=")";
         }
         A+=S.charAt(i);
     }
     while(d>0)
     {
         --d;
         A+=")";
     }
     System.out.println("Case #"+t+": "+A);
     
  }
}
}

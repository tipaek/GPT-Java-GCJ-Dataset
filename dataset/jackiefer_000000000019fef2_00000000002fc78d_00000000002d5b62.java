import java.util.*;
import java.io.*;
class Solution
{ 
  public static void main(String args[]) throws Exception
   {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     Scanner sc=new Scanner(System.in);
     int tcases=Integer.parseInt(br.readLine());
     for(int t=0;t<tcases;t++)
      {
       int x,y;
       x=sc.nextInt();
       y=sc.nextInt();
       String str="";
       if((x+y)%2==0)
       {
           str="IMPOSSIBLE";
       }
       else
       {
           str="";
       }
       
       
       
       System.out.println("Case #"+tcases+": "+str);
      }
   }
}
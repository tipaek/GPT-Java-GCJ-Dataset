import java.util.*;
import java.io.*;
class Solution
{ 
  public static void main(String args[]) throws Exception
   {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int tcases=Integer.parseInt(br.readLine());
     for(int t=0;t<tcases;t++)
      {
       int x,y;
       String arr[]=br.readLine().split(" ");
       x=Integer.parseInt(arr[0]);
       y=Integer.parseInt(arr[1]);
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
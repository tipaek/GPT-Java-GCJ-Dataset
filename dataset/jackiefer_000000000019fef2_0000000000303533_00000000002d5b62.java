import java.util.*;
import java.io.*;
class Solution
{  
    static String block(int x,int y) 
{  String str=""; 
    ArrayList<Integer> forx = new ArrayList<Integer>(); 
    ArrayList<Integer> fory = new ArrayList<Integer>();   
    while (x > 0)  
    { 
        forx.add(x % 2); 
        x = x / 2; 
    } 
     while (y > 0)  
    { 
        fory.add(y % 2); 
        y = y/ 2; 
    } 
  if(forx.size()<fory.size())
  {
    for (int i = 0; i < forx.size(); i++)  
    {   if(forx.get(i)==0&&fory.get(i)==0)
         {
             str="IMPOSSIBLE";
             break;
         }
         else if(forx.get(i)==1&&fory.get(i)==1)
         {
             str="IMPOSSIBLE";
             break;
         }
        else if (forx.get(i) == 1)  
        { 
           str+="E";
        }
        else
        { 
           str+="N";
        }
    }
  }    
return str;
} 
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
       str="";
       if((x+y)%2==0)
       {
           str="IMPOSSIBLE";
       }
       else
       {
           str=block(Math.abs(x),Math.abs(y));
       }
       if(x<0)
       {
           str.replace('E','W');
       }
       if(y<0)
       {
           str.replace('N','S');
       }
       
       System.out.println("Case #"+tcases+": "+str);
      }
   }
}
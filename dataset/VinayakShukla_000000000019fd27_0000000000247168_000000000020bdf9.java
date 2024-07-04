import java.util.*;
import java.io.*;
 class Pair implements Comparable<Pair>
 {
  int low;
  int high;
   public int compareTo(Pair m) 
    { 
        if(this.high==m.high)
        return this.low-m.low;
        return this.high-m.high;
    }
    Pair(int low,int high)
    {
        this.low=low;
        this.high=high;
    }
 }
 public class Solution{
     public static void main(String args[])
     {
         Scanner sc=new Scanner(System.in);
         int testcase=sc.nextInt();
         int t=1;
         while(t<=testcase)
         { int size=sc.nextInt();
           Pair arr[]=new Pair[size];
           for(int i=0;i<size;i++)
            {
                arr[i]=new Pair(sc.nextInt(),sc.nextInt());
            }
         Arrays.sort(arr);
         String str="";
       Pair c=new Pair(0,0);
       Pair j=new Pair(0,0);
         for(int i=0;i<size;i++)
         {
           if(arr[i].low>=c.high)
            {c.high=arr[i].high;
             c.low=arr[i].low;
            str+="C" ;   
            }
           else if(arr[i].low>=j.high)
           {j.high=arr[i].high;
            j.low=arr[i].low;
           str+="J";}
           else if(arr[i].high<=c.low)
           {
             str+="C";  
           }
           else if(arr[i].high<=j.low)
           {
               str+="J";
           }
           else
          { str="IMPOSSIBLE";
              break;
          }
         }
             
          System.out.println("Case  #"+t+": "+str); 
          t++;
         }
     }
 }
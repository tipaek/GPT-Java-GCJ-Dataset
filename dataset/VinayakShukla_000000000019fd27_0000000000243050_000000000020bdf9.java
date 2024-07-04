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
         int c=-1,j=-1;
         for(int i=0;i<size;i++)
         {
           if(arr[i].low>=c)
            {c=arr[i].high;
            str+="C" ;   
            }
           else if(arr[i].low>=j)
           {j=arr[i].high;
           str+="J";}
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
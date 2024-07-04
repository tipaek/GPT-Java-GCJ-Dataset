import java.util.*;
import java.io.*;
 
 public class Solution{
     public static void main(String args[])
     {
         Scanner sc=new Scanner(System.in);
         int testcase=sc.nextInt();
         int t=1;
         while(t<=testcase)
         {
             int size=sc.nextInt();
             int arr[][]=new int[size][size];
             for(int i=0;i<size;i++)
             for(int j=0;j<size;j++)
             arr[i][j]=sc.nextInt();
             int count=0, countr=0, countc=0;
             HashSet<Integer> setr=new HashSet();
               HashSet<Integer> setc=new HashSet();
             for(int i=0;i<size;i++)
             { setr.clear();
               setc.clear();
             for(int j=0;j<size;j++)
             {
               if(i==j)
               count+=arr[i][j];
              setr.add(arr[i][j]);
              setc.add(arr[j][i]);
             }
                 if(!setr.isEmpty()&&setr.size()!=size)
                 countr++;
                 if(!setc.isEmpty()&&setc.size()!=size)
                 countc++;
             }
          System.out.println("#"+t+": "+count+" "+countr+" "+countc); 
          t++;
         }
     }
 }
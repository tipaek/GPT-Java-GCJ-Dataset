import java.util.*;
import java.io.*;
 
 class abs{
     public static void main(String args[])
     {
         Scanner sc=new Scanner(System.in);
         int testcase=sc.nextInt();
         while(testcase-->0)
         {
             int size=sc.nextInt();
             int arr[][]=new int[size][size];
             int count=0, countr=0, countc=0;
             for(int i=0;i<size;i++)
             { HashSet<Integer> setr=new HashSet();
               HashSet<Integer> setc=new HashSet();
             for(int j=0;j<size;j++)
             {
               if(i==j)
               count+=arr[i][j];
               if(setr.contains(arr[i][j]))
               { countr++;
               }
               else
               setr.add(arr[i][j]);
               if(setc.contains(arr[j][i]))
                countc++;
                else
                setc.add(arr[j][i]);
             }}
          System.out.println("#"+testcase+": "+count+" "+countr+" "+countc);   
         }
     }
 }
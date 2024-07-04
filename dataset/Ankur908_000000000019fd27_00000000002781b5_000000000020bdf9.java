import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
      int test=scan.nextInt();
   
      for(int k=0;k<test;k++) {
    	 int n=scan.nextInt(); 
    	 int[] s=new  int[n];
    	 int[] e=new int[n];
    	 int[] job1=new int[1441];
    	 int[] job2=new int[1441];
    	 for( int i=0;i<n;i++)
    	 {
    		 s[i]=scan.nextInt();
    		 e[i]=scan.nextInt();
    	 }
    	 int imp=0;
    	 StringBuffer a=new StringBuffer();
    	 for(int j = 0 ; j < n ; j++)
         {
             int flag1 = 0 , flag2 = 0;
             for(int i = s[j] ; i < e[j] ; i++)
             {
                 if(job1[i] == 1)
                 {
                     flag1 = 1;
                 }
                 if(job2[i] == 1)
                 {
                     flag2 = 1;
                 }
             }
             if(flag1 == 1 && flag2 == 1)
             {
                 a.setLength(0);
                 a.append("IMPOSSIBLE");
                 System.out.print("Case #"+(k+1)+": "+a);
                 imp = 1;
                 break;
             }
             else if(flag1 == 0)
             {
                 for(int i = s[j] ; i < e[j] ; i++)
                 {
                     job1[i] = 1;
                 }
                 a.append('C');
             }
             else if(flag2 == 0)
             {
                 for(int i = s[j] ; i < e[j] ; i++)
                 {
                     job2[i] = 1;
                 }
                 a.append('J');
             }
         }
    	 
    	 if(imp == 0)
         {
    		 System.out.print("Case #"+(k+1)+": "+a);
         }
    	  
    	  System.out.println();
      }	
		scan.close();
  }
  }

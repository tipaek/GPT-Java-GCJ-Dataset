
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cs=1;
        while(t-->0)
        {
            String s=sc.next();
            //System.out.println(s);
            int n=s.length();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
            	arr[i]=(int)(s.charAt(i)-'0');
            }
          String[] op=new String[n];
          for(int i=0;i<n;i++)
          {
        	  String temp="";
        	  int cnt=arr[i];
        	  if(i!=0)
        	  {
        		  if(arr[i]>=arr[i-1])
        		  {
        			  cnt=arr[i]-arr[i-1];
        		  }
        		  else
        		  {
        			  cnt=0;
        		  }
        	  }
        	 // System.out.println(cnt);
        	  for(int f=0;f<cnt;f++)
        	  {
        		  temp+="(";
        	  }
        	  temp+=arr[i];
        	  for(int b=0;b<cnt;b++)
        	  {
        		  temp+=")";
        	  }
        	  op[i]=temp;
          }
//          for(int i=0;i<n;i++)
//          {
//        	  System.out.println(op[i]);
//          }
          String ans="";
          ans+=op[0];
          int ind=0;
          for(int i=1;i<n;i++)
          {
        	  for(;ind<ans.length();ind++)
        	  {
        		  if(ans.charAt(ind)-'0'==arr[i-1])
        		  {
        			  break;
        		  }
        	  }
        	  if(arr[i]>=arr[i-1])
        	  {
        		  ind++;
        		  //System.out.println(ind);
        		 if(ind==ans.length())
        		 {
        			 ans+=op[i];
        		 }
        		 else
        		 {
        			 StringBuffer sb=new StringBuffer(ans);
        			 sb.insert(ind, op[i]);
        			 ans=sb.toString();
        			 
        		 }
        	  }
        	  else
        	  {
        		  ind+=arr[i-1]-arr[i]+1;
        		 // System.out.println(ind);
        		  if(ind==ans.length())
        		  {
        			  ans+=op[i];
        		  }
        		  else
        		  {
        			  StringBuffer sb=new StringBuffer (ans);
        			  sb.insert(ind, op[i]);
        			  ans=sb.toString();
        		  }
        	  }
          }
          System.out.println("Case #"+(cs++)+": "+ans.trim());
        }
    }
}
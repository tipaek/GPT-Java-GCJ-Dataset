import java.io.*;
import java.util.*;
public class Solution {
   public static void main(String args[]) throws IOException {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   int t=Integer.parseInt(br.readLine());
	   int c=1;
	   while(c<=t) {
		   int n=Integer.parseInt(br.readLine());
	       String day="";
	       for(int i=0;i<=24*60;i++)
	    	   day+='0';
	       
	       int time[][]=new int[n][2];
	       for(int i=0;i<n;i++) {
	    	   String str[]=(br.readLine()).trim().split("\\s+");
	    	   time[i][0]=Integer.parseInt(str[0]);
	    	   time[i][1]=Integer.parseInt(str[1]);
	       }
	       int flag=0;
	       String res="";
	       for(int i=0;i<n;i++) {
	    	   int start=time[i][0];
	    	   int end=time[i][1];
	    	   String s=day.substring(start,end+1);
	    	   if(s.indexOf('1')==-1) {
	    		   res+='C';
	    		   String temp1=day.substring(0,start+1);
	    		   String temp2=day.substring(end);
	    		   int l=end-start-1;
	    		   String ts="";
	    		   for(int j=0;j<l;j++)
	    			   ts+='1';
	    		   day=temp1+ts+temp2;
	    	   }
	    	   else if(s.indexOf('2')==-1) {
	    		   res+='J';
	    		   String temp1=day.substring(0,start+1);
	    		   String temp2=day.substring(end);
	    		   int l=end-start-1;
	    		   String ts="";
	    		   for(int j=0;j<l;j++ )
	    			   ts+='2';
	    		   day=temp1+ts+temp2;
	    	   }
	    	   else
	    	   {
	    		   System.out.println("Case #"+c+":"+" "+"IMPOSSIBLE");
	    		   flag=1;
	    		   break;
	    	   }
	       }
	     if(flag==0)
	       System.out.println("Case #"+c+":"+" "+res);
			c++;
	   }
   }
}
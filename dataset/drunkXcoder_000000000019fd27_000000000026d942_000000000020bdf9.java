
import java.io.*;
import java.util.*;
public class Solution {
   public static void main(String args[]) throws IOException {
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   int t=Integer.parseInt(br.readLine());
	   int c=1;
	   while(c<=t) {
		   int n=Integer.parseInt(br.readLine());
	       String Cday="";
	       String Jday="";
	       for(int i=0;i<24*60;i++) {
	    	   Cday+='0';
	           Jday+='0';
	       }
	       
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
	    	   String cs=Cday.substring(start,end);
	    	   String js=Jday.substring(start,end);
	    	   
	    	   
	    	   if(cs.indexOf('1')==-1) {
	    		   
	    		   res+='C';
	    		   String temp1="";
	    		   String temp2="";
	    		   if(start==0 && end==1440) {
	    			   temp1="";
	    		       temp2="";
	    		   }
	    		   else if(start==0 && end<1440) {
	    			   temp1="";
	    			   temp2=Cday.substring(end); 	
	    		   }
	    		   else if(end==1440 && start>0) {
	    			   temp1=Cday.substring(0,start);
	    			   temp2="";
	    		   
	    		   }
	    		  
	    		   else {
	    			   temp1=Cday.substring(0,start);
	    			   temp2=Cday.substring(end); 	
	    		   }
	    		   int l=end-start;
	    		   String ts="";
	    		   for(int j=0;j<l;j++)
	    			   ts+='1';
	    		   Cday=temp1+ts+temp2;
	    	   }
	    	   else if(js.indexOf('2')==-1) {
	    		   res+='J';
	    		   String temp1="";
	    		   String temp2="";
	    		   if(start==0 && end==1440) {
	    			   temp1="";
	    		       temp2="";
	    		   }
	    		   else if(start==0 && end<1440) {
	    			   temp1="";
	    			   temp2=Jday.substring(end); 	
	    		   }
	    		   else if(end==1440 && start>0) {
	    			   temp1=Jday.substring(0,start);
	    			   temp2="";
	    		   
	    		   }
	    		  
	    		   else {
	    			   temp1=Jday.substring(0,start);
	    			   temp2=Jday.substring(end); 	
	    		   }
	    		   int l=end-start;
	    		   String ts="";
	    		   for(int j=0;j<l;j++ )
	    			   ts+='2';
	    		   Jday=temp1+ts+temp2;
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

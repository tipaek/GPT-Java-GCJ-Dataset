
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	Scanner o=new Scanner(System.in);
	   int test=o.nextInt();
	   int m=1;
	   while(m<=test){
	     String s=o.next();
	     String e="";
	      boolean u=false;
	      if(s.charAt(0)=='1')
	    	  u=true;
	     for(int i=0;i<s.length();i++) {
	    	 if(u) {
	    		 e=e+"(1";
	    		 i++;
	    		 if(i==s.length()) {
	    			 e=e+')';
	    			 break;
	    		 }
	    		 while(i<s.length()&&s.charAt(i)=='1') {
	    			 e=e+s.charAt(i);
	    			 i++;
	    		 }
	    		 if(i<s.length())
		    		 e=e+')'+'0';
		    		 else
		    			 e=e+')';
		    u=false;	 
	    	 }
	    	 else if(s.charAt(i)=='1') {
	    		 e=e+"(1";
	    		 i++;
	    		 if(i==s.length()) {
	    			 e=e+')';
	    			 break;
	    		 }
	    		 while(i<s.length()&&s.charAt(i)=='1') {
	    			 e=e+s.charAt(i);
	    			 i++;
	    		 }
	    		 if(i<s.length())
	    		 e=e+')'+'0';
	    		 else
	    			 e=e+')';
	    	 }
	    	 else if(s.charAt(i)=='0') {
	    		 e=e+'0';
	    	 }
	     }
	     System.out.println(e);
	     m++;
	     
}
}
}

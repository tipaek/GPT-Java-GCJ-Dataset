import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	
	
    
	public static void main(String[] args){
	    int t;
	    Scanner in=new Scanner(System.in);
	     t=in.nextInt();
	     int tw=0;
	 while(tw++<t)  {  
	    int b=in.nextInt();
	    boolean df=false,sf=false;
	    int da=0,sa=0;
	    boolean drctn=true;
	    
	   
	      String sb1="";
	      String sb2="";
	    
	    
	    for(int i=0;i<b/2;) {
	    	boolean invf=false;
	    	int j=0;
	    	if(sf) {
		    //	System.out.println("SF"+sa);
j++;
		    	System.out.print(sa+1);
		    	System.out.flush();
		    	int tmp=in.nextInt();
		    	if(sb1.charAt(sa)-48!=tmp) {
		    		invf=true;
		    	//	System.out.println("inverting");
		    		
		    		
		    		String st1="",st2="";

		    	//	System.out.println("inverting "+ ch1.toString()+ch2.toString());
		    		for(int k=0;k<sb1.length();k++) {
		    			if(sb1.charAt(k)=='0')
		    				st1+='1';
		    			else
		    				st1+='0';
		    			if(sb2.charAt(k)=='0')
		    				st2+='1';
		    			else
		    				st2+='0';
		    			
		    		}
		    		sb1=st1;
		    		sb2=st2;
		    	}

		    	
	    	}
	    	if(df) {
	    	//	System.out.println("DF"+da);
		    	System.out.print(da+1);
		    	System.out.flush();
		    	int tmp=in.nextInt();
j++;
		    	
		    		if(sb1.charAt(da)-48!=tmp) {
			    	//	System.out.println("reversing");

		    			String tmpr=sb1;
		    			sb1=sb2;
		    			sb2=tmpr;
		    			
		    		}
		    	
	    	}
	    	//System.out.println("__________________________-");
	    	
	    	for(;j<5&&i<b/2;i++,j++) {
	    		
		    	System.out.print(i+1);
		    	System.out.flush();
		    	sb1+=((char)(in.nextInt()+48));
		    	
		    	System.out.print(b-i);
		    	System.out.flush();
		    	sb2+=((char)(in.nextInt()+48));
		    	
		    	if(sb1.charAt(i)!=sb2.charAt(i)) {
			 	   // System.out.println(sb1+"  "+sb2+"___"+sb2.reverse()+"___"+sb2.reverse());

		    		df=true;
		    		da=i;
		    	}
		    	if(sb1.charAt(i)==sb2.charAt(i)) {
		    		//System.out.println(sb1+"  "+sb2+"___"+sb2.reverse()+"___"+sb2.reverse());

		    		sf=true;
		    		sa=i;
		    	}
		    	
		    	
		    //	System.out.println(sb1+"  "+sb2);//.reverse());
		    	
		    	
		    }
	    	
	    	
	    	
	    }
	    StringBuffer sb=new StringBuffer(sb2);
 	    System.out.println(sb1+""+sb.reverse());
        System.out.flush();
        String ret=in.nextLine();
        if(ret.contains("N"))
            return;
	    
	 }
	   
	    
	    
	    
	}
	
	
	
}
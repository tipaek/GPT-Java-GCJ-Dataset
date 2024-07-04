
import java.util.*;

public class Solution {

	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int test=sc.nextInt();
		for (int i = 0; i < test; i++) {
			
			int total=sc.nextInt();
			String str[]=new String[total];
			
			
			String constant=null;
			
			
			String start_value="";
			String middle_value="";
			String last_value="";
			String answer="";
			String extra="";
			
			int constant_val=0;
			for(int j=0;j<total;j++)
			{
			   String s=sc.next();
			   if(!s.contains("*")&&constant_val==0)
			   { constant_val++;
			    constant=s;
			    continue;
			   }
		      char start=s.charAt(0);
		      if(start=='*'&&s.charAt(s.length()-1)!='*') //starting point
		      {
		    	  if(start_value==null)
		    		  {start_value=s.substring(1,s.length());
		    		  //  start_value=start_value+answer;
		    		    }
		    		  
		    	  else {
		    		  
		    		start_value=compare_str(start_value,s.substring(1,s.length()));
		 //	System.out.println("start "+start_value);
		    	  }
		    	  
		      }
		      
		      
		      else  if(s.charAt(s.length()-1)=='*'&&s.charAt(0)!='*') //end point
		      {
		    	  if(last_value==null)
		    		  {last_value=s.substring(0,s.length()-1);
		    		    // answer=last_value;
		    		    }
		    		  
		    	  else {
		    		  
		    		last_value=compare_str_last(last_value,s.substring(0,s.length()-1));
		    		//System.out.println("end "+last_value);
		    	  }
		    	  
		      }
		      
		      
		      else  if(s.charAt(s.length()-1)=='*'&&s.charAt(0)=='*')//middle
		      {
		    	  if(middle_value==null)
	    		  {middle_value=s;
	    		     answer=middle_value;
	    		    }
		    	  else {
		    		  
		    		  middle_value=middle_value+middle_value;
		    	  }
		    	  
		      }
		      else {
		    	  
		    	  
		    	  
		    	  //middle *
		    	  
		    	  
		
		    	  String check_start=s.substring(0,s.indexOf("*"));
		    	
		    	  String check_last=s.substring(s.indexOf("*")+1,s.length());
		    
		    	  
		    	 // System.out.println("final  start "+compare_str_last(check_start,last_value));
		    	  String start_check=compare_str_last(check_start,last_value);
		    	  
		    	//  System.out.println("final end "+compare_str(check_last,start_value));
		    	  
		    	  String end_check=compare_str(check_last,start_value);
			    	 if(start_check.equals("*")||end_check.equals("*"))
			    	 {
			    		 
			    		 start_value="*";
			    		 last_value="";
			    		 
			    	 }
			    	 else {
			    		 
			    		 start_value=end_check;
			    		 last_value=start_check;
			    		 
			    	 }
		    	  
		      }
		     
		      
		      
		      
		      
		      
		      
		      
		      
		 	   
		 }
			
			
			
			if(constant_val>0)
				System.out.println("Case #"+(i+1)+": "+"*");
			else {
				
				System.out.println("Case #"+(i+1)+": "+(last_value+middle_value+start_value));
				
			}
			
			}
			
			
		}

	private static String compare_str(String end_value, String substring) {
		
		int n1=end_value.length();
		int n2=substring.length();
		
		if(n1==n2) 
		{
			if(end_value.equals(substring))
				return end_value;
			else
				 return "*";
			
		}
		else if(n1>n2) //// start_value greater
		{
			int check=n1-n2;
			if(end_value.substring(check,n1).equals(substring))
				return end_value;
			else
				 return "*";
			
		}
		else {
			// start_value less
			
			int check=n2-n1;
				if(end_value.equals(substring.substring(check,n2)))
					return substring;
				else
					 return "*";
				
		}
		
		
  	    }
	
	
	
	
	
	private static String compare_str_last(String start_value, String substring) {
		
		int n1=start_value.length();
		int n2=substring.length();
		
		if(n1==n2) 
		{
			if(start_value.equals(substring))
				return start_value;
			else
				 return "*";
			
		}
		else if(n1>n2) //// start_value greater
		{
			
			if(start_value.substring(0,n2).equals(substring))
				return start_value;
			else
				 return "*";
			
		}
		else {
			// start_value less
			
				
				if(start_value.equals(substring.substring(0,n1)))
					return substring;
				else
					 return "*";
				
		}
		
		
  	    }
	
	
	}





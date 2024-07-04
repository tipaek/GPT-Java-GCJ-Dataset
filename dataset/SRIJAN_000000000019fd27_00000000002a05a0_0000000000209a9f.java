
import java.util.Scanner;
public class Solution {
	
	public static String insertString( 
	        String originalString, 
	        String stringToBeInserted, 
	        int index) 
	    { 
	  
	        // Create a new string 
	        String newString = new String(); 
	  
	        for (int i = 0; i < originalString.length(); i++) { 
	  
	            // Insert the original string character 
	            // into the new string 
	        	if (i == index) { 
	        		  
	                // Insert the string to be inserted 
	                // into the new string 
	                newString += stringToBeInserted; 
	            } 
	            newString += originalString.charAt(i); 
	  
	            
	        } 
	  
	        // return the modified String 
	        return newString; 
	    } 
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int k=in.nextInt();
		for(int a=0;a<k;a++)
		{
			String ans="";
			int lenans=ans.length();
			String s=in.next();
			int len=s.length();
			int prev=0;
			int curr=0;
			for(int b=0;b<len;b++)
			{
				curr=(int)(s.charAt(b))-48;
				if(lenans==0)
				{
					for(int y=0;y<curr;y++)
					{
						ans+="(";
					}
					ans+=Integer.toString(curr);
					for(int y=0;y<curr;y++)
					{
						ans+=")";
					}
					lenans=ans.length();
				}
				else if (prev<curr) 
				{
					int x=curr-prev;
					String st="";
					for(int y=0;y<x;y++)
					{
						st+="(";
					}
					st+=Integer.toString(curr);
					for(int y=0;y<x;y++)
					{
						st+=")";
					}
					
					if(prev!=0)
					{
						ans=insertString(ans,st,lenans-prev);
						lenans=ans.length();
					}
					else
					{
						ans+=st;
						lenans=ans.length();
					}
					
				}
				else if(prev==curr)
				{
					if(curr!=0) {
						int x=prev-curr;
						ans=insertString(ans,Integer.toString(curr),lenans-x-curr);
						lenans=ans.length();
						}
					else {
						ans+=Integer.toString(curr);
						lenans=ans.length();
					}
				}
				else if(prev>curr)
				{
					if(curr!=0) {
						int x=prev-curr;
						ans=insertString(ans,Integer.toString(curr),lenans-x);
						lenans=ans.length();
						}
					else {
						ans+=Integer.toString(curr);
						lenans=ans.length();
					}
				}
				prev=curr;
			}
			System.out.println(ans);
		}
		
	}

}


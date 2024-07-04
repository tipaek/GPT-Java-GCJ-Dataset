import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in .nextInt();
        String[] anotAns = new String[t];
       in.nextLine();
        for(int z=0 ; z<t ; z++)
        {
           
		   
		   String s= in.nextLine();
		
		    int[] arr= new int[s.length()];
		
	  for(int i=0;i<s.length();i++)
			arr[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
		
		
	     	String ans="";
	  for(int i=0;i<arr.length;i++)
		    {
		    String temp="",toUse="";
		    if(arr.length==1)
		    {
		       for(int x=0;x<arr[i];x++ )
		       temp=temp+"(";
		       
		       temp=temp+arr[i];
		       
		       for(int x =0;x<arr[i];x++)
		       temp=temp+")";
		       
		    }
		    else if(i==0)
		    {
		        for(int j=0;j<arr[i];j++)
		        temp=temp+"(";
		        
		        temp=temp+arr[i];
		        
		        
		    }else if(i==arr.length-1)
		    {
		        int count = arr[i]-arr[i-1];
		        if(arr[i]<arr[i-1]  && count!=0 )
		        {
		            toUse=")";
		        }else if(arr[i]>arr[i-1] && count!=0)
		        {
		            toUse="(";
		        }
		        count= Math.abs(count);
		        for(int k=0;k<count;k++)
		          temp=temp+toUse;
		          
		        temp=temp+arr[i];
		        
		        for(int j=0;j<arr[i];j++)
		         temp=temp+")";
		         
		         
		        
		    }else{
		        
		        int count=arr[i]-arr[i-1];
		        if(arr[i]<arr[i-1]  && count!=0 )
		        {
		            toUse=")";
		        }else if(arr[i]>arr[i-1] && count!=0)
		        {
		            toUse="(";
		        }
		        count= Math.abs(count);
		        
		        for(int k=0;k<count;k++)
		         temp=temp+toUse;
		         
		         
		         
		         temp=temp+arr[i];
		    }
		    
		    ans = ans+temp;
		   }
		     anotAns[z]=ans;
        }
	
		
		
		
	
		for(int z=0;z<anotAns.length;z++)
		System.out.println("Case #"+(z+1)+": "+anotAns[z]);
    }
}
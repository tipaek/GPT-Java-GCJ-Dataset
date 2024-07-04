import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution
{
	public static void main(String[] args) {
	    
	    
	    Scanner sc = new Scanner (System.in);
	    
	 
	    int n;
	    int i,j,k;
	    int ts=1;
	    n=sc.nextInt();
	    
	    for (i=0;i<n;i++)
	    {
	        
	           int nopen = 0;
	    int nopa;
	         String  str ="";
	       String s = sc.next();
	       
	       int[] arr = new int[s.length()];
	       
	       for(j=0;j<s.length();j++)
	       {
	           arr[j] = Integer.parseInt((s.valueOf(s.charAt(j))));
	       }
	        
	        for(j=0;j<s.length();j++)
	        {
	         //   System.out.println(arr[j]);
	        
	            nopa = arr[j] - nopen;
	             if(nopa>=0)
	             {
	                 for( k=0;k<nopa;k++)
	                 {
	                     str+='(';
	                     nopen++;
	                 }
	             }
                 else
                 {
                 
                 for( k =0;k<Math.abs(nopa);k++)
                 {
                     
                     str+=')';
                     nopen--;
                     
                 }
                 
                     
                 }	         
                 str+=Integer.toString(arr[j]);
	            
	            
	        }
	        
	        if(nopen>0)
	        {
	            for(int x=0;x<nopen;x++)
	            {
	                str+=')';
	            }
	        }
	        
	        System.out.printf("Case #"+ts+": "+str);
	        ts++;
	        
	          System.out.printf("\n");
	    } 
      
	    
	    
	    
	    
	    
	}
}

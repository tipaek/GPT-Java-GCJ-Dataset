import java.util.*;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k=1;k<=t;k++)
		{
		    String s=sc.next();
		    StringBuffer str=new StringBuffer();
		    int r=Character.getNumericValue(s.charAt(0));
		    int f=0,e=0;
		    for(int j=0;j<r;j++)
		        {
		            str.append('(');
		            
		        }
		        str.append(r);
		        if(1==s.length())
		        {
		            str.append(')');
		        }
		    for(int i=1;i<s.length();i++)
		    {  
		         e=Character.getNumericValue(s.charAt(i-1));
		          f=Character.getNumericValue(s.charAt(i));
		         if(e==f)
		         {
		             str.append(f);
		             continue;
		         } 
		         int n=f-e;
		         if(n<=1)
		        { if(n<1)
		        {
		           for(int j=0;j<Math.abs(n);j++)
		         {
		             str.append(')');
		         } 
		         
		        }
		      
		        if(n>0)
		        {
		         for(int j=0;j<Math.abs(n);j++)
		         {
		             str.append('(');
		         }
		        }
		         str.append(f);
		        }
		        else{
		            for(int j=0;j<(e-f);j++)
		         {
		        
		             str.append(')');
		         }
		    }
		    }
		   
		     for(int j=0;j<f;j++)
		         {
		             str.append(')');
		         }
		    
		    System.out.println("Case #"+k+": "+str);
		}
	}
}
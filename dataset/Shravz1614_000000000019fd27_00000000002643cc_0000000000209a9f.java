import java.util.*;

public class Solution {

	public static void pn(Object o)
    {System.out.println(o);}
    public static void p(Object o)
    {System.out.print(o);}
    
        
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s =new Scanner(System.in);
		int t=s.nextInt();
		
		for(int test=1;test<=t;test++)
		{
		    String str=s.next();
		    String res="";
		    int gg=0;
		    for(int i=0;i<str.length();i+=gg)
		    {
		    	int k=Character.getNumericValue(str.charAt(i));
		    	for(int j=0;j<k;j++)
		    	{
		    		res=res+"(";
		    	}
		    	int count=0;
		    	for(int l=i;l<str.length();l++)
		    	{
		    		if(str.charAt(i)==str.charAt(l))
		    		{count++;}
		    		
		    		else
		    		{
		    			break;
		    		}
		    		
		    	}
		    	gg=count;
		    	for(int p=0;p<count;p++)
		    	{
		    		res=res+k;
		    	}
		    	for(int q=0;q<k;q++)
		    		res=res+")";
		    	
		    		    
		    }
		   
		    
		    pn("Case #"+test+": "+res);
		}
		    
		     
	}

}

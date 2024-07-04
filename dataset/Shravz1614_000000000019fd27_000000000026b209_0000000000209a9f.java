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
			 String str = s.next();
	            String res = "";
	            int open = 0;
	            for (int i=0;i<str.length();i++) {
	                int val = Character.getNumericValue(str.charAt(i));
	                if (open==val) {
	                    res=res+((char)('0'+val));
	                } else if(open<val) {
	                    for (int j=open;j<val;j++) {
	                        res=res+'(';
	                        open++;
	                    }
	                    res=res+((char)('0'+val));
	                } else {
	                    for (int j=open;j>val;j--) {
	                        res=res+')';
	                        open--;
	                    }
	                    res=res+((char)('0'+val));
	                }
	            }
	            for(int i=open;i>0;i--)
	            	res+=')';
		    
	            pn("Case #"+test+": "+res);
		    }
		    
		}
		    
		     
	}



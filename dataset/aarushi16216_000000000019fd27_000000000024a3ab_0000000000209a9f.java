import java.util.HashMap;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for(int k = 1; k<=t; k++)
        {
            String str = sc.nextLine();

            StringBuilder strBrackets = new StringBuilder();
            int openBrackets = 0;
            
            for(int i=0 ;i<str.length(); i++)
            {
            	int value = Character.getNumericValue(str.charAt(i));
            
            	if(value > 0)
            	{
            		if(openBrackets == 0)
            		{
            			for(int j=0; j<value; j++)
            			{
            				strBrackets.append('(');
            				openBrackets += 1;
            			}
            		}
            		else
            		{
	            		if(openBrackets < value)
	            		{	            			
	            			for(int j=0; j<value-openBrackets; j++)
	            			{
	            				strBrackets.append('(');
	            				openBrackets += 1;
	            			}	            			
	            		}
	            		else
	            		{
	            			int closeBrackets = openBrackets - value;
	            			while(closeBrackets -- >0)
	            			{
	            				strBrackets.append(')');
	            				openBrackets -= 1;
	            			}
	            		}
            		}
            	}
            	else
            	{
            		while(openBrackets>0)
        			{
        				strBrackets.append(')');
        				openBrackets -= 1;
        			}
            	}
            	strBrackets.append(""+value);
            }
            
            while(openBrackets -- >0)
			{
				strBrackets.append(')');
			}
 
            System.out.println("Case #"+ k +": "+strBrackets.toString());            
        }
    }
}
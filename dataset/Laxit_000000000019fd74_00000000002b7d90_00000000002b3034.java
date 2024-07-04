
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		    int n = sc.nextInt();
		    String []str = new String[n];
		    
		    int max=0, pos=0;
		    for(int i=0;i<n;i++)
		    {
		        str[i] = sc.next();
		        if(str[i].length() > max)
		        {
		            max=str[i].length();
		            pos=i;
		        }
		    }
		       
		       
		    int count=0;
		    char ch='0';
		    boolean bool = true, isAns = false;
		    for(int i=0;i<max;i++)
		    {
		        count++;
		        bool = true;
		        for(int j=0;j<n;j++)
		        {
		            int val = str[j].length()-count;
		            if(val<0)
		               continue;
		            if(bool && str[j].charAt(val)!='*'){
		                ch= str[j].charAt(val);
		                //System.out.println("yaar");
		                bool = false;
		                continue;
		            }
		            if(str[j].charAt(val)=='*')
		                continue;
		            if(str[j].charAt(val) != ch) {
		                isAns=true;
		                //System.out.println("hi "+str[j].charAt(val)+" "+ch);
		                break;
		            }   
		            
		        }
		        if(isAns) {
		            //System.out.println("hi");
		            break;
		        }
		    }
		    if(isAns)
		       System.out.println("Case #"+temp+": "+"*");
		    else 
		       System.out.println("Case #"+temp+": "+str[pos].substring(1, max));
		    temp++;
		}
	}
}

















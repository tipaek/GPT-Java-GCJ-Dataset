import java.util.*;
import java.io.*;

public class Solution
{
	public static int stringtonumber(char s)
	{
		int num=0;
		for(int i=0;i<1;i++)
		{
			if(s=='0')
				num=num*10+0;
			else if(s=='1')
				num=num*10+1;
			else if(s=='2')
				num=num*10+2;
			else if(s=='3')
				num=num*10+3;
			else if(s=='4')
				num=num*10+4;
			else if(s=='5')
				num=num*10+5;
			else if(s=='6')
				num=num*10+6;
			else if(s=='7')
				num=num*10+7;
			else if(s=='8')
				num=num*10+8;
			else if(s=='9')
				num=num*10+9;
		}
		return num;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cou=1;
		while(t-- > 0)
		{
			String s = sc.next();
			char a[] = s.toCharArray();
        	int num1=0,num2=0;
        	String ans="";
        for(int j=0;j<a.length;j++)
        {
            num1=stringtonumber(a[j]);
            if(j == 0)
            {
            	if(num1 > 0)
            	{
            		for(int i=1;i<=num1;i++)
            			ans += '(';
            	}
            }
            else if(j>=1)
            {
                if(num1>=num2)
                {
                    for(int k=0;k<(num1-num2);k++)
                    {
                        ans += '(';    
                    }
                }
                else
                {
                    for(int k=0;k<(num2-num1);k++)
                    {
                        ans +=')';    
                    }
                }
            }
            else
            {
                for(int w=0;w<num1;w++)
                ans += '(';
            }
            ans += a[j];
            num2=num1;
        }
        num1=stringtonumber(a[a.length-1]);
        for(int j=0;j<num1;j++)
        ans += ')';
        
      	System.out.println("Case #" + (cou) + ": " + ans);
		cou++;  
      
    	}
	}
}
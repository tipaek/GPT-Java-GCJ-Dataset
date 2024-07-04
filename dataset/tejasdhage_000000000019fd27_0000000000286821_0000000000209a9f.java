import java.util.*;
public class Solution {

	public static void main(String[] args) 
	{
	    String str;
	    StringBuffer res;
	    char ch;
		int i,j,k,T,num,diff,prevNum=0;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(i=0;i<T;i++)
		{
		    str=sc.next();
		    res=new StringBuffer();
		    prevNum=0;
		    for(j=0;j<str.length();j++)
		    {
		        ch=str.charAt(j);
		        num=Integer.parseInt(ch+"");
		        diff=num-prevNum;
		        if(diff>=0)
		        {
    		        for(k=0;k<diff;k++)
    		        {
    		            res.append("(");
    		        }
		        }
		        else
		        {
		            diff=Math.abs(diff);
		            for(k=0;k<diff;k++)
		            {
		                res.append(")");
		            }
		        }
		        res.append(ch);
		        prevNum=num;
		    }
		    for(k=0;k<prevNum;k++)
		    {
		        res.append(")");
		    }
		    System.out.println("Case #"+(i+1)+": "+res);
		}
	}

}

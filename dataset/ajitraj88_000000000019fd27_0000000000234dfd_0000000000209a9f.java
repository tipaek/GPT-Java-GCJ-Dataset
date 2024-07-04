import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
	    int L=1;
	    int i,j,k;
	    while(T-->0)
	    {
	        String str=sc.next();
	        Stack<Character> s=new Stack();
	        int id=0;
	        StringBuffer sb=new StringBuffer();
	        while(id<str.length())
	        {
	            int ch=str.charAt(id)-'0';
	            int Z=s.size();
	            int rem=ch-Z;
	            if(rem>0)
	            {
	                for(i=0;i<rem;i++)
	                {
	                    s.push('(');
	                    sb.append('(');
	                }
	            }
	            else if(rem<0)
	            {
	                for(i=0;i<Math.abs(rem);i++)
	                {
	                    s.pop();
	                    sb.append(')');
	                }
	            }
	            sb.append(str.charAt(id));
	            id++;
	        }
	        while(!s.isEmpty())
	        {
	            s.pop();
	            sb.append(')');
	        }
	        System.out.println("Case #"+L+": "+sb);
	        L++;
	    }
    }
}
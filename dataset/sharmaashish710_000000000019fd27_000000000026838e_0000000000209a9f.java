
import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int l=0;l<t;l++)
		{
		    String s=in.next();
		    String str="";
		    int c=0;
		    for(int i=0;i<s.length();i++)
		    {
		        int b=Integer.parseInt(String.valueOf(s.charAt(i)));
		        if(i==0 && b==0)
		        {
		            str=str+"0";
		        }
		        else if(b==0 && (Integer.parseInt(String.valueOf(s.charAt(i-1)))-Integer.parseInt(String.valueOf(s.charAt(i)))==0))
		        {
		            str=str+"0";
		        }
		        else if(b!=0 && s.length()==1)
		        {
		            for(int j=0;j<b;j++)
		            {
		                str=str+"(";
		            }
		            str=str+b;
		            for(int j=0;j<b;j++)
		            {
		                str=str+")";
		            }
		        }
		        else
		        {
	                if(i==0)
	                {
	                    for(int j=0;j<b;j++)
    		            {
    		                str=str+"(";
    		            }
    		            str=str+b;
    		            c=b;
	                }
	                else if(i==s.length()-1)
	                {
	                    int z=Integer.parseInt(String.valueOf(s.charAt(i-1)))-Integer.parseInt(String.valueOf(s.charAt(i)));
	                    if(z==0)
	                    {
	                        str=str+b;
	                    }
	                    else if(z>0)
	                    {
	                        for(int j=0;j<z;j++)
        		            {
        		                str=str+")";
        		            }
        		            str=str+b;
        		            c=c-z;
	                    }
	                    else
	                    {
	                        for(int j=0;j<Math.abs(z);j++)
        		            {
        		                str=str+"(";
        		            }
        		            str=str+b;
        		            c=c+Math.abs(z);
	                    }
	                    for(int j=0;j<c;j++)
	                    {
	                        str=str+")";
	                    }
	                }
	                else
	                {
	                    int z=Integer.parseInt(String.valueOf(s.charAt(i-1)))-Integer.parseInt(String.valueOf(s.charAt(i)));
	                    if(z==0)
	                    {
	                        str=str+b;
	                    }
	                    else if(z>0)
	                    {
	                        for(int j=0;j<z;j++)
        		            {
        		                str=str+")";
        		            }
        		            str=str+b;
        		            c=c-z;
	                    }
	                    else
	                    {
	                        for(int j=0;j<Math.abs(z);j++)
        		            {
        		                str=str+"(";
        		            }
        		            str=str+b;
        		            c=c+Math.abs(z);
	                    }
	                }
		        }
		    }
		    System.out.println("Case #"+(l+1)+": "+str);
		}
	}
}
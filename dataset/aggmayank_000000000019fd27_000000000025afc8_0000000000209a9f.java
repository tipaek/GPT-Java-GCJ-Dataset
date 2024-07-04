import java.util.*;

class Solution{
	static String addopen(int n)
	{
		String a="";
		for(int i=0;i<n;i++)
			a+=Character.toString('(');
		return a;
	}
	static String addclose(int n)
	{
		String a="";
		for(int i=0;i<n;i++)
			a+=Character.toString(')');
		return a;
	}
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int c=1;c<=t;c++)
        {
        	
        	String str=in.nextLine();
        	int bcount=0;
        	char cc=str.charAt(0);
        	int c1=cc-'0';
        	String ans="";
        	if(c1!=0)
        	{
        		for(int i=0;i<c1;i++)
        		{
        			ans+=Character.toString('(');
        		}
        		ans+=Character.toString(cc);
        		bcount=c1;
        	}
        	else 
        		ans="0";

        	for(int i=1;i<str.length();i++)
        	{
        		if(bcount==(str.charAt(i)-'0'))
        		{
        			ans+=Character.toString(str.charAt(i));
        		}
        		else if(bcount>(str.charAt(i)-'0'))
        		{
        			int b=bcount-(str.charAt(i)-'0');
        			ans+=addclose(b);
        			bcount-=b;
        			ans+=Character.toString(str.charAt(i));
        		}
        		else if(bcount<(str.charAt(i)-'0'))
        		{
        			int b=(str.charAt(i)-'0')-bcount;
        			bcount+=b;
        			ans+=addopen(b);
        			ans+=Character.toString(str.charAt(i));
        		}
        	}
        	if(bcount!=0)
        		ans+=addclose(bcount);
        	System.out.println("Case #"+c+": "+ans);
        }

    }
}

import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
    	int tt=1;
    	Scanner sc=new Scanner(System.in);
    	int t=Integer.parseInt(sc.nextLine());
    	while(t-->0)
    	{
    		String s=sc.nextLine();
    		StringBuilder sb=new StringBuilder();
    		int in=s.length();
    		int br=0;
    		int min=0;
    		for(int k=0;k<s.length();k++)
    		{
    			int c=(int)s.charAt(k)-(int)'0';
    			if(s.charAt(k)!='0'){in=k;min=c;br=k;break;}
    			else{sb.append("0");}
    		}
    		int i=in;
    		while(i<s.length())
    		{
    			if(s.charAt(i)=='0')
    			{
    				for(int k=0;k<min;k++){sb.append("(");}
    					int u=br;
    				while(u<i)
    				{
    					int c=(int)(s.charAt(u))-(int)'0';
    					for(int kk=0;kk<c-min;kk++)
    					{
    						sb.append("(");
    					}
    					int x=u;
    					sb.append(s.charAt(x));
    					while(u<i){if(s.charAt(u)==s.charAt(u+1)){u+=1;sb.append(s.charAt(u));}else{break;}}
    					
    					// sb.append(s.charAt(k));
    					for(int kk=0;kk<c-min;kk++)
    					{
    						sb.append(")");
    					}
    					u+=1;
    				}
    				for(int k=0;k<min;k++){sb.append(")");}
    					sb.append(s.charAt(i++));
    				while(i<s.length())
    				{
    					int c=(int)s.charAt(i)-(int)'0';
    					if(s.charAt(i)=='0'){sb.append("0");i+=1;}
    					else{min=c;break;}
    				}
    				br=i;
    				i-=1;
    				
    			}

    		else if(i==s.length()-1)
    		{
    			int c=(int)(s.charAt(i))-(int)'0';
    			min=Math.min(c,min);
    			for(int k=0;k<min;k++){sb.append("(");}
    				int u=br;
    				while(u<=i)
    				{
    					 c=(int)(s.charAt(u))-(int)'0';
    					for(int kk=0;kk<c-min;kk++)
    					{
    						sb.append("(");
    					}
    					int x=u;
    					u+=1;
    					// System.out.println(x);
    					sb.append(s.charAt(x));
    					while(u<=i){
    						// System.out.println(u);
    						if(s.charAt(u)==s.charAt(u-1)){sb.append(s.charAt(u));}else{break;}u+=1;}
    					// System.out.println(sb.toString()+" "+min);
    					for(int kk=0;kk<c-min;kk++)
    					{
    						sb.append(")");
    					}
    					// u+=1;
    				}

    				for(int k=0;k<min;k++){sb.append(")");}
    					// sb.append(s.charAt(i));

    		}
    	else{int c=(int)(s.charAt(i))-(int)'0';
    			min=Math.min(c,min);
}
    	i+=1;
    		}
    		System.out.println("Case #"+tt+": "+sb.toString());
    		tt+=1;
    	}
    }
}
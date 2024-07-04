import java.util.*;
public class Solution
{
	public static void main(String[] args)
	{
	    Scanner in=new Scanner(System.in);
	    long t=in.nextInt();
	    int t1=1;
	    while(t-->0)
	    {
	        String S=in.next();
	        String res="";
	        int incre=0;
	        int decre=0;
	        for(int i=0;i<S.length();i++)
	        {
	            if(i==0)
                {
                 	int a=S.charAt(i)-48;
                 	incre=a;
                    int b=0;
                    while(b<incre)
                    {
                        res+="(";
                        b++;
                    }
                    res+=S.charAt(i);
                }
                if(i>0)
                {
                    int a=S.charAt(i)-48;
                    decre=a;
                    if(decre>incre)
                    {
                        int b=0;
                        while(b<decre-incre)
                    	{
                            res+="(";
                            b++;
                    	}
                        res+=S.charAt(i);
                    }
                    else
                    {
                    	int b=0;
                    	while(b<incre-decre)
                    	{
                    	    res+=")";
                            b++;
                    	}
                        res+=S.charAt(i);
                    }
                    incre=decre;
                }
	        }
	        
	        int l=S.charAt((S.length()-(1)))-48;
            int j=0;
            while(j<l)
            {
                res+=")";
                j++;
            }
            System.out.println("Case #"+t1+": "+res);
    		t1++;
	    }
	}
}
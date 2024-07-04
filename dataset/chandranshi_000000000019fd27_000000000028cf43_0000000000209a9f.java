import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[])throws IOException
    {
    InputStreamReader r=new InputStreamReader(System.in);    
    BufferedReader br=new BufferedReader(r);
    int t=Integer.parseInt(br.readLine());
    String s="";
    int p=0;
    char k;
    String ans="";
    for(int i=0; i<t; i++)
    {
    	ans="Case #"+Integer.toString(i+1)+": ";
    	s=br.readLine();
    	p=-1;
    	for(int j=0;j<s.length();j++)
    	{
    		k=s.charAt(j);
    		if((int)k ==0 )
    		{
    			if(p==1)
    				ans=ans+')';
    			ans=ans+k;
    			p=0;
    		}
    		else
    		{
    			if(p== (int)k)
    				ans=ans+k;
    			else
    			{
    				ans=ans+'(';
    				ans=ans+k;
    				p=1;
    			}
    		}

    	}
    	if (p==1)
        	ans=ans+')';

        System.out.println(ans);
    }
}
}




import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc=t;
        while(t!=0)
        {
        	String s = scn.next();
        	int currento=0;
        	int currentc=0;
        	String ans="";
        	for(int i =0;i<s.length();i=i+2)
        	{
        		int v1= Character.getNumericValue(s.charAt(i));
        		int require = v1-currento;
        		while(require!=0)
        		{
        			ans= ans+"(";
        			currento++;
        			currentc++;
        			require--;
        		}
        		ans= ans+v1;
        		if(i==s.length()-1)
        		{
        			break;
        		}
        		int v2= Character.getNumericValue(s.charAt(i+1));
        		if(v2>v1)
        		{
        			int require1 = v2-currento;
        			while(require1!=0)
            		{
            			ans= ans+"(";
            			currento++;
            			currentc++;
            			require1--;
            		}
        			ans= ans+v2;
        		}
        		else if(v2<v1)
        		{
        			int require2 = v1-v2;
        			while(require2!=0)
            		{
            			ans= ans+")";
            			currentc--;
            			currento--;
            			require2--;
            		}
        			ans= ans+v2;
        		}
        		else
        		{
        			ans= ans+v2;
        		}
        	}
        	
        	while(currentc!=0)
        	{
        		ans= ans+")";
        		currentc--;
        	}
        	System.out.println("Case #"+(tc-t+1)+": " +ans);
        	t--;
        }

	}

}
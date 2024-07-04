import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the morganAndString function below.
    static String morganAndString(String a, String b) {
        int x=0,y=0;String ret="";
        while(x<a.length()&&y<a.length())
        {
        	if(a.charAt(x)<=b.charAt(y))
        		{ret=ret+a.charAt(x++);}
        	else
        	{
        		ret+=b.charAt(y++);
        	}
        }
        if(x==a.length())
        {
        	ret+=b.substring(y);
        }
        else
        	ret+=a.substring(x);
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
       
        for (int tItr = 0; tItr < t; tItr++) {
        	String s=scanner.nextLine(),ret="";
        	int open=s.charAt(0);
        	for(int i=0;i<open-48;i++)
        	{
        		ret+='(';
        	}
        	ret+=(char)open;
        	for(int i=1;i<s.length();i++)
    		{
    		int new1=s.charAt(i);
    		if(open>new1)
    		{
    			for(int j=0;j<(open-new1);j++)
    			ret+=')';
    			ret+=(char)new1;
    			open=new1;
    			
    		}
    		else if(open==new1)
    		{ret+=(char)new1;}
    		else
    		{
    			if(open!=48)
    			{ret+=')';
    			open--;}
    			for(int j=0;j<(new1-open);j++)
    			ret+='(';
    			ret+=(char)new1;
    			open=new1;
    			
    		}
    		}
        	for(int j=0;j<(open-48);j++)
        		ret+=')';
        	System.out.println("Case #"+(tItr+1)+": "+ret);
        }

     

        scanner.close();
    }
}

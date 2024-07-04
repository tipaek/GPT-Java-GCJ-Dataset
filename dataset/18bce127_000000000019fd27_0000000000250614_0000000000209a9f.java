import java.util.Scanner;
import java.lang.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
	
		int l;
		for(l=0;l<t;l++)
		{
			String s1 = in.nextLine(); 			
			String output = "";
			int a;
			char[] s=s1.toCharArray();
			for(a=0;a<(s[0]-'0');a++)
				output+='(';
			for(int i=0;i<s.length-1;i++)
	        {
	            if(s[i+1]-'0'<s[i]-'0')
	            {
	                output+=s[i];
	                for(a=0;a<Math.abs(s[i+1]-s[i]);a++)
	                    output+=')';
	            }
	            else
	            {
	                output+=s[i];
	                for(a=0;a<Math.abs(s[i+1]-s[i]);a++)
	                    output+='(';
	            }
	        }
	        output+=s[s.length-1];
	        for(int i=0;i<s[s.length-1]-'0';i++)
	            output+=')';
	        System.out.println("Case "+(l+1)+"#: "+output);
		}
	}
	
}

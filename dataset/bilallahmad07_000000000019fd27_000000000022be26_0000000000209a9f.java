import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int T=1;T<=t;T++){
			String s = in.readLine();
			String out = "";
			int init = Integer.parseInt(s.charAt(0)+"");
			int prev = init;
			for(int i=1;i<=init;i++)
				out += '(';
			out += s.charAt(0);
			for(int i=1;i<s.length();i++){
				int curr = Integer.parseInt(s.charAt(i)+"");
				if ( curr > prev ){
					int diff = curr - prev;
					for(int j=1;j<=diff;j++)
						out += '(';
				}
				else if(curr < prev){
					int diff = prev - curr;
					for(int j=1;j<=diff;j++)
						out += ')';
				}
				
				out += s.charAt(i);
				prev = curr;
			}
			int end = Integer.parseInt(s.charAt(s.length() - 1)+"");
			for(int i=1;i<=end;i++)
				out += ')';
			
			System.out.println("Case #" + T + ": " + out);
		}
	}
}
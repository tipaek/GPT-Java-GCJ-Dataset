import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
		in.nextLine();
        for (int j = 1; j <= t; ++j) {
			String s = in.nextLine();
			Queue<String> queue = new LinkedList<>(); 
			if(s.length() == 1)
			{
				if(s == "0")
				{
					System.out.println("Case #" + j + ": " +s);
				}
				else
				{
					System.out.println("Case #" + j + ": "+"(" + s + ")");
				}
				continue;
			}
			for(int i=0;i<s.length()-1;i++)
			{
				if(s.charAt(i) == '0' && s.charAt(i+1) == '0')
				{
					queue.add("0");
					continue;
				}
				if(s.charAt(i) == '0' && s.charAt(i+1) == '1')
				{
					queue.add("0");
					queue.add("(");
					continue;
					
				}
				if(s.charAt(i) == '1' && s.charAt(i+1) == '1')
				{
					if(i==0)
					{
						queue.add("(");
					}
					queue.add("1");
					continue;
				}
				if(s.charAt(i) == '1' && s.charAt(i+1) == '0')
				{
					if(i==0)
					{
						queue.add("(");
					}
					queue.add("1");
					queue.add(")");
					continue;
				}
			}
			if(s.charAt(s.length()-1) == '0')
			{
				queue.add("0");
			}
			else
			{
				queue.add("1");
				queue.add(")");
			}
			String result = "";
			for(String temp : queue)
				result += temp;
			System.out.println("Case #" + j + ": " +result);
		}
	}
}
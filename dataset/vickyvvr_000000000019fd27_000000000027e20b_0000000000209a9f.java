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
			int depth = 0;
			Queue<String> queue = new LinkedList<>(); 
			for(int i = 0; i< s.length(); i++)
			{
				while(depth != Character.getNumericValue(s.charAt(i)))
				{
					if(depth < Character.getNumericValue(s.charAt(i)))
					{
						queue.add("(");
						depth += 1;
					}
					else
					{
						queue.add(")");
						depth -= 1;
					}
				}
				queue.add(String.valueOf(s.charAt(i)));
			}
			while(depth != 0)
			{
				queue.add(")");
				depth -= 1;
			}
			String result = "";
			for(String temp : queue)
				result += temp;
			System.out.println("Case #" + j + ": " +result);
		}
	}
}
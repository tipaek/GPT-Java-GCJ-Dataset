import java.util.*;
import java.io.*;

public class Solution
{

	public Vector Paranthesis(String str)
	{
		Vector<Character> vec = new Vector<Character>();
		int temp=Character.getNumericValue(str.charAt(0));
		for(int i=1; i<=temp; i++)
			vec.add('(');
		vec.add(str.charAt(0));
		int len = str.length();
		for(int i=1; i<len; i++)
		{
			if(Character.getNumericValue(str.charAt(i))>temp)
			{
				for(int j=1; j<=Character.getNumericValue(str.charAt(i))-temp; j++)
					vec.add('(');
			}
			else if(Character.getNumericValue(str.charAt(i))<temp)
			{
				for(int j=1; j<=temp-Character.getNumericValue(str.charAt(i)); j++)
					vec.add(')');
			}
			vec.add(str.charAt(i));
			temp=Character.getNumericValue(str.charAt(i));
		}
		for(int i=1; i<=temp; i++)
			vec.add(')');
		return vec;
	}

	public static void main(String[] args)
	{
		String str;
		String ans = "";
		Vector<Character> vec = new Vector<Character>();
		int size=0;
		Solution obj = new Solution();
		Scanner myObj = new Scanner(System.in);
		String temp = myObj.nextLine();
		int total_cases = Character.getNumericValue(temp.charAt(0));
		// System.out.println(total_cases);
		for(int i=1; i<=total_cases; i++)
		{
			str = myObj.nextLine();
			vec = obj.Paranthesis(str);
			for(int j=0; j<vec.size(); j++)
				ans = ans + vec.get(j);
			System.out.println("Case #" + i + ": " + ans);
			ans = "";
		}
	}
}
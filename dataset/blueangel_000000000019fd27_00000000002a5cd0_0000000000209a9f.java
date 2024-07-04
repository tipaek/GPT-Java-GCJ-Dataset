import java.util.*;
import java.io.*;
public class Solution {
	
	public static String paran(String str)
	{
		int num = Integer.parseInt(str);
		String ret = "";
		for (int i=0;i<num;i++)
		{
			ret = ret +"(";
		}
		ret = ret + str;
		for (int i=0;i<num;i++)
		{
			ret = ret +")";
		}
		return ret;
	}
	
	public static String insertIntoStr(String first, String processStr)
	{
		//System.out.println("Inserting "+first+" into "+processStr);
		String ans;
		int firstDig = Integer.parseInt(first);
		for (int i=0;i<processStr.length();i++)
		{	
			try {
				int digit = Integer.parseInt(String.valueOf(processStr.charAt(i)));
				if (firstDig == digit)
				{
					ans = processStr.substring(0, i+1)+first+processStr.substring(i+1);
					//System.out.println("Answerr is "+ans);
					return ans;
				}else {
					ans = paran(first)+processStr;
					//System.out.println("Answer is "+ans);
					return ans;
				}
				
			}catch (NumberFormatException e) {
				continue;
			}
		}
		return "";
	}
	
	
	public static String processString(String str)
	{
		if (str.length()==1)
		{
			return paran(str);
		}else {
			String firstChar = String.valueOf(str.charAt(0));
			return insertIntoStr(firstChar,processString(str.substring(1)));			
			
		}
	}

	public static String optimizeStr(String str)
	{
		String ans = str.replaceAll("\\)\\(","");
		return ans;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		//int testCases = Integer.parseInt(args[0]);
		//System.out.println("There are "+testCases+" test cases");
		int index=1;
		for (int i=0;i<testCases;i++)
		{
			// Read the test case
			String number = in.next();
			//String number=args[index++];
			//System.out.println("Next number is  "+number);
			String ans = processString(number);
			
			System.out.print("Case #"+(i+1)+": "+optimizeStr(ans));
			System.out.println();
		}	
		
	}

}

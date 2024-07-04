import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int testCasesNum = in.nextInt();
		
		for(int i = 1;i <= testCasesNum; i++) {
			int regexNum = in.nextInt();
			in.nextLine();
			List<String> regex = new ArrayList<>();
			for(int j = 1; j<= regexNum; j++)
			{
				regex.add(in.nextLine());
			}
			System.out.println("Case #"+i+": "+solve(regex));
		}
	}
	
	public static String solve(List<String> regex)
	{
		String start = "";
		String end = "";
		List<String> regexNext = new ArrayList<>();
		for(String temp : regex)
		{
			String tempStart = null ;
			String tempEnd = null;
			if(temp.contains("*"))
			{
				tempStart = temp.substring(0, temp.indexOf("*"));
				tempEnd = temp.substring(temp.lastIndexOf("*")+1);
			}
			else
				return temp;
			
			if(start.equals(""))
			{
				start = tempStart;
			}
			if(end.equals(""))
			{
				end = tempEnd;
			}
			if(start.contains(tempStart) || tempStart.contains(start))
			{
				start = start.length() >= tempStart.length() ? start : tempStart;
			}
			else
			{
				return "*";
			}
			if(end.contains(tempEnd) || tempEnd.contains(end))
			{
				end = end.length() >= tempEnd.length() ? end : tempEnd;
			}
			else
			{
				return "*";
			}
			String leftOver = "";
			if(tempStart.equals("") || tempEnd.equals(""))
			{
				if(tempStart.equals("") && tempEnd.equals(""))
				{
					leftOver = temp.substring(1, temp.length() -1);
				}
				else if(tempStart.equals(""))
				{
					leftOver = temp.substring(1, temp.indexOf(tempEnd));
				}
				else if(tempEnd.equals(""))
				{
					leftOver = temp.substring(temp.indexOf(tempStart)+1, temp.length() -1);
				}
			}
			else
				leftOver = temp.substring(temp.indexOf(tempStart)+1, temp.indexOf(tempEnd));
			//System.out.println(tempStart);
			//System.out.println(tempEnd);
			//System.out.println(leftOver);
			if(leftOver.length() > 0 && !leftOver.equals("*"))
				regexNext.add(leftOver);
		}
		
		if(regexNext.isEmpty())
			return start + end;
		else
			return start + solve(regexNext) + end;
	}
}

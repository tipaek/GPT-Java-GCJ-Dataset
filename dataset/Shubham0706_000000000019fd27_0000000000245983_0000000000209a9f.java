import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String as[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			String input=br.readLine();
			String soln=getSolution(input);
			System.out.println("Case #"+(i+1)+" "+soln);
		}
	}
	
	public static String getSolution(String num)
	{
		//System.out.println(num);
		String output="";
		Stack<Integer> stacknumber=new Stack<Integer>();
		for(int i=0;i<num.length();i++)
		{
			stacknumber.add(Integer.parseInt(Character.toString(num.charAt(i))));
			//System.out.print(Integer.parseInt(Character.toString(num.charAt(i))));
		}
		Stack<Integer> braces=new Stack<Integer>();
		while(!stacknumber.isEmpty())
		{
			int number=stacknumber.pop();
			int balance=number-braces.size();
			if(balance<0)
			{
				for(int k=0;k<Math.abs(balance);k++)
				{
					output=output+")";
					braces.pop();
				}
			}
			else
			{
				for(int k=0;k<Math.abs(balance);k++)
				{
					output=output+"(";
					braces.add(1);
				}
			}
			output=output+number;
		}
		for(int k=0;k<braces.size();k++)
		{
			output=output+")";
		}
		return output;
	}

}
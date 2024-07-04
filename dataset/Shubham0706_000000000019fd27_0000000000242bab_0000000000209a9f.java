import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String as[])
	{
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int i=0;i<T;i++)
		{
			int input=scan.nextInt();
			System.out.println(getSolution(input));
		}
	}
	
	public static String getSolution(int num)
	{
		String output="";
		Stack<Integer> stacknumber=new Stack<Integer>();
		while(num>0)
		{
			stacknumber.add(num%10);
			num=num/10;
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
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int k=1;k<=n;k++)
		{
			String str = sc.next();
			Stack<String> stack = new Stack<>();
			int max = 0;
			for(int i=0;i<str.length();i++)
			{
			    int x = Integer.parseInt(Character.toString(str.charAt(i)));
			    if(stack.isEmpty())
			    {
			    	for(int j=0;j<x;j++)
			    	{
			    		stack.push("(");
			    	}
			    	stack.push(Integer.toString(x));
			    	max += x;
			    }
			    else if(Integer.parseInt(stack.peek())<x)
			    {
			    	int diff = Math.abs(Integer.parseInt(stack.peek())-x);
			    	for(int j=0;j<diff;j++)
			    	{
			    		stack.push("(");
			    	}
			    	stack.push(Integer.toString(x));
			    	max += diff;
			    }
			    else if(Integer.parseInt(stack.peek())==x)
			    {
			    	stack.push(Integer.toString(x));
			    }
			    else
			    {
			    	int diff = Math.abs(Integer.parseInt(stack.peek())-x);
			    	for(int j=0;j<diff;j++)
			    	{
			    		stack.push(")");
			    	}
			    	stack.push(Integer.toString(x));
			    	max -= diff;
			    }
			}
			for(int i=0;i<max;i++)
			{
				stack.push(")");
			}
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty())
			{
				sb.append(stack.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
		sc.close();
	}

}

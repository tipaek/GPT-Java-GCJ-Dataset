import java.util.*;


public class Solution 
{
	
	
public static void main(String arrr[]) {	
	
	Scanner in=new Scanner(System.in);
	
	int t=in.nextInt();
	
	for(int ii=1;ii<=t;ii++)
	{
		String str=in.next();
		StringBuilder output=new StringBuilder();
		
		Stack<String> stack=new Stack<>();
		Stack<Integer> count=new Stack<>();
		count.push(0);
		
		for(int i=0;i<str.length();i++)
		{
			int a=Integer.parseInt(String.valueOf(str.charAt(i)));
			if(a>count.peek())
			{
				int b=a-count.pop();
				count.push(b);
				for(int j=0;j<b;j++)
					{
					output.append("(");
					stack.push("(");
					}
				
				output.append(str.charAt(i));
			}
			else if(a<count.peek())
			{
				int b=count.pop()-a;
				count.push(a);
				for(int j=0;j<b;j++)
					{
					output.append(")");
					stack.pop();
					}
				output.append(str.charAt(i));
			}
			else
			{
				output.append(str.charAt(i));
			}
		}
		
		while(!stack.isEmpty())
		{
			output.append(")");
			stack.pop();
		}
		
		System.out.println("Case #"+ii+":"+" "+output);
	}
	
	in.close();
}
}

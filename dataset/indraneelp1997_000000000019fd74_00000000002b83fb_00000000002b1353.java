import java.util.*;
public class Solution
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int t1=1;t1<=t;t1++)
		{
			int n = sc.nextInt();
			int pow = (int)(Math.log(n)/Math.log(2));
			int sum = 1<<pow;
			sum -= 1;
			int rem = n - sum;
			System.out.println("Case #"+t1+": ");
			for(int i=1;i<=pow;i++)
			{
				Stack<Integer> stack = new Stack<Integer>();
				for(int j=1;j<=i;j++)
				{
					if(i % 2 == 0)
						stack.push(j);
					else
						System.out.println(i+" "+j);
				}
				while(!stack.isEmpty())
					System.out.println(i+" "+stack.pop());
			}
			if(pow %2 == 0)
			{
				for(int i=pow+1;i<=pow+rem;i++)
					System.out.println(i+" "+1);
			}
			else
			{
				for(int i=pow+1;i<=pow+rem;i++)
					System.out.println(i+" "+i);
			}
		}
	}
}
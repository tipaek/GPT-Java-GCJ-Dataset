import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {


	static void add(String s)
	{
		Stack<Character> stk = new Stack<Character>();
		int digit=0, j=0;

		for(int i=s.length()-1; i>=0; i--)
		{
			digit = (int)s.charAt(i) - (int)'0';

			if(digit!=0)
			{
				for(j=0; j<digit;j++)
				{
					stk.push(')');
				}


				stk.push(s.charAt(i));

				if(i>0)
				{
					j=i;
					int d= (int)s.charAt(j-1) - (int)'0'; ;
					
					while(j>0 && digit==d)
					{
						stk.push(s.charAt(j));
						--j;
						--i;
						d= (int)s.charAt(j) - (int)'0';
					}
					
				}
				for(j=0; j<digit;j++)
				{
					stk.push('(');
				}
			}
			else{
				stk.push('0');
			}
		}

		while(!stk.empty())
		{
			System.out.print(stk.pop());
		}

	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		int t=0,i=0;

		t=Integer.parseInt(in.readLine().trim());
		String s[]=new String[t];

		for( i=0; i<t ; i++)
		{
			s[i]=in.readLine().trim();

		}

		for(i=0;i<t;i++)
		{

			System.out.print("Case #"+(i+1)+": ");
			add(s[i]);
			System.out.println();
		}
	}


}

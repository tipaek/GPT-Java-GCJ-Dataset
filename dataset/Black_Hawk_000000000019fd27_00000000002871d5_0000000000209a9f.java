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
					j=i-1;
					int d=(char)s.charAt(j) - (char)'0';
					while(d==digit && j>0)
					{
						stk.push(s.charAt(j));
						d=(char)s.charAt(--j) - (char)'0';
					}
					if(j==0 && d==digit)
					{
						stk.push(s.charAt(j));
						i=-1;
					}
					else
						i=j+1;
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



	static void Add(String s)
	{
		int digit=0,j=0;
		int len=s.length();
		for(int i=0;i<len;i++)
		{
			digit = (int)s.charAt(i) - (int)'0';

			
			for(j=0; j<digit;j++)
			{
				System.out.print("(");
			}

			System.out.print(digit);

			if(i<len-1)
			{
				j=i+1;
				int d=(char)s.charAt(j) - (char)'0';
				while(d==digit && j<len-1)
				{
					System.out.print(digit);
					d=(char)s.charAt(++j) - (char)'0';
					
				}
				if(j==len-1 && d==digit)
				{
					System.out.print(digit);
					i=len;
				}
				else
					i=j-1;
			}


			for(j=0; j<digit;j++)
			{
				System.out.print(")");
			}
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
		Add(s[i]);
		System.out.println();
	}
}


}

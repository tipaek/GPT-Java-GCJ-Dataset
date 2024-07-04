import java.util.Scanner;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String s[] = new String[T];
		for(int k=0;k<T;k++)
		{
			s[k] = sc.next();
		}
		for(int k=0;k<T;k++)
		{
			System.out.print("Case #"+(k+1)+": ");
			int a = (int)s[k].charAt(0)-48;
			display('(',a);
			for(int i=1;i<s[k].length();i++)
			{
				System.out.print(a);
				int b = (int)s[k].charAt(i)-48;
				if(a<b)
				{
					int diff = b-a;
					display('(',diff);
				}
				else
				{
					int diff = a-b;
					display(')',diff); 
				}
				a = b;
			}
			System.out.print(a);
			display(')',a);
			System.out.println(); 
		}
	}
	public static void display(char bracket,int range)
	{
		for(int i=0;i<range;i++)
		{
			System.out.print(bracket);
		}
	}
}
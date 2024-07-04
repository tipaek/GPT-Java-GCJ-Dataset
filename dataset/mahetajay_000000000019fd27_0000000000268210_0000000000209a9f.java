import java.util.Scanner;
public class Solution 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		sc.nextLine();
		for (int a=0;a<test;a++)
		{
			String s;
			s=sc.nextLine();
			int n=s.length();
			char[] str=s.toCharArray();
			int count=0;
			String t="";
			for(int i=0;i<n;i++)
			{
				int temp=str[i]-'0';
				if(temp==count)
					t=t+str[i];
				else if(temp>count)
				{
					int diff = temp-count;
					for(int x=diff;x>0;x--)
					{
						t=t+'(';
					}
					t=t+str[i];
					count=temp;
				}
				else
				{
					int diff = count-temp;
					for(int y=diff;y>0;y--)
					{
						t=t+')';
					}
					t=t+str[i];
					count=temp;
				}
			}	
			for(int z=count;z>0;z--)
			{
				t=t+')';
			}
			System.out.println("Case #"+(a+1)+": "+t);
			
		}
		
	}
}
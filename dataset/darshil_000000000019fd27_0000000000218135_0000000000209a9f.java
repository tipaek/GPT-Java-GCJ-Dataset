import java.util.*;

public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++)
		{
			String s = sc.nextLine();
			String op = "";
			int o = 0;
			int c = 0;
			for(int x=0;x<s.length();x++)
			{
				if(Character.getNumericValue(s.charAt(x))==0)
				{
				    int temp = o-c;
					for(int comp=0;comp<o-c;comp++)
					{
						op = op + ')';
						
					}
					op+=0;
					c+=temp;
				}

				else
				{
					int cnt=0;
					cnt=(Character.getNumericValue(s.charAt(x))-(o-c));
					if(cnt>=0)
					{
						for(int comp=0;comp<cnt;comp++)
						{
							op+='(';
							o++;
						}
						op+=Character.getNumericValue(s.charAt(x));
					}
					else
					{
						for(int comp=cnt;comp<0;comp++)
						{
							op+=')';
							c++;
						}
						op+=Character.getNumericValue(s.charAt(x));
					}
				}
				System.out.println(o+" "+c);
				
			}
			int temp=o-c;
			for(int comp=0;comp<o-c;comp++)
				{
				    op+=')';
				    
				}

			System.out.println("Case #"+(i+1)+": "+op);
		}
	}
}
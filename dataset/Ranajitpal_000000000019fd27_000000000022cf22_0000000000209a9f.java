import java.util.Scanner;

public class Solution{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			String s = sc.next();
			String s1 = "";
			
			int a[] = new int[s.length()];
			for(int i=0;i<s.length();i++)
			{
				a[i] = Integer.valueOf(s.charAt(i)+"");
			}
			
			int head =0;
			for(int i=0;i<a.length;i++)
			{
				if(head<a[i])
				{
					for(int j=0;j<a[i]-head;j++)
					{
						s1+="(";
					}
					s1+=a[i];
				}
				else
				{
					if(head>a[i])
					{
						for(int j=0;j<head-a[i];j++)
						{
							s1+=")";
						}
						s1+=a[i];
					}
					else
					{
						s1+=a[i];
					}
				}
				head = a[i];
			}
			for(int i=0;i<head;i++)
			{
				s1+=")";
			}
			System.out.println("Case #"+t+": "+s1);
		}
	}

}

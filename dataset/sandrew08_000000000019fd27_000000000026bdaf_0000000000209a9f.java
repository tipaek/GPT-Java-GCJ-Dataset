import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t > 0)
		{
			int i=0,j=0;
			String b="";
			int flag =0;
			String s=sc.nextLine();
			Integer a[]=new Integer[s.length()];
			for(i=0;i<s.length();i++)
			{
				a[i]=(s.charAt(i)-'0');
			}
			for(i=0;i<a[0];i++)
			{
				b=b+'(';
				flag++;
			}
			b=b+a[0].toString();
			for(i=1;i<s.length();i++)
			{
				int dif=a[i]-flag;
				if(dif==0)
				{
					b=b+a[i].toString();
				}
				else if(dif>0)
				{
					for(j=0;j<dif;j++)
					{
						b=b+'(';
						flag++;
					}
					b=b+a[i].toString();
				}
				else
				{
					for(j=0;j<(-1)*dif;j++)
					{
						b=b+')';
						flag--;
					}
					b=b+a[i].toString();
				}
			}
			while(flag>0)
			{
				b=b+')';
				flag--;
			}
			t--;
			System.out.println(b);
		}
	}

}
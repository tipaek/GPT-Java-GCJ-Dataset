import java.util.Scanner;
public class Solution {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			String s=sc.next();
			String s1="";
			int q=(int)s.charAt(0)-48;
			for(int k=0;k<q;k++)
			{
				s1=s1+'(';
			}
			s1=s1+s.charAt(0);
			for(int j=1;j<s.length();j++)
			{
				int num=(int)s.charAt(j-1)-(int)s.charAt(j);
				if(num==0)
				{
					s1=s1+s.charAt(j);
				}
				else if(num<0)
				{
					for(int o=0;o<-num;o++)
					{
						s1=s1+'(';
					}
					s1+=s.charAt(j);
					
				}
				else if(num>0)
				{
					for(int o=0;o<num;o++)
					{
						s1=s1+')';
					}
					s1+=s.charAt(j);
				}
			}
			for(int w=0;w<(int)s.charAt(s.length()-1)-48;w++)
					{
				s1+=')';
					}

			System.out.println("case #"+(1+i)+": "+s1);
			
		}
	}
}
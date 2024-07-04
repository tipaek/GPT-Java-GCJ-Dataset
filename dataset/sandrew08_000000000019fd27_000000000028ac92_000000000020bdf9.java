import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		int y=t;
		sc.nextLine();
		while(t > 0)
		{
			int n=0,i=0,j=0;
			n=sc.nextInt();
			int s[][]=new int[n][4];
			for(i=0;i<n;i++)
			{
				s[i][0]=i;
				s[i][1]=sc.nextInt();
				s[i][2]=sc.nextInt();
			}
			int temp=0;
			for(i=0;i<n-1;i++)
			{
				for(j=i+1;j<n;j++)
				{
					if(s[i][1]>s[j][1])
					{
						temp=s[i][1];
						s[i][1]=s[j][1];
						s[j][1]=temp;
						temp=s[i][0];
						s[i][0]=s[j][0];
						s[j][0]=temp;
						temp=s[i][2];
						s[i][2]=s[j][2];
						s[j][2]=temp;
					}
				}
			}
			String s1="";
			int min[]=new int[1441];
			int ca[]=new int[1441];
			int ja[]=new int[1441];
			int flag1=0,flag2=0,flag3=0;
			for(i=0;i<n;i++)
			{
				flag1=0;flag2=0;flag3=0;
				for(j=s[i][1]+1;j<=s[i][2];j++)
				{
					if(min[j]==0)
						flag1++;
					if(min[j]==1)
						flag2++;
					if(min[j]==2)
						flag3++;
				}
				if(flag3!=0)
				{
					s1="IMPOSSIBLE";
					break;
				}
				if(flag2!=0)
				{
					for(j=s[i][1]+1;j<=s[i][2];j++)
					{
						min[j]++;
					}
					int fl1=0,fl2=0;
					for(j=s[i][1]+1;j<=s[i][2];j++)
					{
						if(ca[j]==1)
							fl1++;
						if(ja[j]==1)
							fl2++;
					}
					if(fl1==0)
					{
						for(j=s[i][1]+1;j<=s[i][2];j++)
						{
							ca[j]++;
						}
						s[i][3]=0;
					}
					if(fl2==0)
					{
						for(j=s[i][1]+1;j<=s[i][2];j++)
						{
							ja[j]++;
						}
						s[i][3]=1;
					}
				}
				if(flag1!=0&&flag2==0)
				{
					for(j=s[i][1]+1;j<=s[i][2];j++)
					{
						min[j]++;
						ca[j]++;
					}
					s[i][3]=0;
				}
				
			}
			for(i=0;i<n-1;i++)
			{
				for(j=i+1;j<n;j++)
				{
					if(s[i][0]>s[j][0])
					{
						temp=s[i][1];
						s[i][1]=s[j][1];
						s[j][1]=temp;
						temp=s[i][0];
						s[i][0]=s[j][0];
						s[j][0]=temp;
						temp=s[i][2];
						s[i][2]=s[j][2];
						s[j][2]=temp;
						temp=s[i][3];
						s[i][3]=s[j][3];
						s[j][3]=temp;
					}
				}
			}
			for(i=0;i<n;i++)
			{
				if(s[i][3]==0)
					s1=s1+'c';
				if(s[i][3]==1)
					s1=s1+'j';
			}
			System.out.println("Case #"+(y-t+1)+": "+s1);
			t--;
		}
	}
}
import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,r,c,i,j,k,l;
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		long ans=0L;
		int level=0;	
		boolean flag=true;
		int eli=0;		
		r=scan.nextInt();
		c=scan.nextInt();
		int[][] dan=new int[r][c];
		int[][] in=new int[r][c];
		int[][] stack=new int[2][100];
		int top=-1;
		for(j=0;j<r;++j)
			for(k=0;k<c;++k)
				{
				dan[j][k]=scan.nextInt();
				in[j][k]=1;
				}		
		for(j=0;j<r;++j)
			{
			for(k=0;k<c;++k)
				{
				int temp=0;
				double avg=0.0;
				for(l=k+1;l<c;++l)
					if(in[j][l]==1)
						{
						avg+=dan[j][l];
						++temp;
						break;
						}
				for(l=k-1;l>=0;--l)
					if(in[j][l]==1)
						{
						avg+=dan[j][l];
						++temp;
						break;
						}
				for(l=j+1;l<r;++l)
					if(in[l][k]==1)
						{
						avg+=dan[l][k];
						++temp;
						break;
						}
				for(l=j-1;l>=0;--l)
					if(in[l][k]==1)
						{
						avg+=dan[l][k];		
						++temp;
						break;
						}
				avg=avg/temp;
				if(avg>dan[j][k])
					{
					++eli;
					stack[0][++top]=j;	
					stack[1][top]=k;
					}
				}
			}
		level=0;
		for(j=0;j<r;++j)
			for(k=0;k<c;++k)
				if(in[j][k]==1)
					level+=dan[j][k];
		ans+=level;
		while(top>=0)
			in[stack[0][top]][stack[1][top--]]=0;
		while(eli>0)	
			{
			eli=0;
			for(j=0;j<r;++j)
				{
				for(k=0;k<c;++k)
					{
					if(in[j][k]==1)
					{
					int temp=0;
					double avg=0.0;
					for(l=k+1;l<c;++l)
						if(in[j][l]==1)
							{
							avg+=dan[j][l];
							++temp;
							break;
							}
					for(l=k-1;l>=0;--l)
						if(in[j][l]==1)
							{
							avg+=dan[j][l];
							++temp;
							break;
							}
					for(l=j+1;l<r;++l)
						if(in[l][k]==1)
							{
							avg+=dan[l][k];
							++temp;
							break;
							}
					for(l=j-1;l>=0;--l)
						if(in[l][k]==1)
							{
							avg+=dan[l][k];		
							++temp;
							break;
							}
					avg=avg/temp;
					if(avg>dan[j][k])
						{
						++eli;
						stack[0][++top]=j;	
						stack[1][top]=k;
						}
					}
					}
				}
			level=0;
			for(j=0;j<r;++j)
				for(k=0;k<c;++k)
					if(in[j][k]==1)
						level+=dan[j][k];
			ans+=level;
			while(top>=0)
				in[stack[0][top]][stack[1][top--]]=0;
			}
		System.out.println("Case #"+i+": "+ans);
		}	
	}
}
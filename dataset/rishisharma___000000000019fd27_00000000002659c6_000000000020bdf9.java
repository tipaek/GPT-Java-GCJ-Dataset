import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			
			pair[] arr=new pair[n];
			
			for(int j=0;j<n;j++)
			{
				int l=s.nextInt();
				int r=s.nextInt();
				int index=j;
				
				pair p=new pair(l,r,index);
				arr[j]=p;
			}
			
			Arrays.sort(arr,new comp());
			
			int end=-1;
			
			char[] ans=new char[n];
			
			for(int j=0;j<n;j++)
			{
				if(arr[j].l>=end)
				{
					ans[arr[j].index]='C';
					end=arr[j].r;
				}
			}
			
			end=-1;
			
			for(int j=0;j<n;j++)
			{
				if(ans[arr[j].index]!='C')
				{
					if(arr[j].l>=end)
					{
						ans[arr[j].index]='J';
						end=arr[j].r;
					}
				}
			}
			
			int p=0;
			
			for(int j=0;j<n;j++)
			{
				if((ans[j]!='C')&&(ans[j]!='J'))
				{
					p=1;
					break;
				}
			}
			
			if(p==1)
			{
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}
			else
			{
				System.out.print("Case #"+(i+1)+": ");
				
				for(int j=0;j<n;j++)
				{
					System.out.print(ans[j]);
				}
				
				System.out.println();
			}
			
		}
		
	}
	
}

class pair
{
	int l;
	int r;
	int index;
	
	public pair(int l,int r,int index)
	{
		this.l=l;
		this.r=r;
		this.index=index;
	}
}

class comp implements Comparator<pair>
{
	public int compare(pair a,pair b)
	{
		if(a.l<b.l)
			return -1;
		else if(a.l==b.l)
		{
			if(a.r<b.r)
				return -1;
			else
				return 1;
		}
		else
		{
			return 1;
		}
	}
}
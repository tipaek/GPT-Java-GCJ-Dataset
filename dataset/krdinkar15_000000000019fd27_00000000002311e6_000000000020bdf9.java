import java.util.*;
import java.io.*;
import java.util.Scanner;
class Interval
{
	int start,end,rank;
	public void setData(int s,int e,int r)
	{
		start=s;
		end=e;
		rank=r;
	}
}
public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		int tc=0;
		while(t>0)
		{
			t--;
			tc++;
			ArrayList<Integer> first = new ArrayList<Integer>();
			ArrayList<Integer> second = new ArrayList<Integer>();
			int[] check=new int[1200];
			int n;
			n=sc.nextInt();
			int r=1;
			Interval[] arr=new Interval[n];
			for(int i=0;i<n;i++)
				arr[i]=new Interval();
			for(int i=0;i<n;i++)
			{
				int s,e;
				s=sc.nextInt();
				e=sc.nextInt();
				arr[i].setData(s,e,r);
				r=r+1;
			}
			int i,j;
			for(i=0;i<n-1;i++)
			{
				for(j=0;j<n-i-1;j++)
				{
					if(arr[j].end>arr[j+1].end)
					{
						int temp = arr[j].end; 
                   		arr[j].end = arr[j+1].end; 
                    	arr[j+1].end= temp; 

                    	temp = arr[j].start; 
                   		arr[j].start = arr[j+1].start; 
                    	arr[j+1].start= temp; 
                    	temp = arr[j].rank; 
                   		arr[j].rank = arr[j+1].rank; 
                    	arr[j+1].rank= temp; 

					}
				}
			}
			// for(int i=0;i<n;i++)
			// {
			// 	System.out.println(arr[i].start+" "+arr[i].end+" "+arr[i].rank);
			// }
			i=0;
			first.add(arr[0].rank);
			 for (j = 1; j < n; j++) 
			{ 
	
				if (arr[j].start >= arr[i].end) 
				{ 
					first.add(arr[j].rank);
					i = j; 
				} 
			}
			for(i=0;i<n;i++)
			{
				if(first.contains(arr[i].rank))
				{
					arr[i].start=99999999;
					arr[i].end=99999999;
				}
			}

			for(i=0;i<n-1;i++)
			{
				for(j=0;j<n-i-1;j++)
				{
					if(arr[j].end>arr[j+1].end)
					{
						int temp = arr[j].end; 
                   		arr[j].end = arr[j+1].end; 
                    	arr[j+1].end= temp; 

                    	temp = arr[j].start; 
                   		arr[j].start = arr[j+1].start; 
                    	arr[j+1].start= temp; 
                    	temp = arr[j].rank; 
                   		arr[j].rank = arr[j+1].rank; 
                    	arr[j+1].rank= temp; 

					}
				}
			}
			// for(i=0;i<n;i++)
			// {
			// 	System.out.println(arr[i].start+" "+arr[i].end+" "+arr[i].rank);
			// }
		    i = 0; 
			if(arr[0].end!=99999999)
			   second.add(arr[0].rank);
			for (j = 1; j < n; j++) 
			{ 
		
				if (arr[j].start >= arr[i].end&&arr[i].end!=99999999&&arr[j].start!=99999999) 
				{ 
					second.add(arr[j].rank);
					i = j;
				}
			}

			int x1=first.size()+second.size();
			if(x1!=n)
			{
				System.out.println("Case #"+tc+": "+"IMPOSSIBLE");
			}
			else
			{
				String ans="";
				for(i=0;i<first.size();i++)
				  {
				  	int x=first.get(i);
				  	check[x]=1;
				  	
				  }
			    for(i=0;i<second.size();i++)
				  {
				  	int y=second.get(i);
				  	check[y]=2;
				  	
				  }
				  for(i=1;i<=n;i++)
				  {
				  	if(check[i]==1)
				  		ans+='C';
				  	else
				  		ans+='J';
				  }
				  System.out.println("Case #"+tc+": "+ans);
			}

			
		}
	}
}

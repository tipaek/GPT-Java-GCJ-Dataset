import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String[] args) throws IOException{
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		int t=Integer.parseInt(inp.readLine());
		int k=1;
		while(true)
		{
			int n=Integer.parseInt(inp.readLine());
			int[] s=new int[n];
			int[] e=new int[n];
			int[] x=new int[n];
			for(int i=0;i<n;i++)
			{
				String[] integersInString = inp.readLine().split(" ");
				s[i]=Integer.parseInt(integersInString[0]);
				x[i]=Integer.parseInt(integersInString[0]);
				e[i]=Integer.parseInt(integersInString[1]);
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n-i-1;j++)
				{
					if(s[j]>s[j+1])
					{
						int temp=s[j];s[j]=s[j+1];s[j+1]=temp;
						temp=e[j];e[j]=e[j+1];e[j+1]=temp;
					}
				}
			}
			int visited[]=new int[n];
			Arrays.fill(visited,0);
			String res="CJ";
			visited[0]=1;visited[1]=1;
			int l=0;int m=1;
			for(int i=2;i<n;i++)
			{
				if(visited[i]==0)
				{
					if(e[l]<=s[i])
					{
						visited[i]=1;res+='C';
						l=i;
					}
					else if(e[m]<=s[i])
					{
						visited[i]=1;
						res+='J';m=i;
					}
					if(visited[i]!=1)
					{
						res="IMPOSSIBLE";
						break;
					}
				}
			}
			String res1="";
			if(!res.equals("IMPOSSIBLE")||!res.equals("CJ")){
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(s[i]==x[j])
						res1+=res.charAt(j);
				}
			}
		}
		if(res.equals("IMPOSSIBLE")||res.equals("CJ"))
				res1=res;
			System.out.println("Case #"+k+" "+res1);
			k++;
			t--;
			if(t==0)
				break;
		}
	}
}
import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String[] args) throws IOException{
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		//int T= Integer.parseInt(inp.readLine());
		int t=Integer.parseInt(inp.readLine());
		int i,j,k=1;
		while(true)
		{
			int n=Integer.parseInt(inp.readLine());
		//	System.out.println(n);
			int[][] m=new int[n][n];
			for(i=0;i<n;i++){
				String[] integersInString = inp.readLine().split(" ");
				for(j=0;j<n;j++)
				{
					m[i][j]=Integer.parseInt(integersInString[j]);
				}
			}
			int trace=0;
			for(i=0;i<n;i++)
				trace+=m[i][i];
			List<Integer> x=new ArrayList<>();
			int rowc=0,colc=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(x.contains(m[i][j]))
						{
							rowc++;
							break;
						}
						x.add(m[i][j]);
				}
				x.clear();
			}
			for(j=0;j<n;j++)
			{
				for(i=0;i<n;i++)
				{
					if(x.contains(m[i][j]))
						{
							colc++;
							break;
						}
						x.add(m[i][j]);
				}
				x.clear();
			}
			System.out.println("Case #"+k+":"+" "+trace+" "+rowc+" "+colc);
			k++;
			t--;
			if(t==0)
				break;
		}
	}
}
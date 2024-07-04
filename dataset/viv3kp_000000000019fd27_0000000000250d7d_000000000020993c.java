
import java.io.*;
import java.util.*;
class Solution {
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int test=Integer.parseInt(br.readLine());
		
		StringBuilder str=new StringBuilder("");
		int caseNo=1;
		while(test-->0)
		{
			int n=Integer.parseInt(br.readLine());
			
			int arr[][]=new int[n][n];
			int row=0;
			int trace=0;
			int col=0;
			
			for(int i=0;i<n;i++)
			{
				
				Set<Integer> ro=new HashSet();
				
				String s=br.readLine().trim();
				StringTokenizer st=new StringTokenizer(s," ");
				
				for(int j=0;j<n;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
					ro.add(arr[i][j]);
					
					if(i==j)
						trace+=arr[i][j];
				}
				if(ro.size()!=n)
					row++;
					
			}
			
			
			for(int i=0;i<n;i++)
			{
				Set<Integer> co=new HashSet();
				for(int j=0;j<n;j++)
				{
					co.add(arr[j][i]);
				}
				if(co.size()!=n)
					col++;
			}
			
			
			str.append("Case #"+caseNo+": "+trace+" "+row+" "+col+"\n" );
			
			caseNo++;
			
			
			
		}
		
		System.out.println(str.toString());
		
	}

}

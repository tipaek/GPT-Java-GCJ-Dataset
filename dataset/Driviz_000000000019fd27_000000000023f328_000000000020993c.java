import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int test=0;test<T;test++)
		{
			int N=Integer.parseInt(br.readLine());
			int arr[][]=new int[N][N];
			int k=0,r=0,c=0;
			for(int i=0;i<N;i++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					arr[i][j]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++)
			{
				HashSet<Integer> row=new HashSet<>();
				HashSet<Integer> col=new HashSet<>();
				for(int j=0;j<N;j++)
				{
					row.add(arr[i][j]);
					col.add(arr[j][i]);
					if(i==j)
						k+=arr[i][j];
				}
				if(row.size()!=N)
					r++;
				if(col.size()!=N)
					c++;
			}
			
			System.out.println("Case #"+(test+1)+": "+k+" "+r+" "+c);
		}
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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
				HashMap<Integer, Integer> hm=new HashMap<>();
				boolean containDups=false;
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(i==j)
						k+=arr[i][j];
					if(hm.containsKey(arr[i][j])){
						hm.put(arr[i][j], hm.get(arr[i][j])+1);
						containDups=true;
					}
					else
						hm.put(arr[i][j], 1);
				}
				if(containDups)
					r++;
			}
			
			for(int i=0;i<N;i++)
			{
				HashMap<Integer, Integer> hm=new HashMap<>();
				boolean containDups=false;
				for(int j=0;j<N;j++)
				{
					if(hm.containsKey(arr[j][i]))
					{
						hm.put(arr[j][i], hm.get(arr[j][i])+1);
						containDups=true;
					}
					else
						hm.put(arr[j][i], 1);
				}
				if(containDups)
					c++;
			}
			
			System.out.println("Case #"+test+": "+ k+" "+r+" "+c);
		}
	}

}

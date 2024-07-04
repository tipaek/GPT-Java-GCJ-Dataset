import java.util.*;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry;
class Solution
{
	public static void main(String[] args)throws Exception
	{
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		for(int cas3=1;cas3<=3;cas3++)
		{
			int N=ob.nextInt();
			int[][] arr=new int[N][N];
			int sum=0;
			for(int i=0;i<N;i++)
			{
				StringTokenizer st=new StringTokenizer(ob.next()+ob.nextLine());
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(i==j)
						sum+=arr[i][j];//trace
				}
			}
			process(arr,N,sum,cas3);
		}
	}
	public static void process(int[][] arr,int N,int trace,int t)
	{
		HashMap<Integer,Character> mapr=new HashMap<>();
		HashMap<Integer,Character> mapc=new HashMap<>();
		int i,j,k,r=0,c=0;
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				if(mapr.containsKey(arr[i][j]))
					mapr.put(arr[i][j],'b');
				else
					mapr.put(arr[i][j],'a');
				
				if(mapc.containsKey(arr[j][i]))
					mapc.put(arr[j][i],'b');
				else
					mapc.put(arr[j][i],'a');
			}
			
			for(k=0;k<N;k++)
			if(mapr.get(arr[i][k])=='b')
			{
				r++;
				break;
			}
			for(k=0;k<N;k++)
			if(mapc.get(arr[k][i])=='b')
			{
				c++;
				break;
			}
			
			
			mapr.clear();
			mapc.clear();
		}
		System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
	}
}
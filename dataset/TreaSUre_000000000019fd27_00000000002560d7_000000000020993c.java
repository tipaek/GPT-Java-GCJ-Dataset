import java.util.*;
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
		HashMap<Integer,Integer> mapr=new HashMap<>();
		HashMap<Integer,Integer> mapc=new HashMap<>();
		int maxr=0,maxc=0;
		int i,j,ch;
		for(i=0;i<N;i++)
		{
			for(j=0;j<N;j++)
			{
				if(mapr.containsKey(arr[i][j]))
					mapr.put(arr[i][j],mapr.get(arr[i][j])+1);
				else
					mapr.put(arr[i][j],1);
				if(maxr<mapr.get(arr[i][j]))
					maxr=mapr.get(arr[i][j]);
				
				if(mapc.containsKey(arr[j][i]))
					mapc.put(arr[j][i],mapc.get(arr[j][i])+1);
				else
					mapc.put(arr[j][i],1);
				if(mapc.get(arr[j][i])>maxc)
					maxc=mapc.get(arr[j][i]);
			}
			mapr.clear();
			mapc.clear();
		}
		if(maxr==1)
			maxr=0;
		if(maxc==1)
			maxc=0;
		System.out.println("Case #"+t+": "+trace+" "+maxr+" "+maxc);
	}
}
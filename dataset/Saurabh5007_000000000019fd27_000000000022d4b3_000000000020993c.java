
import java.util.Scanner;

public class Solution {

	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++)
		{
			int traces = 0;
			int r_cnt=0;
			int c_cnt=0;
			N=sc.nextInt();
			arr = new int[N][N];
			int[] col_Mat=new int[N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					arr[i][j]=sc.nextInt();
					if(i==j)
					{
						traces = traces+arr[i][j];
					}
				}
			}
			
			for(int i=0;i<N;i++)
			{
				if(isRepeatPresent(arr[i]))
				{
					r_cnt++;
				}
			}
			
			for(int i=0;i<N;i++)
			{
				int index=0;
				for(int j=0;j<N;j++)
				{
					col_Mat[index]=arr[j][i];
					index++;
				}
				
				if(isRepeatPresent(col_Mat))
				{
					c_cnt++;
				}
				
			}
			System.out.println("Case #"+tc+":"+" "+traces+" "+r_cnt+" "+c_cnt);
		}

	}
	
	public static boolean isRepeatPresent(int[] input)
	{
		int size = input.length;
		boolean[] track = new boolean[size];
		
		for(int i=0;i<size;i++)
		{
			if(!track[input[i]-1])
			{
				track[input[i]-1]=true;
			}
			else
			{
				return true;
			}
		}
		return false;
		
	}

}

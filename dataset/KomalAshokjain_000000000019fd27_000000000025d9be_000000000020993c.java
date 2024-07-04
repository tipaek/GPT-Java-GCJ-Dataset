import java.io.*;
import java.util.*;

class Solution{
	public static String calculate(int N,int[][] t1){
		int sum=0;
		for(int i=0,j=0;i<N;i++)
		{
			sum += t1[i][j];
			j++;
		}
		int[] rowvisit;;
		int[] columnvisit;
		int rowcount=0;
		int columncount=0;
		for(int i=0;i<N;i++)
		{
			rowvisit = new int[N];
			for(int j=0;j<N;j++)
			{
				if(rowvisit[t1[i][j]-1]==0){
					rowvisit[t1[i][j]-1]=1;
				}
				else{
					rowcount++;
					break;
				}
			}
			columnvisit = new int[N];
			for(int j=0;j<N;j++)
			{
				if(columnvisit[t1[j][i]-1]==0){
					columnvisit[t1[j][i]-1]=1;
				}
				else{
					columncount++;
					break;
				}
			}
		}
		return sum+" "+rowcount+" "+columncount;
		
	}
	public static void main(String args[])throws Exception{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int count=1;
		while(T!=0)
		{
			int N = scan.nextInt();
			int[][] t1 = new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					t1[i][j] = scan.nextInt();
				}
			}
			System.out.println("Case #"+count+": "+Solution.calculate(N,t1));
			T--;
			count++;
		}
	}
}
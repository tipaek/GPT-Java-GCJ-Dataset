
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int T;
		int N;
		
		Scanner sc = new Scanner (System.in);
		T = sc.nextInt();
		int K =T;
		
		while(T-- >0)
		{			N = sc.nextInt();

			int arr[][] = new int[N][N];
			int trace=0;
			int countr=0;
			int countc=0;
			for(int i=0;i<N;i++)
			{	
				for(int j=0;j<N;j++)
				{
					arr[i][j]=sc.nextInt();
					if(i==j) trace+=arr[i][j];

				}
			}
			
			for(int i=0;i<N;i++)
			{
				HashSet<Integer> set = new HashSet<Integer>();
				int flag=0;
				for(int j=0;j<N;j++)
				{
					if(set.contains(arr[i][j]))
					{
						flag=1;  break;
					}
					else set.add(arr[i][j]);
				}
				if(flag==1) countr++;
			}
			
			
			for(int i=0;i<N;i++)
			{
				HashSet<Integer> set = new HashSet<Integer>();
				int flag=0;
				for(int j=0;j<N;j++)
				{
					if(set.contains(arr[j][i]))
					{
						flag=1;  break;
					}
					else set.add(arr[j][i]);
				}
				if(flag==1) countc++;
			}
			
			System.out.println("Case #"+K-T+":"+" "+ trace+" "+ countr +" "+ countc);
		
		}
	}

}
 
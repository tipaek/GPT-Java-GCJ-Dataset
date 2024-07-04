import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		for(int m=1;m<=t;m++)
		{
			int N= sc.nextInt();
			int arr[][]= new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					arr[i][j]= sc.nextInt();
				}
			}
			HashSet<Integer> set1= new HashSet();
			HashSet<Integer> set2= new HashSet();
			int trace=0, k=0,r=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					set1.add(arr[i][j]);
				set2.add(arr[j][i]);
				if(i==j)
					{
						trace= trace+arr[i][j];
					}
					
				}
				int n2=set2.size();
				int n1=set1.size();
				if(n1<N)
				{k++;}
				if(n2<N)
				{r++;}
				set2.clear();
				set1.clear();
			}
			System.out.println("Case #"+m+": "+trace+" "+k+" "+r);
			
	}
	
	}
}

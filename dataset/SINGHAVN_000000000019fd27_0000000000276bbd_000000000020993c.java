import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Matrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T= s.nextInt();
        int N=s.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++)
        {
        	for(int j=0;j<N;j++)
        	{
        		arr[i][i]=s.nextInt();
        	}
        }
        
        for (int i=0;i<T;i++)
        {
        	int t=trace(arr,N);
        	int r=row(arr,N);
        	int c=column(arr,N);
        	System.out.println(t+""+r+""+c);
        }
        

	}

	private static int row(int[][] arr,int N) {
		int count=0;
		for (int i=0;i<N;i++)
		{
			Set<Integer>set=new HashSet<>();
			for (int j=0;j<N;j++)
			{
				set.add(arr[i][j]);
			}
			if (set.size()==N)
			{
				count++;
			}
		}
		return count;
	}

	private static int column(int[][] arr,int N) {
		int count=0;
		for (int i=0;i<N;i++)
		{
			Set<Integer>set=new HashSet<>();
			for (int j=0;j<N;j++)
			{
				set.add(arr[j][i]);
			}
			if (set.size()==N)
			{
				count++;
			}
		}
		return count;
	}

	private static int trace(int[][] arr,int N) {
		int sum=0;
		for (int i=0;i<N;i++)
		{
			sum+=arr[i][i];
		}
		
		return sum;
	}

}
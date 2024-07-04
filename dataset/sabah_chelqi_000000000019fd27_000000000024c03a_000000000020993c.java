import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int i = 1; i <= T; i++)
		{
			int N = in.nextInt();
			int [][] square = new int[N][N];
			int rows =0;
			int columms =0;
			int trace = 0;
			
			for(int j =0; j <N; j++)
			{
				for(int k =0; k< N; k++)
				{
					square[j][k] = in.nextInt();
					if( j == k)
						trace += square[j][k];
				}
			}
	
			for(int j =0; j <N; j++)
			{			
				int [] temp  =  Arrays.copyOf(square[j], N);
				Arrays.sort(temp);
				for(int k =0; k< N-1; k++)
				{
					if( temp[k] == temp[k+1])
					{
						rows++;
						break;
					}
				}
		
		
			}
			
			for(int j =0; j <N; j++)
			{
				int [] temp  =  new int[N];

				for(int k =0; k< N; k++)
				{
					temp[k]= square[k][j];
				}
				
				Arrays.sort(temp);
				for(int k =0; k< N-1; k++)
				{
					if( temp[k] == temp[k+1])
					{
						columms++;
						break;
					}
				}
		
			}
			
			System.out.printf("Case #%d: %d %d %d\n",i, trace, rows, columms);
			
			
		}
		
		in.close();
	}

}

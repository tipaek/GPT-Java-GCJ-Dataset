import java.util.HashSet;
import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args)
    {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int t=0;t<T;t++) {
			
			int N = scan.nextInt();
			int[][] arr = new int[N][N];
			int trace = 0;
			int repeatedValueRow=0;
			int repeatedValueColumn=0;
			
			HashSet<Integer> set = new HashSet<>();
			
			for(int i=0;i<N;i++) {
				
				for(int j=0;j<N;j++) {
					
					arr[i][j]=scan.nextInt();
					set.add(arr[i][j]);
					if(i==j)
						trace = trace + arr[i][j];
				}
				
				if(set.size()!=N)
					repeatedValueRow++;
				
				set.clear();
			}
			
			for(int i=0;i<N;i++) {
				
				for(int j=0;j<N;j++) {
					
					set.add(arr[j][i]);
				}
				
				if(set.size()!=N)
					repeatedValueColumn++;
				set.clear();
			}
			
			System.out.println("Case #" + (t+1) + ": " + trace + " " + repeatedValueRow + " " + repeatedValueColumn);
		}
    }
}

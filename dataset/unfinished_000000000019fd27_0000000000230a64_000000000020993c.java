import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		for (int i = 1; i <= T; i++) {
			//System.out.println();
			int N = input.nextInt();
			//System.out.println("N-->"+N);
			int[][] arr = new int[N][N];
			for (int j = 0; j < N*N; j++) {
				arr[j/N][j%N]=input.nextInt();
			}
			/*for(int a=0;a<arr.length;a++) {
				System.out.println();
				for(int b=0;b<arr.length;b++) {
					System.out.print(arr[a][b]);
				}
			}*/
			int c=getRepeatedElementsCol(arr);
			int r=getRepeatedElementsRow(arr);
			long k=0;
			
			k= getSumDiagonal(arr);
			//Case #1: 4 0 0
			System.out.println("Case #"+i+": "+k+" "+r+" "+c);
			
		}

	}
	
	private static long getSumDiagonal(int[][] arr) {
		long sum = 0;
		int size = arr.length;
		for(int i=0;i<size;i++) {
			sum+=arr[i][i];
		}
		return sum;
	}
	
	private static int getRepeatedElementsRow(int[][] arr) {
		int r =0;
		int size = arr.length;
		for(int k=0;k<size;k++) {
			Set<Integer> sum = new HashSet<Integer>();
			for(int i=0;i<size;i++) {
				sum.add(arr[k][i]);
			}
			if(size!=sum.size()) {
				r++;
			}
		}
		return r;
	}
	
	private static int getRepeatedElementsCol(int[][] arr) {
		int c =0;
		int size = arr.length;
		for(int k=0;k<size;k++) {
			Set<Integer> sum = new HashSet<Integer>();
			for(int i=0;i<size;i++) {
				sum.add(arr[i][k]);
			}
			if(size!=sum.size()) {
				c++;
			}
		}
		return c;
	}

}

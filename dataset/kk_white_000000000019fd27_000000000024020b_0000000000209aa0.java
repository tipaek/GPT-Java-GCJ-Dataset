import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] X = new int[N][N];
			for(int j = 0; j < N; j++){
				for(int k = 0; k < N; k++){
					X[j][k] = ((j + k) % N) + 1;
				}
			}
			int[] order = new int[N];
			boolean flag = false;
			for(int j = 0; j < N; j++){
				order[j] = j;
			}
			do{
				int sum = 0;
				for(int j = 0; j < N; j++){
					sum += X[order[j]][j];
				}
				if(sum == K){
					flag = true;
					break;
				}
			}while(nextPermutation(order));
			
			System.out.print("Case #"+(i + 1)+": ");
			if(!flag)System.out.println("IMPOSSIBLE");
			else{
				System.out.println("POSSIBLE");
				for(int j = 0; j < N; j++){
					for(int k = 0; k < N; k++){
						System.out.print(X[order[j]][k]+((k != N-1)?" ":""));
					}
					System.out.println();
				}
			}
		}
	}
	private static boolean nextPermutation(int[] array) {
		for (int i = array.length - 1 ; i > 0 ; i --) {
			if (array[i - 1] < array[i]) {
				int j = find(array, array[i - 1], i, array.length - 1);
				int temp = array[j];
				array[j] = array[i - 1];
				array[i - 1] = temp;
				Arrays.sort(array, i, array.length);
				return true;
			}
		}
		return false;
	}

	private static int find(int[] array, int dest, int f, int l) {
		if (f == l) {
			return f;
		}
		int m = (f + l + 1) / 2;
		return (array[m] <= dest) ? find(array, dest, f, m - 1) : find(array, dest, m, l);
	}
}
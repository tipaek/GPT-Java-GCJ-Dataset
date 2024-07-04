import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			int N=scanner.nextInt();
			int[][]arr=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=scanner.nextInt();
				}
			}
			System.out.println("Case #"+(t+1)+": "+trace(arr)+" "+rows(arr)+" "+cols(arr));
		}
		
	}
	public static int trace(int[][]arr) {
		int result=0;
		for(int i=0;i<arr.length;i++)result+=arr[i][i];
		return result;
	}
	public static int rows(int [][]arr) {
		int result=0;
		for(int i=0;i<arr.length;i++) {
			int []check=new int[arr.length];
			for(int j=0;j<arr.length;j++) {
				if(check[arr[i][j]-1]==0) {
					check[arr[i][j]-1]=1;
				}
				else {
					result++;
					break;
				}
			}
		}
		return result;
	}
	public static int cols(int [][]arr) {
		int result=0;
		for(int i=0;i<arr.length;i++) {
			int []check=new int[arr.length];
			for(int j=0;j<arr.length;j++) {
				if(check[arr[j][i]-1]==0) {
					check[arr[j][i]-1]=1;
				}
				else {
					result++;
					break;
				}
			}
		}
		return result;
	}
	
}

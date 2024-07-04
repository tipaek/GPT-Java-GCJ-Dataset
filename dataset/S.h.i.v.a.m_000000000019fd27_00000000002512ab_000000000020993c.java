import java.util.*;

class vest{
	static int r = 0;
	static int c = 0;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int x = 1;
		while(x<=t){
			r = 0;
			c = 0;
			int n = scan.nextInt();
			int[][] arr = new int[n][n];
			int k = 0;
			for(int i = 0;i<n;i++){
				for(int j = 0;j<n;j++){
					arr[i][j] = scan.nextInt();
					if(i == j){
						k += arr[i][j];
					}
				}
			}
			for(int i = 0;i<n;i++){
				r += rsort(arr,i);
				c += csort(arr,i);
			}
			System.out.println("CASE #"+x+": "+k+" "+r+" "+c);
			x++;
		}
	}
	public static int rsort(int[][] arr,int i){
		int count = 0;
		int[] freq = new int[arr.length];
		Arrays.fill(freq,0);
		for(int k = 0;k<arr.length;k++){
			freq[arr[i][k]-1]++;
		}
		for(int k = 0;k<freq.length;k++){
			if(freq[arr[i][k]-1]-->1){
				count++;
				return count;
			}
		}
		return count;
	}
	public static int csort(int[][] arr,int i){
		int count = 0;
		int[] freq = new int[arr.length];
		Arrays.fill(freq,0);
		for(int k = 0;k<arr.length;k++){
			freq[arr[k][i]-1]++;
		}
		for(int k = 0;k<freq.length;k++){
			if(freq[arr[k][i]-1]-->1){
				count++;
				return count;
			}
		}
		return count;
	}
}
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		new Solution().solution();
//		System.out.println(answer);
		
		
	}

	public void solution() {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int trace = 0, maxRowCnt = 0, maxColCnt = 0;
			
			int[][] arr = new int[n][n];
			
			for (int j = 0; j < n; j++) {
				int[] rowNum = new int[n];
				for (int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
					if(j == k) trace += arr[j][k];
					rowNum[arr[j][k]-1]++;
				}
				for(int c : rowNum) {
					if(c > 1) {
						maxRowCnt++;
						break;
					}
				}
			}
			
			for (int j = 0; j < arr.length; j++) {
				int[] colNum = new int[n];
				for (int k = 0; k < arr.length; k++) {
					colNum[arr[k][j]-1]++;
				}
				for(int c : colNum) {
					if(c > 1) {
						maxColCnt++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+i+": "+trace + " " + maxRowCnt + " " + maxColCnt);
		}
		
		sc.close();
	}
}

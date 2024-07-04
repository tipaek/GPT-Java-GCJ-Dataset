import java.util.*;
public class Solution {

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int l = 0 ; l < t ; l++) {
			int n = s.nextInt();
			int arr[][] = new int[n][n];
			int trace = 0;
			int rows = 0;
			int cols = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = s.nextInt();
					if(i == j) {
						trace += arr[i][j];
					}
				}
			}
			for(int r = 0 ; r < n ; r++) {
				int i = r;
				for(int j = 0 ; j < n ; j++) {
					int temp = arr[i][j];
					int flag = 0;
					for(int x = j + 1 ; x < n ; x++) {
						if(arr[i][x] == temp) {
							rows += 1;
							flag = 1;
							break;
						}
					}
					if(flag == 1) {
						break;
					}
				}
			}
			for(int r = 0 ; r < n ; r++) {
				int i = r;
				for(int j = 0 ; j < n ; j++) {
					int temp = arr[j][i];
					int flag = 0;
					for(int x = j + 1 ; x < n ; x++) {
						if(arr[x][i] == temp) {
							cols += 1;
							flag = 1;
							break;
						}
					}
					if(flag == 1) {
						break;
					}
				}
			}
			System.out.println("Case #" + (l + 1) + ":" + " " + trace + " " + rows + " " + cols);
		}
	}
}
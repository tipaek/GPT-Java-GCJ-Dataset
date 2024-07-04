import java.util.*;

public class Solution {
	static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; ++i) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}
	static void solve() {
		int r = sc.nextInt(), c = sc.nextInt();
		long ans = 0;
		// 1 - up, 2 - right, 3 - down, 4 - left
		int [][][] arr = new int[r][c][5];
		for(int i = 0; i < r; ++i) {
			for(int j = 0; j< c; ++j) {
				arr[i][j][0] = sc.nextInt();
				if(i-1 > -1) arr[i][j][1] = arr[i-1][j][0];
				if(i+1 < r) arr[i][j][3] = arr[i+1][j][0];
				if(j-1 > -1) arr[i][j][4] = arr[i][j-1][0];
				if(j+1 < c) arr[i][j][2] = arr[i][j+1][0];
			}
		}
		for(int i = 0; i < r; ++i) {
			for(int j = 0; j< c; ++j) {
				if(i-1 > -1) arr[i][j][1] = arr[i-1][j][0];
				if(i+1 < r) arr[i][j][3] = arr[i+1][j][0];
				if(j-1 > -1) arr[i][j][4] = arr[i][j-1][0];
				if(j+1 < c) arr[i][j][2] = arr[i][j+1][0];
			}
		}
		boolean fl = true;
		while(fl) {
			fl = false;
			for(int i = 0; i < r ; i++) {
				for(int j = 0; j< c; ++j) {
					if(arr[i][j][0] == 0)continue;
					int sm = 0, ni = 0;
					for(int k = 1; k < 5; ++k) {
						sm += arr[i][j][k];
						if(arr[i][j][k] != 0)ni++;
					}
					ans += arr[i][j][0];
					if(sm > arr[i][j][0]*ni) {
						arr[i][j][0] = 0;
						fl = true;
					}
				}
			}
			for(int i = 0; i < r ; i++) {
				for(int j = 0; j< c; ++j) {
					if(arr[i][j][0]==0)continue;
					int k = 1, l = 1;
					while(i+k<r && arr[i+k][j][0] == 0) k++;
					while(j+l<r && arr[i][j+l][0] == 0) l++;
					arr[i][j][3] = (i+k<r?arr[i+k][j][0]:0);
					arr[i][j][2] = (j+l<c?arr[i][j+l][0]:0);
					k = 1; l = 1;
					while(i-k>-1 && arr[i-k][j][0] == 0) k++;
					while(j-l>-1 && arr[i][j-l][0] == 0) l++;
					arr[i][j][1] = (i-k>-1?arr[i-k][j][0]:0);
					arr[i][j][4] = (j-l>-1?arr[i][j-l][0]:0);
				}
			}
		}
		System.out.println(ans);
	}

}

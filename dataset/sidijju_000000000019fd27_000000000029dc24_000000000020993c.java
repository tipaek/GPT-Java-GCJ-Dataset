import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int i = 0; i < T; i ++) {
			solve(i);
		}
	}

	private static void solve(int k) {
		int N = sc.nextInt();
		int t = 0;
		int r = 0;
		int c = 0;
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j ++) {
				arr[i][j] = sc.nextInt();
				if(j == i) t += arr[i][j];
			}
			if(checkDuplicate(arr[i])) r ++;
		}
		
		for(int j = 0; j < N; j ++) {
			int[] col = new int[N];
			for(int i = 0; i < N; i ++) {
				col[i] = arr[i][j];
			}
			if(checkDuplicate(col)) c ++;
		}
		System.out.println("Case #" + (k + 1) + ": " + t + " " + r + " " + c);
	}
	
	public static boolean checkDuplicate(int[] input){
		Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < input.length; i ++) {
        		if(set.add(input[i]) == false) {
        			return true;
        		}
        }
        return false;
    }

}

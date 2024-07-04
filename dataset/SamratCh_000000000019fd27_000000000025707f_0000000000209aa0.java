import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			boolean possible = false;
			String[] strArr = sc.nextLine().split(" ");
			int n = Integer.parseInt(strArr[0]), k = Integer.parseInt(strArr[1]);
			int[][] board = new int[n][n];
			boolean[][] rows = new boolean[n][n], cols = new boolean[n][n];
			ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
			findPossibleTrace(finalList, new ArrayList<Integer>(), n, k, 0, 1);
			//finalList.forEach(System.out::println);
			for(int i = 0 ; i < finalList.size() && !possible; i++) {
				board = new int[n][n];
				for(int j = 0 ; j < n ; j++) {
					int val = finalList.get(i).get(j);
					board[j][j] = val;
					rows[j][val - 1] = true;
					cols[j][val -1] = true;
				}
				possible = recurr(board, 0, 0, rows, cols, possible, n);
			}			
			String ans = possible ? "POSSIBLE" : "IMPOSSIBLE";
			System.out.println(String.format("Case #%d: %s",t, ans));
		}
	}
	
	
	private static void findPossibleTrace(ArrayList<ArrayList<Integer>> finalList, ArrayList<Integer> list, int n , int k, int currTrace, int index) {
		if(index == n+1) {
			if(currTrace == k) {
				finalList.add(new ArrayList<Integer>(list));
			}
			return;
		}
		if(currTrace > k)
			return;
		for(int i = 1; i <= n ; i++) {
			list.add(i);
			findPossibleTrace(finalList, list, n, k, currTrace + i, index+1);
			list.remove(list.size() - 1);
		}
	}
	
	private static boolean recurr(int[][] currBoard, int r, int c, boolean[][] rows, boolean[][] cols, boolean possible, int n) {
		if(r == n) {
			possible = true;
			return possible;
		}
		if(currBoard[r][c] != 0) {
			if(c == n-1)
				possible = recurr(currBoard, r+1, 0, rows, cols, possible, n);
			else
				possible = recurr(currBoard, r, c+1, rows, cols, possible, n);
		}
		for(int i = 1 ; i <= n && !possible; i++) {
			if(!rows[r][i-1] && !cols[c][i-1]) {
				rows[r][i-1] = true;
				cols[c][i-1] = true;
				currBoard[r][c] = i;
				if(c == n-1)
					possible = recurr(currBoard, r+1, 0, rows, cols, possible, n);
				else
					possible = recurr(currBoard, r, c+1, rows, cols, possible, n);
				rows[r][i-1] = false;
				cols[c][i-1] = false;
				currBoard[r][c] = 0;
			}
		}
		return possible;
	}

}

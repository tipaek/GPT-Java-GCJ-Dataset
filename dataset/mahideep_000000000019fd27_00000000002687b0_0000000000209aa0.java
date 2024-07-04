
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static List<int[]> allCombnations=new ArrayList<>();
	static boolean found=false;

	public static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int d = 0; d < board.length; d++) {

			if (board[row][d] == num) {
				return false;
			}
		}
		for (int r = 0; r < board.length; r++) {

			if (board[r][col] == num) {
				return false;
			}
		}

		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean solveSudoku(int[][] board, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					row = i;
					col = j;

					isEmpty = false;
					break;
				}
			}
			if (!isEmpty) {
				break;
			}
		}

		if (isEmpty) {
			return true;
		}

		for (int num = 1; num <= n; num++) {
			if (isSafe(board, row, col, num)) {
				board[row][col] = num;
				if (solveSudoku(board, n)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static void print(int[][] board, int N, int t, int caseNumber) {
		int trace=0;
		for (int r = 0; r < N; r++) {
			
				
				trace+=board[r][r];	
			
			
		}
		
		if(t==trace) {
			found=true;
			System.out.println("Case #"+caseNumber+": POSSIBLE");
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[i].length;j++) {
					
					System.out.print(board[i][j]); 
					System.out.print(" ");
				}
				System.out.println("");
			}
			
		}
		/*else {
			
			System.out.println("Case #"+caseNumber+": IMPOSSIBLE");

		}*/
	}

	public static void main(String args[]) {

		
		Scanner sc = new Scanner(System.in);
		int testCaseCount = Integer.parseInt(sc.nextLine());

if(testCaseCount<0)
return;
		for (int t = 0; t < testCaseCount; t++) {
			found=false;
			String[] input = sc.nextLine().split("\\s+");
			int N = Integer.parseInt(input[0]);
			int T = Integer.parseInt(input[1]);

if(T<N || T>N*N){
    			System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
break;
}

			int[][] matrix = new int[N][N];

			String s = new String();
			for (int i = 1; i <= N; i++)
				s += i;

			getAllCombinationsOfArray(s, "");

			for (int[] row : allCombnations) {
				matrix = new int[N][N];
				//System.out.println("For "+Arrays.toString(row));
				if(found)
					break;
				matrix[0] = row;

				solveSudoku(matrix, N);
				print(matrix,N,T,t+1);
				//System.out.println("------------");
			}
			if(!found)
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");


		}
	
		sc.close();
	}

	static void getAllCombinationsOfArray(String str, String ans) {

		if (str.length() == 0) {
			int[] newGuess = new int[ans.length()];
			for (int i = 0; i < ans.length(); i++) {
				newGuess[i] = ans.charAt(i) - '0';
			}

			allCombnations.add(newGuess);
			//System.out.println(Arrays.toString(newGuess));
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			String ros = str.substring(0, i) + str.substring(i + 1);

			getAllCombinationsOfArray(ros, ans + ch);
		}
	}
}

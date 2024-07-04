import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i<=t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] mat = sol.solve(n, k);
		    if(mat==null) {
		        System.out.println("Case #"+ i +": IMPOSSIBLE");
		    } else {
		        System.out.println("Case #"+ i +": POSSIBLE");
		        sol.print(mat, n);
		    }
        }
    }
    
    int[][] solve(int n, int k) {
		List<List<Integer>> lists = combinationSum(n, k);
		if (lists.size() == 0)
			return null;
		for (List<Integer> list : lists) {
			int[][] mat = new int[n][n];
			for (int i = 0; i < n; i++) {
				mat[i][i] = list.get(i);
			}
			if (createMatrix(mat, n)) {
				return mat;
			}
		}
		return null;
	}

	public static boolean createMatrix(int[][] mat, int n) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
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

		// no empty cell
		if (isEmpty) {
			return true;
		}

		// else for each-row backtrack
		for (int num = 1; num <= n; num++) {
			if (isSafe(mat, row, col, num)) {
				mat[row][col] = num;
				if (createMatrix(mat, n)) {
					return true;
				} else {
					mat[row][col] = 0; // replace it
				}
			}
		}
		return false;
	}

	public static boolean isSafe(int[][] board, int row, int col, int num) {
		for (int d = 0; d < board.length; d++) {
// if the number is already present in  
// that row, return false; 
			if (board[row][d] == num) {
				return false;
			}
		}

		for (int r = 0; r < board.length; r++) {
// if the number is already present in 
// that column, return false; 

			if (board[r][col] == num) {
				return false;
			}
		}

		return true;
	}
	
	public static void print(int[][] mat, int N) 
	{ 
	    for (int r = 0; r < N; r++) 
	    { 
	        for (int d = 0; d < N; d++) 
	        { 
	            System.out.print(mat[r][d]); 
	            System.out.print(" "); 
	        } 
	        System.out.print("\n"); 
	          
	        if ((r + 1) % (int) Math.sqrt(N) == 0)  
	        { 
	            System.out.print(""); 
	        } 
	    } 
	} 

	public List<List<Integer>> combinationSum(int n, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		helper(n, 1, target, 0, temp, result);
		return result;
	}

	private void helper(int n, int start, int target, int sum, List<Integer> list, List<List<Integer>> result) {
		if (sum > target || list.size() > n) {
			return;
		}

		if (sum == target && list.size() == n) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);
			helper(n, i, target, sum + i, list, result);
			list.remove(list.size() - 1);
		}
	}
}

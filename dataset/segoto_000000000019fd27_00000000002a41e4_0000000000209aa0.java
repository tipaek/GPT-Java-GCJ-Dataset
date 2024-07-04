import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int t = Integer.parseInt(br.readLine());
			for(int i = 1; i <= t; ++i) {
				int n,k;
				String s[] = br.readLine().split(" ");
				n = Integer.parseInt(s[0]);
				k = Integer.parseInt(s[1]);
				ArrayList<int[]> totalSums = new ArrayList<>();
				int inicial[] = new int[n];
				for(int j = 0 ; j < n; ++j) {
					inicial[j] = 1;
				}
				int m = 1;
				int dif  = k-n;
				while(dif>0) {
					if(inicial[n-m]<n) {
						inicial[n-m]++;
						dif--;
					}
					else {
						m++;
					}
				}
				int untilN[] = new int[n];
				fillWith0s(untilN);
				if(valid(untilN, inicial)) {
					int matrix[][]= new int[n][n];
					for(int j = 0; j < n; ++j) {
						for(int l = 0 ; l < n; ++l) {
							if(j==l) {
								matrix[j][j] = inicial[j];
							}
							else {
								matrix[j][l] = 0;
							}
						}

					}

					solveSudoku(matrix, n); 
					System.out.println("Case #"+ i+": POSSIBLE");
					print(matrix, n);
				}
				else {
					if(inicial[n-m]<n && m!=1) {
						m--;
					}
					boolean itsValid = false;
					while(!itsValid) {

						if(n-m-1>=0) {
							if(inicial[n-m]-1>=inicial[n-m-1]+1) {
								inicial[n-m]-=1;
								inicial[n-m-1]+=1;
								fillWith0s(untilN);
								itsValid =valid(untilN, inicial);

							}
							else {
								++m;
							}
						}
						else {
							break;
						}
					}
					if(!itsValid) {
						System.out.println("Case #"+ i+": IMPOSSIBLE");
					}
					else {
						int matrix[][]= new int[n][n];
						for(int j = 0; j < n; ++j) {
							for(int l = 0 ; l < n; ++l) {
								if(j==l) {
									matrix[j][j] = inicial[j];
								}
								else {
									matrix[j][l] = 0;
								}
							}

						}

						solveSudoku(matrix, n); 
						System.out.println("Case #"+ i+": POSSIBLE");
						print(matrix, n);

					}
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean isSafe(int[][] board,  
			int row, int col,  
			int num)  
	{ 

		for (int d = 0; d < board.length; d++)  
		{ 

			if (board[row][d] == num)  
			{ 
				return false; 
			} 
		} 


		for (int r = 0; r < board.length; r++) 
		{ 

			if (board[r][col] == num) 
			{ 
				return false; 
			} 
		} 


		return true; 
	} 

	public static void solveSudoku(int[][] board, int n)  
	{ 
		for(int i =0 ; i <n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(board[i][j]== 0) {
					for(int k = 1; k <= n  ; ++k) {
						if(isSafe(board, i, j, k)) {
							board[i][j] = k;
							break;
						}
						else {
							while(k==n) {
								board[i][j] = 0;
								if(j==0 && i>0) {
									--i;
									j = n-1;
								}
								else if(j>0 && i >= 0) {
									--j;
									if(i==j && i!=0) {
										--j;
									}
								}
								k = board[i][j];
							}
						}
					}
				}
			}
		}
	}
	public static void print(int[][] board, int N) 
	{ 

		for (int r = 0; r < N; r++) 
		{ 
			for (int d = 0; d < N; d++) 
			{ 
				System.out.print(board[r][d]); 
				System.out.print(" "); 
			} 
			System.out.print("\n"); 
		} 
	} 
	static void fillWith0s(int[] a) {
		for(int i = 0 ; i < a.length; ++i) {
			a[i] = 0;
		}
	}
	static boolean valid(int[] a, int[] b) {
		for(int i = 0 ; i < a.length; ++i) {
			a[b[i]-1]++;
		}
		for(int i = 0 ; i < a.length; ++i) {
			if(a[i]==a.length-1) {
				return false;
			}
		}
		return true;
	}
}

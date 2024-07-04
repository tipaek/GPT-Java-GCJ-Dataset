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
				totalSums.add(inicial.clone());
				if(inicial[n-m]<n && m!=1) {
					m--;
				}
				while(true) {

					if(n-m-1>=0) {
						if(inicial[n-m]-1>=inicial[n-m-1]+1) {
							inicial[n-m]-=1;
							inicial[n-m-1]+=1;
							boolean add = true;
							for(int j = 0 ; j < n; ++j) {
								if(inicial[j]>n) {
									add = false;
								}
							}
							if(add) {
								totalSums.add(inicial.clone());
							}

						}
						else {
							++m;
						}
					}
					else {
						break;
					}
				}
//				for(int j = 0 ; j < totalSums.size(); j++) {
//					String st ="";
//					for(int l = 0 ; l < n; l++) {
//						st+=totalSums.get(j)[l]+" ";
//					}
//					System.out.println(st);
//				}
				int posTot = -1;
				for(int j = 0; j < totalSums.size(); ++j) {
					boolean nM1 = false;
					int count[] = new int[n];
					for(int l = 0 ; l < n; l++) {
						count[l] = 0;
					}
					for(int l = 0 ; l < n; l++) {
						count[totalSums.get(j)[l]-1]++;
					}
					for(int l = 0; l <n; ++l) {
						if(count[l]==n-1) {
							nM1 = true;
						}
					}
					if(!nM1) {
						posTot = j;
						break;
					}
				}
				if(posTot == -1) {
					System.out.println("Case #"+ i+": IMPOSSIBLE");
				}
				else {
					int matrix[][]= new int[n][n];
					for(int j = 0; j < n; ++j) {
						for(int l = 0 ; l < n; ++l) {
							if(j==l) {
								matrix[j][j] = totalSums.get(posTot)[j];
							}
							else {
								matrix[j][l] = 0;
							}
						}

					}
					
					if(solveSudoku(matrix, n)) {
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

	public static boolean solveSudoku(int[][] board, int n)  
	{ 
		int row = -1; 
		int col = -1; 
		boolean isEmpty = true; 
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0; j < n; j++)  
			{ 
				if (board[i][j] == 0)  
				{ 
					row = i; 
					col = j; 


					isEmpty = false;  
					break; 
				} 
			} 
			if (!isEmpty) 
			{ 
				break; 
			} 
		} 


		if (isEmpty)  
		{ 
			return true; 
		} 


		for (int num = 1; num <= n; num++) 
		{ 
			if (isSafe(board, row, col, num)) 
			{ 
				board[row][col] = num; 
				if (solveSudoku(board, n))  
				{ 

					return true; 
				}  
				else
				{ 
					board[row][col] = 0;  
				} 
			} 
		} 
		return false; 
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

			if ((r + 1) % (int) Math.sqrt(N) == 0)  
			{ 
				System.out.print(""); 
			} 
		} 
	} 
}

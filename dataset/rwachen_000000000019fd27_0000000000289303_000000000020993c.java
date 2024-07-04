import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < T; i++) {
		    int N = Integer.valueOf(scanner.nextLine());
		    String[] input = new String[N];
		    for (int j = 0; j < N; j++) {
		        input[j] = scanner.nextLine();
		    }
		    int[][] sudoku = new int[N][N];
		    for (int j = 0; j < N; j++) {
		        String[] inputs = input[j].split(" ");
		        for (int l = 0; l < N; l++) {
		            sudoku[j][l] = Integer.valueOf(inputs[l]);
		        }
		    }
		    solve(sudoku, N, i);
		}
	}
		
	public static void solve (int[][] sudoku, int N, int number) {
		int k = 0;
		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			k += sudoku[i][i];
		}
			
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> rowValues = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if (rowValues.contains(sudoku[i][j])) {
					r++;
					break;
				} else {
					rowValues.add(sudoku[i][j]);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> rowValues = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if (rowValues.contains(sudoku[j][i])) {
					c++;
					break;
				} else {
					rowValues.add(sudoku[j][i]);
				}
			}
		}
		
		System.out.println("Case #" + (number + 1) + ": " + k + " " + r + " " + c);
	}
	
}
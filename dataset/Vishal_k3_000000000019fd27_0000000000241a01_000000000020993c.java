import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class Vestigium {

	public static void main(String[] args) {
		int T,N;
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();	
		T = Integer.parseInt(s);
		int TN=1;
		int[][] matrix = new int[1000][1000];
		while(T>0) {
			s = in.nextLine();	
			N = Integer.parseInt(s);
			for(int i=0;i<N;i++) {
					int j=0;
					s = in.nextLine();
					StringTokenizer st = new StringTokenizer(s);
					while(st.hasMoreTokens()) {
						int num = Integer.parseInt(st.nextToken());
						matrix[i][j++] =num; 
					}
			}
			String output = calculateForTestCase(matrix, N, TN);
			System.out.println(output);
			T--;
			TN++;
		}
	}

	private static String calculateForTestCase(int[][] mat, int n, int t) {
		String output = "Case #"+t+": ";
		
		int trace = calculateTrace(mat,n);
		int repeatedCols = calculateRepeatedCols(mat,n);
		int repeatedRows = calculateRepeatedRows(mat,n);
		output = output + trace + " " + repeatedRows + " " + repeatedCols;
		return output;
		
	}

	private static int calculateRepeatedRows(int[][] mat, int n) {
		HashSet<Integer> hsR;
		int repeatedRows = 0;
		for(int i=0;i<n;i++) {
			hsR = new HashSet<>();
			for(int j=0;j<n;j++) {
				if(hsR.contains(mat[i][j])) {
					repeatedRows++;
					break;
				}
				hsR.add(mat[i][j]);
			}
		}
		return repeatedRows;
	}

	private static int calculateRepeatedCols(int[][] mat, int n) {
		HashSet<Integer> hsC;
		int repeatedCols = 0;
		for(int i=0;i<n;i++) {
			hsC = new HashSet<>();
			for(int j=0;j<n;j++) {
				if(hsC.contains(mat[j][i])) {
					repeatedCols++;
					break;
				}
				hsC.add(mat[j][i]);
			}
		}
		return repeatedCols;
	}

	private static int calculateTrace(int[][] mat, int n) {
		int trace = 0;
		for(int i=0;i<n;i++) {
			trace += mat[i][i];
		}
		return trace;
	}
}

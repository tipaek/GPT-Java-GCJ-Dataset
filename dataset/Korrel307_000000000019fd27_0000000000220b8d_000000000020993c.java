  
  
  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Number of cases
        for (int i = 1; i <= t; ++i) {
			
		int n = Integer.parseInt(in.nextLine()); // Matrix size
		
		int[][] matrix = new int[n][n];
		
		for (int a = 1;a<=n;a++) {
			String mat_in = in.nextLine();
			insRow(matrix,mat_in,a);
		}
 
        //print2dArray(matrix);
		int count_row = 0;
		int count_col = 0;
		int correct_total = n*(n+1)/2;
		//System.out.println(correct_total);
		
		for (int p = 1; p <= matrix.length; p++) { 
					
			if (fetchRow(matrix,p) != correct_total || checkmultrow(matrix,p) !=1) { 
					count_row = count_row + 1;
			} 
			if (fetchColumn(matrix,p) != correct_total || checkmultcol(matrix,p)!=1) { 
					count_col = count_col + 1;
			} 
			//System.out.println();
			//System.out.println("p:"+p+" count:"+fetchRow(matrix,p)+" multiple"+checkmultrow(matrix,p)+" cumtotal"+count_row);
			//System.out.println("p:"+p+" count:"+fetchColumn(matrix,p)+" multiple"+checkmultcol(matrix,p)+" cumtotal"+count_col);
			
			//System.out.println();
			
		}
	

		
		int k = findTrace(matrix,n);
		
		System.out.println("Case #" + i + ": " + k  +" " + count_row+ " " + count_col);
		
		}
		
      }
		
		static int checkmultrow(int mat[][], int n) 
		{  
			int sum = 1; 
			for (int i=0; i<mat.length; i++) {
				
				for (int j=i+1; j<mat.length; j++) {
					if (mat[n-1][i]==mat[n-1][j]) {
					sum = 5;
					break;
					}
				}
				//System.out.print(sum+"\t");
			
			}
			
			return sum; 
		}
		
		static int checkmultcol(int mat[][], int n) 
		{ 
			int sum = 1; 
			for (int i=0; i<mat.length; i++) {
				
				for (int j=i+1; j<mat.length; j++) {
					if (mat[i][n-1]==mat[j][n-1]) {
					sum = 5;
					break;
					}
				}
				//System.out.print(sum+"\t");
			
			}
			return sum; 
		}
		
		static int findTrace(int mat[][], int n) 
		{ 
			int sum = 0; 
			for (int i=0; i<n; i++) 
				sum += mat[i][i]; 
			return sum; 
		} 
	
		private static void print2dArray(int[][] matrix) {
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < matrix[0].length; c++) {
					System.out.print(matrix[r][c] + "\t");
				}
				System.out.println();
			}
		}
	
		
		public static String Solve(int[] input) {
			String out = "";
			for (int p = 0; p<input.length;p++) {
				out = out + Integer.toString(input[p])  ;
			}
			return out;
		}
		
		public static String Concat(String[] input) {
			String out = "";
			for (int p = 0; p<input.length;p++) {
				out =  out +(input[p]) +  "";
			}
			return out;
		}
	
		public static int[][] routes(int b) {
			int[][] r = new int[b+1][b];
			for(int i = 0 ; i < r.length; i++){
				for( int j = 0 ; j < r[0].length; j++){
					r[i][j]=0;
				}
			}
			for(int i = 1; i < r.length ; i++){
				int j = 0;
					while( r[i-1][j] == 1 ){
						r[i][j] = 0;
						j++;
					}
					r[i][j] = 1;
					for( j++ ; j <= b-1 ; j++){
						r[i][j] = r[i-1][j];
					}
			}
		return r;
		}



	private static int fetchColumn(int[][] matrix,int col) {
		int out = 0;
		
		for (int c = 0; c < matrix[0].length; c++) {
			out = out + (matrix[c][col-1]);
			
			
		}
			
		return out;
	}
	
	private static int fetchRow(int[][] matrix,int row) {
		int out = 0;
		for (int c = 0; c < matrix[0].length; c++) {
			out = out + matrix[row-1][matrix[0].length-c-1];
			
			//System.out.print(matrix[row-1][c] + "\t");
		}
			
		return out;
	}
	
	private static void insRow(int[][] matrix,String ins,int row) {
		String[] out = ins.split(" ");
		for (int c = 0; c < out.length; c++) {
			matrix[row-1][c] = Integer.parseInt(out[c]);
			
			//System.out.print(matrix[row-1][c] + "\t");
		}
			
		//return matrix;
	}


    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix, int n) {
        int[][] product = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }
	
	
}
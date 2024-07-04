import java.io.*;
import java.util.*;

public class Vestigium {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(br.readLine());
		
		for(int z = 0; z< numTestCases; z++) {
			int N = Integer.parseInt(br.readLine());
			int[][] matrix;
			matrix = new int[N][N];
			for(int i = 0; i< N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j  =0; j< N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int sum = 0;
			for(int i = 0; i<N; i++) {
				sum+=matrix[i][i];
			}
			
			int numRows = 0;
			for(int rows = 0; rows<N; rows++) {
				int[] current = matrix[rows];
				Arrays.sort(current);
				for(int i = 0; i< current.length-1; i++) {
					if(current[i]==current[i+1]) {
						numRows++;
						break;
					}
				}
			}
			
			int numCols = 0;
			for(int cols = 0; cols<N; cols++) {
				int[] current = getColumn(matrix, cols);
				/**
				for(int i = 0; i< current.length; i++) {
					System.out.print(current[i]+ " ");
				}
				System.out.println();
				**/
				Arrays.sort(current);
				for(int i = 0; i< current.length-1; i++) {
					if(current[i]==current[i+1]) {
						numCols++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+(z+1)+": "+sum+" "+numRows+" "+numCols);
			
			
			
		}
	}
	
	public static int[] getColumn(int[][] array, int index){
	    int[] column = new int[array[0].length]; 
	    for(int i=0; i<column.length; i++){
	       column[i] = array[i][index];
	    }
	    return column;
	}

}

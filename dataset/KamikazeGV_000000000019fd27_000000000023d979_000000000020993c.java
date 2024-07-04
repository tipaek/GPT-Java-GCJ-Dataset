import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		//Test
//		int[][] matrix1= {  {1, 2, 3, 4},
//										 {2, 1, 4, 3},
//										 {3, 4, 1, 2},
//										 {4, 3, 2, 1}
//		};
//		int[][] matrix2= {  {2, 2, 2, 2},
//										{2, 3, 2, 3},
//										{2, 2, 2, 3},
//										{2, 2, 2, 2}
//		};
//		
//		System.out.print( noOfRowsWithReps(matrix1) );
//		System.out.println( " "+noOfColsWithReps(matrix1) );
//		System.out.print( noOfRowsWithReps(matrix2) );
//		System.out.println( " "+c );
		String output;
		ArrayList<String> allOutputs = new ArrayList<String>();
		int T;
		
		int N;
		int[][] matrix;
		
		//Create stream
		Scanner sc = new Scanner(System.in);
		
		//Reads T
		T=  Integer.parseInt( sc.next() );
				
		//Do T times
		for(int a=0; a<T; a++) {
			N=Integer.parseInt( sc.next() );
			matrix=new int[N][N];
			
			//Do N*N times
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					matrix[r][c]=Integer.parseInt( sc.next() );
				}
			}
			
			output= Integer.toString(trace(matrix))+" "+noOfRowsWithReps(matrix)+" "+noOfColsWithReps(matrix);
			allOutputs.add(output);
		}
		
		for(int i=1; i<allOutputs.size(); i++) {
			System.out.print("Case #"+i+": ");
			System.out.println( allOutputs.get(i-1) );
		}
		int i=allOutputs.size();
		System.out.print( "Case #"+i+": "+ allOutputs.get(i-1) );
		
		//Closes stream
		sc.close();
	}
	
	public static int trace( int[][] matrix ) {
		int trace=0;
		
		for( int ind=0; ind< matrix.length; ind++) {
			trace+= matrix[ind][ind];
		}
		
		return trace;
	}
	
	public static int rowsReps( int[][] matrix ) {
		ArrayList<Integer> readValues;
		int reps=0;
		int elem;
		boolean alreadyRead;
		
		for(int row=0; row< matrix.length; row++) {
			readValues=new ArrayList<Integer>();	//Clears readValues for each row
			
			for( int col=0; col<matrix[0].length; col++) {
				elem=matrix[row][col];
				
				//Checks if elem's value has already been read in this row. If it has not, add it to readValues
				alreadyRead=false;
				for( int a=0; a< readValues.size(); a++) {
					if( elem== readValues.get(a).intValue() ) {		//Remember: readValues contains Integers, not ints. This is why we use .intValue()
						alreadyRead=true;
						reps++;
						break;
					} 
				}
				
				if( !alreadyRead ) {
					readValues.add( elem );
				}
				
				
			}
		}
		
		return reps;
	}
	
	public static int noOfRowsWithReps(  int[][] matrix ) {
		ArrayList<Integer> readValues;
		int elem;
		boolean alreadyRead;
		int curNoOfRowsWithReps=0;
		
		for(int row=0; row< matrix.length; row++) {
			readValues=new ArrayList<Integer>();	//Clears readValues for each row
			
			for( int col=0; col<matrix[0].length; col++) {
				elem=matrix[row][col];
				
				//Checks if elem's value has already been read in this row. If it has not, add it to readValues
				alreadyRead=false;
				for( int a=0; a< readValues.size(); a++) {
					if( elem== readValues.get(a).intValue() ) {		//Remember: readValues contains Integers, not ints. This is why we use .intValue()
						alreadyRead=true;
						break;
					} 
				}
				
				if( !alreadyRead ) {
					readValues.add( elem );
				} else {
					curNoOfRowsWithReps++;
					break;
				}
				
			}
			
		}		
			
		return curNoOfRowsWithReps;
			
	}
	
	public static int noOfColsWithReps(  int[][] matrix ) {
		ArrayList<Integer> readValues;
		int elem;
		boolean alreadyRead;
		int curNoOfColsWithReps=0;
		
		for(int col=0; col<matrix[0].length; col++) {
			readValues=new ArrayList<Integer>();	//Clears readValues for each row
			for( int row=0; row<matrix.length; row++) {
				elem=matrix[row][col];
				
				
				//Checks if elem's value has already been read in this column. If it has not, add it to readValues
				alreadyRead=false;
				for( int a=0; a< readValues.size(); a++) {
					if( elem== readValues.get(a).intValue() ) {		//Remember: readValues contains Integers, not ints. This is why we use .intValue()
						alreadyRead=true;
						break;
					} 
				}
				
				if( !alreadyRead ) {
					readValues.add( elem );
				} else {
					curNoOfColsWithReps++;
					break;
				}
				
			}
			
		}		
			
		return curNoOfColsWithReps;
			
	}
}
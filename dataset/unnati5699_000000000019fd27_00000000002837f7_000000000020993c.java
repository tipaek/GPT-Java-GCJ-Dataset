import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LatinMatrix {
	public static void main(String[] args) {
		
		List list = new LinkedList();
		
		int testCases, row, column, size, i, j, k, sum;
		
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter number of test cases: ");
		testCases = sc.nextInt();
		
		k=1;
		while(testCases != 0 ) {
			
			//System.out.println("Enter matrix size: ");
			size = sc.nextInt();
			//System.out.println("Enter matrix: ");
			int test[][] = new int[size][size];
			for(i=0; i<size; i++) {
				for(j=0; j<size; j++) {
					test[i][j] = sc.nextInt();
				}
			}
			
			sum = rowTrace(test, size);
			row = rowCount(test);
			column = columnCount(test);
			
			
			list.add("Case #"+k+": "+sum+" "+row+" "+column);
			
			testCases-- ; 
			k++;
		}
		
		for(i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}

	public static int rowTrace(int matrix[][], int size) {
		int sum=0;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i == j) {
					sum = sum + matrix[i][j];
				}
			}
		}
		return sum;
	}
	
	public static int rowCount(int matrix[][]) {
		int row = 0;
		boolean counter=false;
		for(int i=0; i<matrix.length; i++) {
			
			for(int j=0; j<matrix[i].length; j++) {
				int num = matrix[i][j];
				for(int k=j+1; k<matrix.length; k++) {
					if(num == matrix[i][k]) {
						counter = true;
						break;
					}
				}
				if(counter) {
					break;
				}
			}
			if(counter == true) {
				row++;
			}
		}
		
		return row;
	}
	
	public static int columnCount(int matrix[][]) {
		int column = 0;
		boolean counter = false;
		for(int j=0; j<matrix.length; j++) {
			
			for(int i=0; i<matrix[j].length; i++) {
				
				int num = matrix[i][j];
				for(int k=j+1; k<matrix.length; k++) {
					if(num == matrix[k][i]) {
						counter = true;
						break;
					}
				}
				if(counter) {
					break;
				}
				
			}
			if(counter == true) {
				column++;
			}
			
			
		}
		
		return column;
	}

}

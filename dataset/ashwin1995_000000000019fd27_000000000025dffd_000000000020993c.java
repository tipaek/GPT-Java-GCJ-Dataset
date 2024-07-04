import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class MatrixDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int noOfTestCases = Integer.parseInt(in.next());
		
		for(int i=0;i<noOfTestCases;i++) {
			int duplicateInRow = 0 ;
			int duplicateInColumn = 0 ;
			int matrixOrder = Integer.parseInt(in.next());
			int[][] matrix = new int[matrixOrder][matrixOrder]; 
			int diagonalSum = 0;
			for(int outer =0;outer<matrixOrder;outer++) {
				boolean hasDuplicateInRow = false;
				for(int inner =0;inner<matrixOrder;inner++) {
					int val = Integer.parseInt(in.next());
					if(outer==inner) {
						diagonalSum =val;
					}
					matrix[outer][inner] =   val;
						for(int inner_i =0;inner_i<inner;inner_i++) {
							if(matrix[outer][inner_i] ==   val) {
								hasDuplicateInRow = true;
							}
						}
					}
				if(hasDuplicateInRow) {
				duplicateInRow ++;	
				}
			}
			
			HashSet<Integer> set;
			for(int outer =0;outer<matrixOrder;outer++) {
				set = new HashSet<Integer>();
				for(int inner =0;inner<matrixOrder;inner++) {
					
					set.add(matrix[outer][inner]);
				}
				if(set.size() != matrixOrder) {
					duplicateInColumn ++;
				}
			}
			int count = i+1;
			System.out.println("Case #"+count+": "+diagonalSum+" "+duplicateInRow+" "+duplicateInColumn+"");
			
		}
			
				
	}

}
	


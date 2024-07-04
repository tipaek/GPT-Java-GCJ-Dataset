
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

	private static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] matrixarray;
		sc = new Scanner(System.in);
		int a=sc.nextInt();
		matrixarray=new int[a][][];
		for (int i = 0; i < a; i++) {
			int b=sc.nextInt();
			int[][] matrix=new int[b][b];
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix.length; k++) {
					matrix[j][k]=sc.nextInt();
				}
			}
			matrixarray[i]=matrix;
				}
		for (int i = 0; i < matrixarray.length; i++) {
			System.out.println("Case #"+i+": "+calculateTraceOfMatrix(matrixarray[i])+" "+countIdenticalElementRows(matrixarray[i])
			+" "+countIdenticalElementsColumns(matrixarray[i]));
			calculateTraceOfMatrix(matrixarray[i]);
		}
	}
	public static int calculateTraceOfMatrix(int[][] matrix) {
		int Sum=0;
		for (int i = 0; i < matrix.length; i++) {
			Sum+=matrix[i][i];
			}
		return Sum;
	}
	
	public static int countIdenticalElementRows(int mat[][]) 
    { 
  
        int count = 0; 
        for (int i = 0; i < mat.length; i++) { 
        	boolean duplicateFound=false;
        	HashSet<Integer> hsr = new HashSet<>(); 
            for (int j = 0; j < mat[i].length; j++) { 
            	if (!hsr.add(mat[i][j])) {
                    duplicateFound=true;
                    break;
                }
            } 
            if (duplicateFound==true) {
				count+=1;
			}	
            
        } 
        return count; 
    } 
	public static int countIdenticalElementsColumns(int mat[][]) {
		int count=0;
		for (int i = 0; i < mat.length; i++) {
			boolean duplicatefound=false;
			HashSet<Integer> hsc=new HashSet<>();
			for (int j = 0; j < mat.length; j++) {
				if (!hsc.add(mat[j][i])) {
					duplicatefound=true;
					break;
				}
				
			}
			if (duplicatefound==true) {
				count+=1;
			}
		}
        return count;		
	}
}

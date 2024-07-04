import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution{

    public static void main(String args[]) {
		int numberOfMatrixies;
        Scanner console = new Scanner(System.in);
        numberOfMatrixies = console.nextInt();
        
        int[][][] matrixes = new int[numberOfMatrixies][][];
        
        for(int i = 0; i < numberOfMatrixies; i++) {
        	int size = console.nextInt();
        	matrixes[i] = new int[size][size];
        	for(int j = 0; j < size; j++) {
        		for(int j2 = 0; j2 < size; j2++) {
        			matrixes[i][j][j2] = console.nextInt();
            	}
        	}
        }
        
        for(int i = 0; i < numberOfMatrixies; i++) {
        	//calculate diagonal
        	int diagonal = 0;
        	for(int j = 0; j < matrixes[i].length; j++) {
        		diagonal += matrixes[i][j][j];
        	}
        	//calulate row repeated
        	int rowRepeatedCount = 0;
        	for(int j = 0; j < matrixes[i].length; j++) {
        		Set<Integer> rowSet = new HashSet<Integer>();
        		for(int j2 = 0; j2 < matrixes[i].length; j2++) {
        			rowSet.add(matrixes[i][j][j2]);
        		}
        		if(rowSet.size() != matrixes[i].length) {
        			rowRepeatedCount++;
        		}
        	}
        	
        	//calculate col repeated
        	int colRepeatedCount = 0;
        	for(int j = 0; j < matrixes[i].length; j++) {
        		Set<Integer> colSet = new HashSet<Integer>();
        		for(int j2 = 0; j2 < matrixes[i].length; j2++) {
        			colSet.add(matrixes[i][j2][j]);
        		}
        		if(colSet.size() != matrixes[i].length) {
        			colRepeatedCount++;
        		}
        	}
        	
        	System.out.println("Case #" + ((int)(i+1))+ ": " + diagonal + " " + rowRepeatedCount + " " + colRepeatedCount);
        }
        
	}
}
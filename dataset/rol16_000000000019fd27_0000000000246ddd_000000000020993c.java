import java.util.Scanner;


public class Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int i = 0; i < T; i++) { //T test cases
	    	//input N, size of the matrix to explore
	    	int N = Integer.parseInt(scanner.nextLine());
	    	//initialize 2x2 array
	    	int trace = 0; //trace variable
	    	int[][] matrix = new int[N][N]; 
	    	for(int j = 0; j < N; j++) { //NxN matrix
	    		String input = scanner.nextLine();
	    		//process input and chop chop numbers
	    		String[] token = input.split(" ");
	    		for(int k = 0; k < N; k++) {
	    			matrix[j][k] = Integer.parseInt(token[k]);
	    			if(j == k) {
	    				trace += Integer.parseInt(token[k]);
	    			}
	    		}
	    	}
	    	//process matrix phase
	    	int caseNumber = i+1;
	    	String output = "Case #"+caseNumber+": "+trace+" ";
	    	
	    	//
	    	int colCounter = 0;
	    	int rowCounter = 0;
	    	for(int x = 0; x < N; x++) { //this calculates rows
	    		int[] rowFreq = new int[101];
	    		for(int y = 0; y < N; y++) {
	    			rowFreq[matrix[x][y]]++;
	    			if(rowFreq[matrix[x][y]] > 1) {
	    				rowCounter++;
	    				break;
	    			}
	    		}
	    	}
	    	
	    	for(int x = 0; x < N; x++) { //this calculates columns
	    		int[] colFreq = new int[101];
	    		for(int y = 0; y < N; y++) {
	    			colFreq[matrix[y][x]]++;
	    			if(colFreq[matrix[y][x]] > 1) {
	    				colCounter++;
	    				break;
	    			}
	    		}
	    	}
	    	output += rowCounter +" "+colCounter;
	    	System.out.println(output);
	    }
	}

}
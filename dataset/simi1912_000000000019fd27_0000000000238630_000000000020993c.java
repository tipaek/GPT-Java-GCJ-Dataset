package qualification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vestigium {

	static int numCases;
	static List<Matrix> matrixes = new ArrayList<Matrix>();
	static Scanner scanner;
	
	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		
		numCases = scanner.nextInt();
		
		int matrixSize = 0;
		Matrix matrix = null;
		for(int i=0; i<numCases; i++) {
			matrixSize = 0;
			matrix = null;
			
			matrixSize = scanner.nextInt();
			matrix = new Matrix(matrixSize, scanner);
			matrix.addArrayToMatix(matrix, matrixSize);
			
			matrixes.add(matrix);
		}
		
		printOutput();
	}

	private static void printOutput() {
		
		int caseNr = 0;
		
		for(Matrix matrix: matrixes) {
			
			System.out.println("Case #"+caseNr+++": "+matrix.getTrace()+" "+matrix.getRepetableValNrRows()+" "+matrix.getRepetableValNrColl());
		}
	}
}

class Matrix {
	
	int matrixSize;
	int values[][];
	Scanner scanner;
	
	public Matrix(int matrixSize, Scanner scanner) {
		this.matrixSize = matrixSize;
		this.scanner = scanner;
		values = new int[matrixSize-1][matrixSize-1];
	}
	
	public int getTrace() {
		
		int traceVal = 0;
		for(int i=0; i<matrixSize; i++) {
			traceVal = traceVal + values[i][i];
		}
		return traceVal;
	}
	
	public void addArrayToMatix(Matrix matrix, int matrixSize) {
		
		for(int row=0; row<matrixSize; row++) {
			for(int col=0; col<matrixSize; col++) {
				values[row][col] = scanner.nextInt();
			}
		}
	}
	
	public int getRepetableValNrRows() {
		
		int nrRows = 0;
		
		List<Integer> valuesEncountered;
		int value;
		
		for(int row=0; row<matrixSize; row++) {
			
			valuesEncountered = new ArrayList<>();
			
			for(int col=0; col<matrixSize; col++) {
				
				value = values[row][col];
				if(valuesEncountered.contains(value)) {
					nrRows++;
					break;
				}else {
					valuesEncountered.add(value);
				}
			}
		}
		return nrRows;
	}
	
	public int getRepetableValNrColl() {
		
		int nrColl = 0;
		
		List<Integer> valuesEncountered;
		int value;
		
		for(int col=0; col<matrixSize; col++) {
			
			valuesEncountered = new ArrayList<>();
			
			for(int row=0; row<matrixSize; row++) {
				
				value = values[row][col];
				if(valuesEncountered.contains(value)) {
					nrColl++;
					break;
				}else {
					valuesEncountered.add(value);
				}
			}
		}
		return nrColl;
	}
}
	


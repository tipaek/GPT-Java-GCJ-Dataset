import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner scInputReader = new Scanner(System.in);
    	Integer iNoOfTestCases = 0, iMatrixSize = 0, iTrace = 0, iRepeatingRows = 0;
    	Integer[][] iFullMatrix;
    	
    	String[] sRowValue;
    	String output = "";
    	
    	//Reading No. of Test Cases and Team Size
    	iNoOfTestCases = Integer.parseInt(scInputReader.nextLine().trim());
    	
    	if((iNoOfTestCases < 1) || (iNoOfTestCases > 100)){
    		System.out.println("Number of Test Cases should be >= 1 or <= 100.");
    		
    		//Closing the Scanner input stream and exiting the program by throwing an Exception
    		scInputReader.close();
    		throw new Exception("Invalid Test Case Count.");
    	}
    	
    	//Executing for "No of test-cases" times
    	for(Integer iTC = 0; iTC < iNoOfTestCases; iTC++) {
    		//Reading Matrix size
	    	iMatrixSize = Integer.parseInt(scInputReader.nextLine().trim());
	    	
	    	if((iMatrixSize < 2) || (iMatrixSize > 100)){
	    		System.out.println("Matrix Size should be >= 2 or <= 100.");
	    		
	    		//Closing the Scanner input stream and exiting the program by throwing an Exception
	    		scInputReader.close();
	    		throw new Exception("Invalid Matrix Size.");
	    	}
	    	
	    	//Initializing Full Matrix. Required for calculating repeating columns.
	    	iFullMatrix = new Integer[iMatrixSize][iMatrixSize];
	    	
	    	//Initializing the thread pool. Setting the value as the number of rows;
	    	ExecutorService service = Executors.newFixedThreadPool(iMatrixSize);
	    	
	    	for(Integer iMatrixRows = 0; iMatrixRows < iMatrixSize; iMatrixRows++) {
	    		sRowValue = scInputReader.nextLine().trim().split(" ");
	    		
	    		for(Integer col = 0; col < iMatrixSize; col++) {
	    			iFullMatrix[iMatrixRows][col] = Integer.parseInt(sRowValue[col]);
	    		}
	    		
	    		//Calculating Trace
	    		iTrace = iTrace + Integer.parseInt(sRowValue[iMatrixRows]);
	    		
	    		//Calculating Repetitive Rows
	    		Future<Integer> fRowValidation = service.submit(new CalculateRepeatingRow(sRowValue));
	    		iRepeatingRows = iRepeatingRows + fRowValidation.get();
	    	}
	    	
	    	//Calculating Repetitive Columns
	    	Future<Integer> fRepeatingCol = service.submit(new CalculateRepeatingColumn(iFullMatrix));
	    	
	    	output = output + "Case #" + (iTC+1) + ": " + iTrace + " " + iRepeatingRows + " " + fRepeatingCol.get() + "\n";
	    	
	    	iTrace = iRepeatingRows = 0;
	    	
	    	service.shutdown();
    	}

    	System.out.print(output);
    	scInputReader.close();
	}
}

class CalculateRepeatingRow implements Callable<Integer>{
	String row[];
	
	public CalculateRepeatingRow(String[] row) {
		this.row = row;
	}

	@Override
	public Integer call() throws Exception {
		Integer iReturnValue = 0;
		
		outerloop:
		for(Integer i = 0; i < (row.length - 1); i++) {
			for(Integer j = i+1; j < row.length; j++) {
				if(Integer.parseInt(row[i]) == Integer.parseInt(row[j])) {
					iReturnValue = 1;
					break outerloop;	//If a value repeats then setting the return value as 1 and breaking the loop, as further calculation is not required.
				}
			}
		}
		
		return iReturnValue;
	}
}

class CalculateRepeatingColumn implements Callable<Integer>{
	Integer[][] iFullMatrix;
	
	public CalculateRepeatingColumn(Integer[][] iFullMatrix) {
		this.iFullMatrix = iFullMatrix;
	}

	@Override
	public Integer call() throws Exception {
		Integer iRepeatColCnt = 0;
		
		for(Integer col = 0; col < iFullMatrix.length; col++) {
			ForLoop:
			for(Integer row = 0; row < (iFullMatrix.length-1); row++) {
				Integer chk = iFullMatrix[row][col];
				
				for(Integer i = row+1; i < iFullMatrix.length; i++) {
					if(chk == iFullMatrix[i][col]) {
						iRepeatColCnt++;
						break ForLoop;	//If a value repeats then increasing the repeating col count by 1 and breaking the loop, as further calculation on this col not required.
					}
				}
				
			}
		}
		
		return iRepeatColCnt;
	}
}
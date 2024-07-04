import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution{
    
    private static Logger logger = Logger.getLogger(Solution.class.getName());	

    
    public class Matrix {
	
    	private int[][] matrix;
    	private int N;
    	/**
    	 * Construct a matrix from lines (array of Strings)
    	 * @param N
    	 * @param lines
    	 */
    	public Matrix(int N, String[] lines) {
    		//Initialize the matrix
    		matrix = new int[N][N];
    		
    		//Iterate over the lines to obtain the values
    		if (lines.length == N) {
    			for (int i=0; i<N; i++) {
    				String[] lineValues = lines[i].split(" ");
    				if (lineValues.length ==N) {
    					for (int j=0; j<N; j++) {
    						matrix[j][i] = Integer.parseInt(lineValues[j]);
    					}
    				}else
    					//Wrong format, exit:
    					i=N;
    			}
    			
    			//If the matrix was formed correctly, update N too
    			if (matrix!= null && matrix.length == N) {
    				this.N = N;
    			}
    		}
    		
    	}
    	
    	/**
    	 * Get values in the matrix
    	 * @return matrix
    	 */
    	public int[][] getMatrix(){
    		return matrix;
    	}
    	
    	/**
    	 * Get size of the matrix
    	 * @return N
    	 */
    	public int getN() {
    		return N;
    	}
    	
    	/**
    	 * Check if the matrix NxN is natural latin square.
    	 * Matrix is a Latin square if each cell contains one of N different values, 
    	 * and no value is repeated within a row or a column.
    	 * 
    	 * The trace of a square matrix is the sum of the values on the main diagonal 
    	 * 
    	 * Indexing over the matrix: Mi,j 
    	 * @param N sizeOfMatrix
    	 * @param matrix matrix
    	 */
    	public void isNaturalLatinSquare(int caseNumber) {
    		//Trace value
    		int trace = 0;
    		
    		//Count the number of repeated columns
    		boolean[] isColumnRepeated = new boolean[N];
    		boolean[] isRowRepeated = new boolean[N];
    		int nRowRepeatedValues = 0;
    		int nColumnRepeatedValues = 0;
    		//Compute the calculations
    		for (int i = 0; i < N; i++ ) { 
    			for (int j=0; j<N; j++) {
    				int firstValue = matrix[i][j];
    				//Check if part of the trace computations
    				if (i==j) {
    					trace+= firstValue;
    				}
    				
    				//Verify the column:
    				for (int ii=i+1; ii<N; ii++) {
    					int value = matrix[ii][j];
    					if (1< value && value<=N)
    						if (value == firstValue && !isRowRepeated[ii]) {
    							//Same value in the column: break too
    							isRowRepeated[ii]=true;
    							nRowRepeatedValues ++;
    							ii = N;
    						}	
    				}
    
    				//Verify the row:
    				for (int jj=j+1; jj<N; jj++) {
    					int value = matrix[i][jj];
    					if (1< value && value<=N)
    						if (value == firstValue && !isColumnRepeated[jj]) {
    							//Same value in the column: break too
    							isColumnRepeated[jj]=true;
    							nColumnRepeatedValues ++;
    							jj = N;
    						}	
    				}
    				
    			}
    			
    		}
    				
    		System.out.println(String.format("Case #%d: %d %d %d", caseNumber, trace, nRowRepeatedValues, nColumnRepeatedValues));
    	}
    
    }
    
	/**
	 * Read input file line by line
	 */
	public static String[] readInput(InputStream inStream) {
		ArrayList<String> lines  = new ArrayList<String>();
		
		//Use a bufferedReader
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			String line = reader.readLine();
			while (line != null) {
				//Add line to the list
				lines.add(line);
				//Get next line
				line = reader.readLine();
			}
			
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		 return lines.toArray(new String[lines.size()]);
	}


    /**
     * Main method
	 * @param args arguments
     */
    public static void main(String[] args){
         //Read the input
        String[] lines = readInput(System.in);
        
        Solution solution = new Solution();
        if (lines.length>3) {
            //1. Extract all matrices
	        //Get T = Test cases
	        int T = Integer.parseInt(lines[0]);
	        //Get the T matrices
	        Matrix[] matrices = new Matrix[T];
	        
	        //Extract each matrix and check if Latin Square Matrix
	        int mIndex = 1;
	        int totalLines = lines.length;
	        while(mIndex < totalLines && T>0) {
	        	int N = Integer.parseInt(lines[mIndex]);
	        	mIndex ++;
	        	matrices[T-1]=solution.new Matrix(N, Arrays.copyOfRange(lines, mIndex, mIndex+N));
	        	//Update indexes
	        	mIndex += N;
	        	T--;
	        }
	        System.out.println("Matrices: "+matrices.length);
	        
	        
	        //2. Verify if the matrices are natural latin square.
	        for (int m=matrices.length-1; m>=0; m--) {
	        	Matrix testMatrix = matrices[m];
	        	testMatrix.isNaturalLatinSquare(matrices.length-m);
	        }
	        
        }else {
        	logger.log(Level.WARNING, "Empty input test file");
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solution {
	
//	private static int[] input, inputArray;
	private static int matrixSize, trace; 
	private static int cases;
	private static int[][] finalMatrix;
	private static String outputString; 
	
	private static BufferedReader br;
    private static PrintWriter pw;
	
	private static void setIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }
	
	private static void input(int numCase) throws IOException {
		String line;
		StringTokenizer data;
		
		line = br.readLine();
		data = new StringTokenizer(line);
		
		matrixSize = Integer.parseInt(data.nextToken());
		trace = Integer.parseInt(data.nextToken());
		finalMatrix = new int[matrixSize][matrixSize];
	}
	
	private static void work() {
		outputString = "";
		int[][] listOfArrays = new int[matrixSize][matrixSize];
		
		for (int i = 0; i < matrixSize; i++) {
			listOfArrays[0][i] = i+1;
		}
		
		for (int i = 1; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				listOfArrays[i][j] = j+1;
			}
			listOfArrays[i] = rightRotate(listOfArrays[i], i);
		}
		
		permute(listOfArrays, 0, matrixSize - 1);
	}
	
	private static void display(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void permute(int[][] matrix, int l, int r) 
    { 	int traceOfMatrix;
        if (l == r) {
        	traceOfMatrix = calculateTrace(matrix);
        	if (traceOfMatrix == trace) {
        		outputString = "POSSIBLE";
        		for (int i = 0; i < matrixSize; i++) {
        			for (int j = 0; j < matrixSize; j++) {
        				finalMatrix[i][j] = matrix[i][j];
        			}
        		}
        	}
        } 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                matrix = swap(matrix,l,i); 
                permute(matrix, l+1, r); 
                matrix = swap(matrix,l,i); 
            } 
        } 
    } 
	
	private static int[][] swap (int[][] matrix, int to, int from) {
		int[] array = new int[matrix.length];
		array = matrix[to];
		matrix[to] = matrix[from];
		matrix[from] = array;
		return matrix;
	}
	
	private static int calculateTrace(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		return sum;
	}
	
	private static int[] rightRotate(int[] array, int k) {
		int[] returnArray = array;
		returnArray = reverse(returnArray, 0, returnArray.length - k - 1);
		returnArray = reverse(returnArray, returnArray.length - k, returnArray.length - 1);
		return reverse(returnArray);
	}
	
	private static int[] reverse(int[] array) {
		return reverse(array, 0, array.length - 1);
	}
	
	private static int[] reverse(int[] array, int startIndex, int endIndex) {
		int mid = (endIndex - startIndex)/2;
		int temp;
		
		for (int i = 0; i <= mid; i++) {
			temp = array[startIndex + i];
			array[startIndex + i] = array[endIndex - i];
			array[endIndex - i] = temp;
		}
		
		return array;
	}
	
	private static void output(int caseNum) throws IOException {
		if (outputString.length() == 0) pw.println("Case #" + caseNum + ": " + "IMPOSSIBLE");
		else {
			if (outputString.equals("POSSIBLE")) {
				pw.println("Case #" + caseNum + ": " + outputString);
				for (int i = 0; i < matrixSize; i++) {
					for (int j = 0; j < matrixSize; j++) {
						pw.print(finalMatrix[i][j]);
					}
					pw.println();
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		setIO();
		
		cases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cases; i++) {
        	input(i);
            work();
            output(i);
        }

        br.close();
        pw.close();
	}
}

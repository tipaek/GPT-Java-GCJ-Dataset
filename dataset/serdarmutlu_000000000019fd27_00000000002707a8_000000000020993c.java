/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.util.Scanner;

/**
 *
 * @author serdarm99
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    
    static int repeatedElements(int[][] arr,boolean vh,int size){
        int result = 1 ;
        if(vh){
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size;j++){
				if(arr[i][j] == arr[i][j+1])
					result += 1;
			}
		}
	}
	else{
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size;j++){
				if(arr[i][j] == arr[i+1][j])
					result += 1;
                    }
                }
        }
        
        
        
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        int matrixSize = s.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }
        System.out.println(trace);
        System.out.println(repeatedElements(matrix,true,matrixSize-1));
        System.out.println(repeatedElements(matrix,false,matrixSize-1));
    }
    
}

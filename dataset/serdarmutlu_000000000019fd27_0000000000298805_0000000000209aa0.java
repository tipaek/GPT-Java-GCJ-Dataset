/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.util.Random;
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
    static void createArray(int[][] matrix,int matrixSize){
        Random r = new Random();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = r.nextInt() % matrixSize ;
            }
        }
    }
    static void showMatrix(int[][] matrix,int matrixSize){
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
    }
    static int calculateTrace(int[][] matrix,int matrixSize){
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }
        return trace;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        
        
        int matrixSize = s.nextInt();
        int requested = s.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        createArray(matrix,matrixSize);
        boolean flag = false;
        boolean flag2 = false;
        for (int i = 0; i < matrixSize; i++) {
            if(i*matrixSize == requested)
                flag2 = true;
            
        }
        if(flag2){
        while(true){
            if(calculateTrace(matrix,matrixSize) == requested){
                System.out.println("POSSIBLE");
                showMatrix(matrix,matrixSize);
                flag = true;
                break;
            }
            else{
                createArray(matrix,matrixSize);
            }
            
        }
       }
        if(!flag) System.out.println("IMPOSSIBLE");
       
    }
    
}

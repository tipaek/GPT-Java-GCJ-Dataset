import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int temp = 1;
        while(temp <= testCases) {
        	int size = sc.nextInt();
            Integer[][] matrix = new Integer[size][size];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for(int i = 0; i < matrix.length; i++) {
                trace += matrix[i][i]; 
         	}
            
            int rowDuplicates = findDuplicates(matrix, 0);
            
            for(int i = 0; i < matrix.length; i++) {
            	 for(int j = i; j < matrix.length; j++) {
            		 swap(matrix, i, j);
            	 }
            }
            
            int colDuplicates = findDuplicates(matrix, 0);;
            
            System.out.println("Case #"+temp+": "+trace+" "+rowDuplicates+" "+colDuplicates);
            temp++;
        }
    }
    
    public static void swap(Integer[][] matrix, int i, int j) {
    	int temp = matrix[i][j];
    	matrix[i][j] = matrix[j][i];
    	matrix[j][i] = temp;
    }
    
    public static int findDuplicates(Integer[][] matrix, int duplicates) {
    	int numDuplicates = 0;
    	for(int i = 0; i < matrix.length; i++) {
        	Integer[] row = matrix[i];
        	Set<Integer> set = new HashSet<>(Arrays.asList(row));
        	if(set.size() < row.length) {
        		numDuplicates++;
        	}
        }
    	return numDuplicates;
    }
}
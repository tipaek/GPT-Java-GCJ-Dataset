import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("testcase.txt"));
    	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.valueOf(in.nextLine());
        for(int i=0; i<T; i++) {
        	int N = Integer.valueOf(in.nextLine());
        	String[][] matrix = new String[N][N];
        	for(int j=0; j<N; j++) {
        		String[] arr = in.nextLine().split(" ");
        		matrix[j] = arr;
        	}
        	int[] solution = solve(matrix);
        	int k = solution[0];
        	int r = solution[1];
        	int c = solution[2];
        	System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
        
     }
    public static int[] solve(String[][] matrix) {
    	int trace = 0;
    	int notUnique = 0;
    	int duplicateCol = 0;
    	String[][] colArray = new String[matrix.length][matrix.length];
    	for(int i = 0; i<matrix.length; i++) {
    		trace += Integer.valueOf(matrix[i][i]);
    		if(!areDistinct(matrix[i])) {
    			notUnique+=1;
    		}
    		String[] temp = new String[matrix.length];
    		for(int j=0; j<matrix.length; j++) {
    			temp[j] = matrix[j][i];
    		}
    		colArray[i] = temp;
    	}
    	for(int i=0; i<matrix.length; i++) {
    		if(!areDistinct(colArray[i])) {
    			duplicateCol += 1;
    		}
    	}
    	int[] solution = new int[3];
    	solution[0] = trace;
    	solution[1] = notUnique;
    	solution[2] = duplicateCol;
    	return solution;
    }
    public static boolean areDistinct(String arr[]) 
    { 
        // Put all array elements in a HashSet 
        Set<String> s =  
           new HashSet<String>(Arrays.asList(arr)); 
  
        // If all elements are distinct, size of 
        // HashSet should be same array. 
        return (s.size() == arr.length); 
    } 
}
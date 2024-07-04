import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Steve Mwangi
 * 3:01:15 PM
 * 2020
 */
public class Solution{
    @SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int iii = 0; iii < t; iii++){
        	int x = iii + 1;
        	int n = in.nextInt();
        	int k = in.nextInt();
        	int sum = (n)*(n-1) / 2;
        	if(k < sum || (isOdd(k) && isEven(n)) || (n==0 && k > 0)) {
        		System.out.println("Case #" + x + ": " + "IMPOSSIBLE");
        		continue;
        	} else if(n==1) {
        		System.out.println("Case #" + x + ": " + "POSSIBLE" + "\n" + k);
        		continue;
        	}
        	int[][] matrix = new int[n][n];
        	matrix = iterate(matrix, n, k);
            System.out.println("Case #" + x + ": " + "POSSIBLE" + "\n" + print2D(matrix));
        }
    }
    
    public static int[][] iterate(int[][] matrix, int n, int k){
    	int[] summ = new int[n];
    	int x = k-(n)*(n+1) / 2;
    	//System.out.println("x: " + x);
    	for(int i = 0; i < n; i++){
    		summ[i] = i+1;
    		if(i==n-1) {
    			summ[i] += x;
    		}
    	}
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			matrix[i][j] = summ[j];
    		}
    		summ = shift(summ);
    	}
    	return matrix;
    }
    public static int[] shift(int[] arr) {
    	int temp = arr[0];
    	for(int i = 0; i < arr.length - 1; i++) {
    		arr[i] = arr[i+1];
    	}
    	arr[arr.length - 1] = temp;
    	return arr;
    }
    public static Boolean isOdd(int o) {
    	return o%2 == 1;
    }
    public static Boolean isEven(int e) {
    	return e%2==0;
    }
    public static String print2D(int[][] matrix) {
    	String result = "";
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[i].length; j++) {
    			result = result.concat(matrix[i][j] + " ");
    		}
    		if(i != matrix.length-1) {
    			result = result.concat("\n");
    		}
    	}
    	return result;
    }
}
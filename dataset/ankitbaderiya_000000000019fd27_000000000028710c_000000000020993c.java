import java.io.IOException; 
import java.util.*;

public class Vestigium
{
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
           int t = in.nextInt();
            if (t>=1 && t<=100) {
                
                for (int x=0; x<t; x++) {
                    int n = in.nextInt();
                    if (n>=2 && n<=100) {
                        int[][] arr = new int[n][n];
                        for (int i=0; i<n; i++) {
                            for (int j=0; j<n; j++) {
                                arr[i][j] = in.nextInt();
                            }
                        }
                        processArray(arr, x+1);
                    }
                }
            } 
        }
        catch (Exception e) {
            System.out.println(e);
        }
	}
	
	private static void processArray(int[][] arr, int c) {
	    // trace
	    int trace = 0;
	    for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (i==j) {
                   trace = trace + arr[i][j]; 
                }
            }
        }
	    
	    // # of rows
	    int noOfRows = 0;
	    for (int i=0; i<arr.length; i++) {
	        HashSet<Integer> set = new HashSet<>();
            for (int j=0; j<arr.length; j++) {
                if (set.contains(arr[i][j])) {
                    noOfRows++;
                    break;
                }
                else {
                    set.add(arr[i][j]);
                }
            }
        }
	    
	    
	    // # of columns
	    int noOfCols = 0;
	    for (int j=0; j<arr.length; j++) {
	        HashSet<Integer> set = new HashSet<>();
            for (int i=0; i<arr.length; i++) {
                if (set.contains(arr[i][j])) {
                    noOfCols++;
                    break;
                }
                else {
                    set.add(arr[i][j]);
                }
            }
        }
	    
	    System.out.println("Case #" + c + ": " + trace + " " + noOfRows + " " + noOfCols);
	}
}

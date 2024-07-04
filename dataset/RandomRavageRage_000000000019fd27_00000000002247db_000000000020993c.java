import java.util.*;
import java.io.*;
public class Solution {
	public static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
        	//each case
        	testCase(i);
        }
        br.close();
    }
    
    public static void testCase(int x) throws NumberFormatException, IOException{
    	int n = Integer.parseInt(br.readLine());
    	int[][] matrix = new int[n][n];
    	int trace = 0;
    	//reading in by rows
    	StringTokenizer st;
        for(int i = 0; i < n; i++){
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
            	matrix[i][j] = Integer.parseInt(st.nextToken());
            	if(i == j){
            		trace += matrix[i][j];
            	}
            }
        }
        
        //test rows
        int r = 0;
        for(int i = 0; i < n; i++){
        	boolean[] usedValues = new boolean[n];
        	for(int j = 0; j < n; j++){
            	if(usedValues[matrix[i][j] - 1]){
            		r++;
            		break;
            	}else{
            		usedValues[matrix[i][j] - 1] = true;
            	}
        	}
        }
        
        //test columns
        int c = 0;
        for(int j = 0; j < n; j++){
        	boolean[] usedValues = new boolean[n];
        	for(int i = 0; i < n; i++){
            	if(usedValues[matrix[i][j] - 1]){
            		c++;
            		break;
            	}else{
            		usedValues[matrix[i][j] - 1] = true;
            	}
        	}
        }
        
        System.out.println("Case #" + x + ": " + trace + " " + r + " " + c);
    }
}
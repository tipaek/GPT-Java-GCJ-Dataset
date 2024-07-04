import java.util.*;
import java.io.*;
public class Solution {
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int c = in.nextInt(); // number Testcases. 
        
        for (int t=1;t<=c;t++) {
        	int n = in.nextInt(); // size of matrix to analyse
        	int[] matrix = new int[n*n]; //first row i, then column j
        	int trace = 0;
        	boolean[] test= new boolean[n];
        	int x=0;
        	boolean repeatRow = false;
        	int countRow = 0;
        	int countCol = 0;

        	for (int i = 0; i < n*n; ++i) {
        		x= in.nextInt();
        		matrix[i]=x;
        		if ((int)i/n == i%n) {
        			trace += matrix [i]; // Calculate trace.
        		}
        		if (i%n == 0) {			//RESETS test rows every n numbers. 
        			repeatRow=false;
        			for (int k=0;k<n;k++) {
        				test[k]=false;
        			}
        		}
        		
        		if (test[x-1]==true && repeatRow==false) {
        			
        			countRow++;
        			repeatRow=true;
        		}
        		
        		else {
        			test[x-1]=true;
        		}
        	}
        	
        	//RESET TEST
        	for (int k=0;k<n;k++) {
				test[k]=false;
			}
        	//TESt Columns
        	
        	for (int i=0; i<n;i++) {
        		for (int j=0;j<n;j++) {
        			
        			if (test[matrix[j*n+i]-1]== true) {
        				countCol++;
        				break;
        			}
        			else test[matrix[j*n+i]-1]= true;
        		
        		}
        		for (int k=0;k<n;k++) {
    				test[k]=false;
    			}
        	}

        	System.out.println("Case #" + t + ": " + trace + " " + countRow + " " + countCol);
        }
	}
}
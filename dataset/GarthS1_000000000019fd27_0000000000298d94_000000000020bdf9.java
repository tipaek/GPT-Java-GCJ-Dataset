import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTestCases = in.nextInt();
    
    for(int i = 0; i < numTestCases; i++) {
    	int n = in.nextInt();
  		int[][] input = new int[n][2];
  		
    	for(int j = 0; j < n; j++) {
    		input[j][0] = in.nextInt();
    		input[j][1] = in.nextInt();
    	}
    	
    	int[][] match = new int[n][2];
    	
    	for(int j = 0; j < n; j++) {
    		match[j][0] = j;
    		match[j][1] = j;
    	}
    	
    	sort(input, match, n);
    	System.out.println("Case #" + (i+1) + ": " + findString(input, match, n));
    }
	}

	private static void sort(int[][] input, int[][] match, int size) {
		for(int i = size - 1; i >= 0 ; i--) {
			int max = input[i][0];
			int maxPos = i;
			int j = 0;
			
			for (; j < i ; j++) {
				if( max < input[j][0]) {
					max = input[j][0];
					maxPos = j;
				}
			}
			
			match[i][0] = maxPos;  //keeps track of the original placement
			match[maxPos][0] = i;
			
		 	int temp = input[i][0];
		 	input[i][0] = input[maxPos][0];
		 	input[maxPos][0] = temp;
		 	
		 	temp = input[i][1];
		 	input[i][1] = input[maxPos][1];
		 	input[maxPos][1] = temp;
		}	
	}
	
	public static String findString(int[][] input , int[][] match, int size) {
		char[] output = new char[size];
		int cameron = 0;
		int jamie = 0;
		
		for(int i = 0; i < size; i++) {
			if(cameron <= input[i][0]) {
				cameron = input[i][1];
				output[match[i][1]] = 'C';
			}
			else if(jamie <= input[i][0]) {
				jamie = input[i][1];
				output[match[i][1]] = 'J';
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		return new String(output);
	}
}
 
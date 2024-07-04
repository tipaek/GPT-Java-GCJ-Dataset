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
    	
    	int[][] unsortInput = new int[n][2];
    	
    	for(int j = 0; j < n; j++) {
    		unsortInput[j][0] = input[j][0];
    		unsortInput[j][1] = input[j][1];
    	}
    	
    	sort(input, n);
    	System.out.println("Case #" + (i+1) + ": " + findString(input, unsortInput, n));
    }
	}

	private static void sort(int[][] input, int size) {
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
			
		 	int temp = input[i][0];
		 	input[i][0] = input[maxPos][0];
		 	input[maxPos][0] = temp;
		 	
		 	temp = input[i][1];
		 	input[i][1] = input[maxPos][1];
		 	input[maxPos][1] = temp;
		}	
	}
	
	public static String findString(int[][] input , int[][] unsortedInput, int size) {
		char[] output = new char[size];
		int cameron = 0;
		int jamie = 0;
		
		for(int i = 0; i < size; i++) {
			if(cameron <= input[i][0]) {
				cameron = input[i][1];
				for(int j = 0; j < size; j++) {
					if(input[i][0] == unsortedInput[j][0] && input[i][1] == unsortedInput[j][1])
						output[j] = 'C';
				}
			}
			else if(jamie <= input[i][0]) {
				jamie = input[i][1];
				for(int j = 0; j < size; j++) {
					if(input[i][0] == unsortedInput[j][0] && input[i][1] == unsortedInput[j][1])
						output[j] = 'J';
				}
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		return new String(output);
	}
}
 
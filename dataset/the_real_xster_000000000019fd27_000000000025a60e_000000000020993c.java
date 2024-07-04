import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(br.readLine());
			
			for(int i=0;i<testCases;i++) {
				int size = Integer.parseInt(br.readLine());
				
				int trace = 0;
				int rows = 0;
				int columns;
				int[][] columnChecker = new int[size][size];
				Boolean[] columnAdded = new Boolean[size];
				
				for(int j=0;j<size;j++) {
					String[] rowStrings = br.readLine().split(" ");
					int[] rowChecker = new int[size];
					
					boolean rowAdded = false;
					
					Arrays.fill(columnAdded, Boolean.FALSE);
					
					for(int k=0;k<size;k++) {
						int current = Integer.parseInt(rowStrings[k]);
						
						if(columnChecker[k][current-1] == 1) {
							columnAdded[k] = true;
						}
						else {
							columnChecker[k][current-1] = 1;
						}
						
						if(rowChecker[current-1] == 1) {
							rowAdded = true;
						}
						else {
							rowChecker[current-1] = 1;
						}
						
						if(j==k) {
							trace += current;
						}
						
					}
					if(rowAdded) rows++;
				}
				
				columns = columnCalculator(columnAdded);
				
				String outputString = "Case #" + i + ": " + trace + " " + rows + " " + columns;
				System.out.println(outputString);
			}
			
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int columnCalculator(Boolean[] arr) {
		int amount = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]) {
				amount++;
			}
		}
		
		return amount;
	}

}

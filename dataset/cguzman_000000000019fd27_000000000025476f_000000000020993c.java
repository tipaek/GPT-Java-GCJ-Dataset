import java.io.BufferedReader;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {

		try {

			Scanner s = new Scanner(System.in); 
			//FastReader s = new FastReader("jam\\T1.in"); 
	        
			// BufferedReader bf = new BufferedReader(new FileReader("jam\\T1.in"));
			// BufferedReader bf = new BufferedReader(new FileReader(args[0]));
			
			int T = s.nextInt(); 
			
			for(int i = 1; i <= T; i++) {
				
				int N = s.nextInt();

		    	int repeatRow = 0;
		    	int repeatCol = 0;
		    	int sum = 0;

	            int[][] colCheck = new int[N][N];

	            boolean[] colRepeat = new boolean[N];
	            
				for (int row = 0; row < N; row++) {

		            int[] rowCheck = new int[N];

		            boolean rowRepeat = false;
		            
					String[] temp = s.nextLine().split(" ");
					
					for (int col = 0; col < temp.length; col++) {

						int value = Integer.parseInt(temp[col]);
						
						// check the row
		            	rowCheck[value-1]++;
		                if (rowCheck[value-1]>1)
		                	rowRepeat = true;
		                
		                // check the column
		            	colCheck[col][value-1]++;
		                if (colCheck[col][value-1]>1) {
		                	if (!colRepeat[col]) {
		                		colRepeat[col] = true;
		                		repeatCol++;
		                	}
				             
		                }
		                	
		                // sum the main diagonal
		            	if (row == col) {
		            		sum += value;
		            	}
		            	
					}

		            if (rowRepeat)
		            	repeatRow++;
				}
				
				System.out.println("Case #"+i+": "+sum+" "+repeatRow+" "+repeatCol);
				
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 

	}
}

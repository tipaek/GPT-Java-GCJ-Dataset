import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int count = inputScanner.nextInt();
		//cases
		for (int k = 1; k<= count; k++) {
			//square
			int num = inputScanner.nextInt();
			int[][] square = new int[num][num];
			boolean[] rows = new boolean[num];
			boolean[] cols = new boolean[num];
			
			int rowsCount = 0;
			int colsCount = 0;
			for(int i=0; i< num; i++) {
				for(int j=0; j < num; j++) {
					int cellVal = inputScanner.nextInt();
					if(!rows[i] && usedInRow(square, num, i, cellVal)) {
						rows[i] = true;
						rowsCount ++;
					}
					if(!cols[j] && usedInCol(square, num, j, cellVal)) {
						cols[j] = true;
						colsCount ++;
					}
					square[i][j] = cellVal;
					
				}
			}
			
			int sum = 0;
			for(int i=0; i< num; i++) {
				sum += square[i][i];
			}
			System.out.printf("Case #%d: ", k);
			System.out.println(sum+" "+rowsCount+" "+colsCount);
		}
		inputScanner.close();
	}
	
	public static boolean usedInRow(int[][] grid, int size, int row, int num)  
	{  
	    for (int col = 0; col < size; col++)  
	        if (grid[row][col] == num)  
	            return true;  
	    return false;  
	}
	
	public static boolean usedInCol(int[][] grid, int size, int col, int num)  
	{  
	    for (int row = 0; row < size; row++)  
	        if (grid[row][col] == num)  
	            return true;  
	    return false;  
	}  

}

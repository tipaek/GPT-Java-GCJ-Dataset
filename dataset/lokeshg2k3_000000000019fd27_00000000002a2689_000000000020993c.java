import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int testCases = sc.nextInt();
		
		String[] casesResult = new String[testCases];
		
		int currentCase = 0;
		
		while (currentCase < testCases) {
			int row = 0;
			int column = 0;
			int sum = 0;
			
			int currentN = sc.nextInt();
			
			int[][] array = new int[currentN][currentN];
			
			for (int i = 0; i < currentN; i++) {
				Set<Integer> set = new HashSet<>(); 

				for (int j = 0; j < currentN; j++) {
					array[i][j] = sc.nextInt();
					if(!set.add(array[i][j])) {
						row++;
					}
				}
			}
			
			
			for (int i = 0; i < array.length; i++) {
				Set<Integer> set = new HashSet<>(); 

				sum += array[i][i];
				for (int j = 0; j < array[i].length; j++) {
					if(!set.add(array[j][i])) {
						column++;
					}
				}
			}

			casesResult[currentCase] = sum + " " + row + " " + column; 
			
			
			currentCase++;
		}
		
		sc.close();
		//PrintWriter pw = new PrintWriter(new File(""));
		
		for (int i = 0; i < casesResult.length; i++) {
			System.out.println("Case #" + (i+1) + ": " + casesResult[i]);
			//pw.println("Case #" + (i+1) + ": " + casesResult[i]);
		}
		
		
	}
	
	
	
	
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();
		
		
		
		for(int usease = 0; usease< T;usease++) {
			Set<Integer> row = new HashSet<>();
			List<Set<Integer>> columns = new ArrayList<>();
			int numberOfrepeatedRow = 0;
			int numberOfRepeatedColumn =0;
			int trace =0;
			
			int N = scann.nextInt();
			
			for(int i = 0;i<N;i++) {
				 columns.add(new HashSet<Integer>());
			}
			
			scann.nextLine();
			int[][] square = new int[N][N];
			for(int rowNum=0;rowNum<N;rowNum++) {
				 row = new HashSet<>();
				
				 
				String lineString = scann.nextLine();
				String[] arr = lineString.split(" ");
				//Add line
				for(int columNum = 0;columNum<arr.length;columNum++) {
					square[rowNum][columNum] = Integer.parseInt(arr[columNum]);
					row.add(Integer.parseInt(arr[columNum]));
					if(rowNum==columNum) {//Main diag
						trace +=Integer.parseInt(arr[columNum]);
					}
					
					columns.get(columNum).add(Integer.parseInt(arr[columNum]));
				}
				
				if(row.size()<arr.length) {
					numberOfrepeatedRow++;
				}
				
			}
			for(Set<Integer> set : columns) {
				if(set.size() < N) {
					numberOfRepeatedColumn++;
				}
			}

			System.out.println(String.format("Case #%s: %s %s %s",usease+1,trace,numberOfrepeatedRow,numberOfRepeatedColumn));			
			
		}
	}
	
}



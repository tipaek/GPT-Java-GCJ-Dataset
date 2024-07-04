import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int times = scanner.nextInt(); 
		
		for(int k = 0; k < times; k++) {
			int size = scanner.nextInt();
			int[][] matrix = new int[size][size];
			int trace = scanner.nextInt();
			
			if(trace % size != 0) {
				System.out.println("Case #" + (k + 1) + ": " + "IMPOSSIBLE");
				break; 
			}
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(i == j) {
						matrix[i][j] = trace / size; 
					}
				}
			}
			
			int placed = trace / size;  
			for(int i = 0; i < size; i++) {
				HashSet<Integer> set = new HashSet<>(); 
				for(int l = 1; l <= size; l++) 
					set.add(l); 
				set.remove(placed);
				for(int j = 0; j < size; j++) {
					if(i != j) {
						int put = 0; 
						Iterator<Integer> itr = set.iterator();
						while(itr.hasNext()) {
							put = itr.next(); 
							if(i + 1 < matrix.length && matrix[i + 1][j] != put && i - 1 >= 0 && matrix[i - 1][j] != put)
								break; 
						}
						matrix[i][j] = put; 
						set.remove(put); 
					}
				}
			}
			System.out.println("Case #" + (k + 1) + ": " + "POSSIBLE");
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println(); 
			}
		}
	}

}

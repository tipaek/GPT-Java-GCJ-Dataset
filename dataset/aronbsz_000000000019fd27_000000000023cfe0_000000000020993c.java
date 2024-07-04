import java.util.*;
import java.util.Map.Entry;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < testCases; i++) {
			int size = Integer.parseInt(sc.nextLine());
			Set<Integer> row = new HashSet<>();
			Set<Integer> col = new HashSet<>();
			int[][] arr = new int[size][size];
			int rowMismatch = 0;
			int colMismatch = 0;
			int trace = 0;
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					int element = sc.nextInt();
					arr[j][k] = element;
					row.add(element);
					//trace
					if(j == k) {
						trace += element;
					}
					//row
					if(k == size-1) {
						if(row.size() != size) rowMismatch++;
						row.clear();
					}
				}
			}
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					col.add(arr[k][j]);
					//col
					if(k == size-1) {
						if(col.size() != size) colMismatch++;
						col.clear();
					}
				}
			}
			if(sc.hasNextLine())sc.nextLine();
			
			System.out.println("Case #" + (i+1) + ": " + trace + " " + rowMismatch + " " + colMismatch);
		}
	}
}
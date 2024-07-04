import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int size;
		int[][] arr;
		ArrayList<Integer> check = new ArrayList();
		int rows;
		int columns;
		int trace;
		
		for (int i = 0; i < n; i++) {
			size = scanner.nextInt();
			
			arr = new int[size][size];
			rows = 0;
			columns = 0;
			trace = 0;
			
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					arr[j][k] = scanner.nextInt();
				}
			}
			
			for (int j = 0; j < size; j++) {
				trace += arr[j][j];
			}
			
			
			for (int j = 0; j < size; j++) {
				
				check.clear();
				
				for (int k = 0; k < size; k++) {
					
					for (int x : check) {
						if (arr[j][k] == x) {
							rows++;
							break;
						}
						check.add(arr[j][k]);
					}
					
					
				}
					
				
			}
			
			for (int k = 0; k < size; k++) {
				
				check.clear();
				
				for (int j = 0; j < size; j++) {
					
					for (int x : check) {
						if (arr[j][k] == x) {
							columns++;
							break;
						}
						check.add(arr[j][k]);
					}
					
					
				}
					
				
			}
			
			
			System.out.println("Case # " + (n + 1) + ": " + trace + " " + rows + " " + columns);
			
			
		}
		
	}

}

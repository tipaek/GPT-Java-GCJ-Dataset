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
		boolean repeat;
		
		for (int i = 0; i < n; i++) {
			//System.out.println("i: " + i);
			size = scanner.nextInt();
			//System.out.println("size: " + size);
			
			arr = new int[size][size];
			rows = 0;
			columns = 0;
			trace = 0;
			
			//System.out.println("Checkpoint #0.5");
			
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					arr[j][k] = scanner.nextInt();
				}
			}
			
			//System.out.println("Checkpoint #1");
			
			for (int j = 0; j < size; j++) {
				trace += arr[j][j];
			}
			
			//System.out.println("Checkpoint #2");
			
			for (int j = 0; j < size; j++) {
				
				check.clear();
				repeat = false;
				//System.out.println("new row");
				
				for (int k = 0; k < size; k++) {
					
					for (int x : check) {
						//System.out.println(x);
						if (arr[j][k] == x) {
							rows++;
							repeat = true;
							//System.out.println("break");
							break;
						}
					}
					
					if (repeat) break;
					check.add(arr[j][k]);
					
					
				}
					
				
			}
			
			//System.out.println("Checkpoint #3");
			
			for (int k = 0; k < size; k++) {
				
				check.clear();
				repeat = false;
				//System.out.println("new row");
				
				for (int j = 0; j < size; j++) {
					
					for (int x : check) {
						//System.out.println(x);
						if (arr[j][k] == x) {
							columns++;
							repeat = true;
							//System.out.println("break");
							break;
						}
					}
					
					if (repeat) break;
					check.add(arr[j][k]);
					
					
				}
					
				
			}
			
			//System.out.println("Checkpoint #4");
			System.out.println("Case # " + (i + 1) + ": " + trace + " " + rows + " " + columns);
			
			
		}
		
	}

}

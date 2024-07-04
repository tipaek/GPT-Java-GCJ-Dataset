import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc;

	public static void main(String[] args) throws IOException{
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//sc = new Scanner(new BufferedReader(new InputStreamReader(ves.txt)));
		
		
		int t = sc.nextInt(); 
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			
			int[][] array = new int[n][n];
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					array[row][col] = sc.nextInt();
				}
			}
			
			int trace = 0;
			for (int j = 0; j < n; j++) {
				trace = trace + array[j][j];
			}
			
			int reprows = 0;
			for (int row = 0; row < n; row++) {
				HashSet<Integer> hashset = new HashSet<Integer>();
		        for (int j = 0; j < n; j++) {
		        	if (hashset.contains(array[row][j])) {
		        		reprows++;
		        		break;
		        	}else {
		        		hashset.add(array[row][j]);
		        	}
		        }
			}
			int repcols = 0;
			for (int col = 0; col < n; col++) {
				HashSet<Integer> hashset = new HashSet<Integer>();
				for (int j = 0; j < n; j++) {
		        	if (hashset.contains(array[j][col])) {
		        		repcols++;
		        		break;
		        	}else {
		        		hashset.add(array[j][col]);
		        	}
		        }
			}
			System.out.println("Case #" + i + ": " + trace + " " + reprows + " " + repcols);
			
			
		}

	}
}

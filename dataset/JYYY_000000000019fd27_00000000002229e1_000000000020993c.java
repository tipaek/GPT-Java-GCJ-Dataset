import java.io.*;
import java.util.*;

public class P1 {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numMat = Integer.parseInt(br.readLine());
	  
		for (int n = 1; n <= numMat; n++) {
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split("\\s+");
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
				}
			}
			
	  
			int k = 0;
			int r = 0;
			int c = 0;
	  
			for (int i = 0; i < size; i++) {
				boolean repeat = false;
				Set<Integer> set = new HashSet<>();
				for (int j = 0; j < size; j++) {
					if (i == j) k += arr[i][j];
					if (set.contains(arr[i][j]) && !repeat) {
						r++;
						repeat = true;
					}
					set.add(arr[i][j]);
				}
			}
			for (int j = 0; j < size; j++) {
				boolean repeat = false;
				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < size; i++) {
					if (set.contains(arr[i][j]) && !repeat) {
						c++;
						repeat = true;
					}
					set.add(arr[i][j]);
				}
			}
	  
			System.out.println("Case #" + n + ": " + k + " " + r + " " + c);
		}
	}

}
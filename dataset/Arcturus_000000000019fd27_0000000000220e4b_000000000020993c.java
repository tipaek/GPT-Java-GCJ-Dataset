import java.util.*;
import java.io.*;

public class Vestigium {
	public static void vestigium(int caseNum, Scanner in) {
		int size = in.nextInt();
		
		int[][] array = new int[size][size];
		
		int trace = 0;
		int rows = 0;
		int cols = 0;
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < size; i++) {
			boolean unique = true;
			set.clear();
			for (int j = 0; j < size; j++) {
				int num = in.nextInt();
				
				if (i == j) {
					trace += num;
				}
				
				if(!set.contains(num)) {
					set.add(num);
				} else {
					unique = false;
				}
				
				array[i][j] = num;
			}
			
			if(!unique) {
				rows++;
			}
		}
		
		for (int i = 0; i < size; i++) {
			boolean unique = true;
			set.clear();
			for (int j = 0; j < size; j++) {
				if(!set.contains(array[j][i])) {
					set.add(array[j][i]);
				} else {
					unique = false;
				}
			}
			
			if(!unique) {
				cols++;
			}
		}
		
		System.out.println("Case #" + caseNum +": " + trace + " " + rows + " " + cols);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = in.nextInt(); 
	    for (int i = 1; i <= cases; i++) {
	    	vestigium(i, in);
	    }
	    in.close();
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static List<Integer> retrunesums(int[][] square){
		List<Integer> as = new ArrayList<Integer>();
		
		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
		
		int rowDup = 0;
		int coldup = 0;
		int trace = 0;
		
		for(int i =0;i < square.length; i++) {
			trace = trace + square[i][i];
			for(int j=0; j < square.length; j++) {
				if(temp.containsKey(square[i][j])) {
					rowDup = rowDup + 1;
					break;
				}else {
					temp.put(square[i][j], rowDup);
				}
				
			}temp.clear();
			
		}
		
		for(int i =0;i < square.length; i++) {
			for(int j=0; j < square.length; j++) {
				if(temp.containsKey(square[j][i])) {
					coldup = coldup + 1;
					break;
				}else {
					temp.put(square[j][i], coldup);
				}
				
			}temp.clear();
			
		}
		
		as.add(trace);
		as.add(rowDup);
		as.add(coldup);
		return as;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int l = 1;l <= t; ++l) {
			int sqsixze = in.nextInt();
			int[][] matrix = new int[sqsixze][sqsixze];
			for(int h=0; h < sqsixze; h++) {
				for(int v = 0; v < sqsixze; v++) {
					matrix[h][v] = in.nextInt();
				}
			}List<Integer> out = retrunesums(matrix);
			
			System.out.println("Case #" + l + ": " + out.get(0) + " " + out.get(1) + " " + out.get(2));
		}
		
	
		
	}

}
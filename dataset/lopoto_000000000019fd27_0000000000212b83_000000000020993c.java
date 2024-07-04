import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static int k = 0;
	public static int r = 0;
	public static int c = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		boolean keepCalculate = true;
		
		for (int i = 0; i < T; i++) {
			Solution.resetValues();
			int N = in.nextInt();
			List<List<Integer>> M = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				set.clear();
				keepCalculate = true;
				List<Integer> tmp = new ArrayList<Integer>();
				
				for (int p = 0; p < N; p++) {
					int value = in.nextInt();
					
					tmp.add(value);
					
					if (j == p) {
						Solution.k += value;
					}
					
					if (keepCalculate && set.contains(value)) {
						Solution.r++;
						keepCalculate = false;
					} else {
						set.add(value);
					}
				}
				
				M.add(tmp);
			}
			
			for (int z = 0; z < N; z++) {
				set.clear();
				
				for (int p = 0; p < N; p++) {
					if (set.contains(M.get(p).get(z))) {
						Solution.c++;
						break;
					} else {
						set.add(M.get(p).get(z));
					}
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + Solution.k + " " + Solution.r + " " + Solution.c);
		}
		
	}
	
	public static void resetValues() {
		Solution.k = 0;
		Solution.r = 0;
		Solution.c = 0;
	}

}

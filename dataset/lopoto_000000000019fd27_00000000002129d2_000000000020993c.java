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
		
		for (int i = 0; i < T; i++) {
			Solution.resetValues();
			int N = in.nextInt();
			List<List<Integer>> M = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				List<Integer> tmp = new ArrayList<Integer>();
				
				for (int p = 0; p < N; p++) {
					int value = in.nextInt();
					
					tmp.add(value);
					
					if (j == p) {
						Solution.k += value;
					}
				}
				
				M.add(tmp);
			}
			
			Solution.solution(i, N, M);
		}
		
	}

	public static void solution(int w, int N, List<List<Integer>> M) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < N; i++) {
			set.clear();
			
			for (int p = 0; p < N; p++) {
				if (set.contains(M.get(i).get(p))) {
					Solution.r++;
					break;
				} else {
					set.add(M.get(i).get(p));
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			set.clear();
			
			for (int p = 0; p < N; p++) {
				if (set.contains(M.get(p).get(i))) {
					Solution.c++;
					break;
				} else {
					set.add(M.get(p).get(i));
				}
			}
		}
		
		System.out.println("Case #" + (w + 1) + ": " + Solution.k + " " + Solution.r + " " + Solution.c);
	}
	
	public static void resetValues() {
		Solution.k = 0;
		Solution.r = 0;
		Solution.c = 0;
	}

}

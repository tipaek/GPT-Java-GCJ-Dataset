import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < testCases; ++i) {
			processInput(i + 1);
		}
	}
	
	public static void printResult(int current, List<List<Integer>> result) {
		String val = result == null? "IMPOSSIBLE" : "POSSIBLE";
		System.out.println("Case #" + current + ": " + val);
		if (result != null) {
			for (int i = 0; i < result.size(); ++i) {
				for (int j = 0; j < result.size(); ++j) {
					System.out.print(result.get(i).get(j));
					if (j != result.size() - 1)
						System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void processInput(int testCase) {
		String s = in.nextLine();
		
		String [] line = s.split(" ");
		
		int N = Integer.parseInt(line[0]);
		int T = Integer.parseInt(line[1]);
		solve(N, T, testCase);
	}
	
	public static void solve(int N, int T, int testCase) {
		List<List<Integer>> result = null;
		int [] diag = new int [N];
		
		if (N == 2) {
			if (T == 4)
				result = Arrays.asList( Arrays.asList(2,1), Arrays.asList(1,2) );
			if (T == 2)
				result = Arrays.asList( Arrays.asList(1,2), Arrays.asList(2,1) );
			printResult(testCase, result);
			return;
		}
		if (N == 3) {
			if (T == 3) {
				result = Arrays.asList( Arrays.asList(1,2,3), Arrays.asList(3,1,2) , Arrays.asList(2,3,1) );
			}
			if (T == 6) {
				result = Arrays.asList( Arrays.asList(2,1,3), Arrays.asList(3,1,2) , Arrays.asList(1,3,2) );
			}
			if (T == 9) {
				result = Arrays.asList( Arrays.asList(3,1,2), Arrays.asList(2,3,1) , Arrays.asList(1,2,3) );
			}
			printResult(testCase, result);
			return;
		}
		
		if (T < N || T > N*N || T == N*N - 1 || T == N + 1 || (N % 2 == 1 && (T == N + 2 || T == N*N - 2) )) {
			printResult(testCase, null);
			return;
		}
		
		if (N == 4 && T == 10 ) {
			diag[0] = 2;
			diag[1] = 2;
			diag[2] = 3;
			diag[3] = 3;
		}
		else if (T == N + 2) {
			for (int i = 0; i < diag.length - 2; ++i) {
				diag[i] = 1;
			}
			diag[diag.length - 1] = 2;
			diag[diag.length - 2] = 2;
		} else if (T == N*N - 2) {
			for (int i = 0; i < diag.length - 2; ++i) {
				diag[i] = N;
			}
			diag[diag.length - 1] = N - 1;
			diag[diag.length - 2] = N - 1;
		} else if (T % N != 0) {
			int reference = T / N - 1;
			if (reference < 1)
				reference = 1;
			int remainder, diff1 = 0,diff2 = 0;
			while (reference <= N) {
				remainder = T - N * reference;
				if (remainder == 1 || remainder == 2 || remainder == -1 || remainder == -2) {
					++reference;
					continue;
				}
				if (remainder/2 < N - reference) {
					diff1 = remainder/2 + 1;
					diff2 = remainder % 2 == 0? remainder/2 - 1 : remainder/2;
					if (remainder < 0 && remainder % 2 != 0) {
						diff1 -= 1;
						diff2 -= 1;
					}
					break;
				}
				reference++;
			}
			
			if (reference > N) {
				printResult(testCase, null);
				return;
			}
			
			for (int i = 0; i < diag.length - 2; ++i) {
				diag[i] = reference;
			}
			diag[diag.length - 1] = reference + diff1;
			diag[diag.length - 2] = reference + diff2;	
		} else {
			for (int i = 0; i < diag.length; ++i) {
				diag[i] = T / N;
			}
		}
		
		result = helper(diag, T);
		
		printResult(testCase, result);
		
	}
	
	public static List<List<Integer>> helper(int [] diag, int T) {
		Set<Integer> diagonals = new HashSet<>();
		Set<Integer> added = new HashSet<>();
		int swap = 0;
		int [] map = new int [diag.length];
		
		for (int d : diag)
			diagonals.add(d);
		List<List<Integer>> matrix = new ArrayList<>(diag.length);
		
		for(int i = 0; i < diag.length; ++i) {
			List<Integer> element = new ArrayList<>(diag.length);
			for(int j = 0; j < diag.length; ++j) {
				element.add((j - i + diag.length) % diag.length);
			}
			matrix.add(element);
		}
		
		/*for (int i = 0; i < matrix.size(); ++i) {
			for (int j = 0; j < matrix.size(); ++j) {
				System.out.print(matrix.get(i).get(j));
				if (j != matrix.size() - 1)
					System.out.print(" ");
			}
			System.out.println();
		}*/
		map[0] = diag[0];
		added.add(diag[0]);
		
		if (diagonals.size() == 3) {
			map[1] = diag[diag.length - 2];
			map[map.length - 1] = diag[diag.length - 1];
			swap = 1;
			added.add(diag[diag.length - 2]);
			added.add(diag[diag.length - 1]);
		} 
		if (diagonals.size() == 2) {
			map[diag.length/2] = diag[diag.length - 1];
			added.add(diag[diag.length - 1]);
			swap = diag.length/2;
		}
		List<Integer> swapper = matrix.get(0);
		matrix.set(0, matrix.get(swap));
		matrix.set(swap, swapper);
		
		/*for (int i = 0; i < matrix.size(); ++i) {
			for (int j = 0; j < matrix.size(); ++j) {
				System.out.print(matrix.get(i).get(j));
				if (j != matrix.size() - 1)
					System.out.print(" ");
			}
			System.out.println();
		}*/
		
		for (int i = 0, j = 1; i < map.length; ++i ) {
			if (map[i] != 0)
				continue;
			while (added.contains(j))
				++j;
			
			map[i] = j;
			++j;
		}
		
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map.length; ++j) {
				matrix.get(i).set(j, map[matrix.get(i).get(j)]);
			}
		}
		
		return matrix;
		
	}


}

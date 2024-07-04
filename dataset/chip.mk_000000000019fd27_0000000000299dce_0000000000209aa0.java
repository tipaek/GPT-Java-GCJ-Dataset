import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] order;
	static ArrayList<Integer[]> permutations = new ArrayList<>();
	
	public static void main(String[] args) {
		try (
			//BufferedReader ibr = new BufferedReader(new FileReader("D:/codejam_in.txt"));
			BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(ibr)
			)
		{
			sc.useLocale(new Locale("US"));
			int parT = sc.nextInt();
			
			for (int t = 1; t <= parT; t++) {

				int n = sc.nextInt();
				int k = sc.nextInt();
				
				Integer[] lst = new Integer[n], tmpLst = new Integer[n];
				for (int i = 0; i < n; i++) lst[i] = i;
				permute(lst, permutations, tmpLst, 0, false);
				
				String answer = "IMPOSSIBLE";
				
				if (n <= 5) {
					order = new int[n];
					int[][] mat = see(0, n, k);
					if (mat != null) {
						StringBuilder sb = new StringBuilder();
						sb.append("POSSIBLE\n");
						for (int i = 0; i < n; i++)
							for (int j = 0; j < n; j++) {
								sb.append(mat[i][j]);
								if (j < n - 1) sb.append(" ");
								else sb.append("\n");
							}
						answer = sb.toString();
					}
				}
				
				System.out.println(String.format("Case #%s: %s ", t, answer));
				System.out.flush();

			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	static int[][] see(int level, int n, int k) {
		int[][] mat = null;
		if (level < n) {
			for (int i = 0; i < n; i++) {
				boolean used = false;
				for (int j = 0; j < level; j++) {
					if (order[j] == i) {
						used = true;
						break;
					}
				}
				if (!used) {
					order[level] = i;
					mat = see(level + 1, n, k);
					if (mat != null) break;
				}
			}
		} else {
			
			for (Integer[] p : permutations) {
				Integer sum = 0;
				for (int i = 0; i < n; i++) {
					sum += p[(n - order[i] + i) % n ] + 1;
				}
				
				if (sum == k) {
					mat = new int[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							mat[i][j] = p[(n - order[i] + j) % n] + 1;
						}
					}
				}
			}
		}
		
		return mat;
	}
	
	static <T> void permute(T[] elements, List<T[]> permutations, T[] permutation, int level, boolean noDuplicates) {
		HashSet<T> usedElements = noDuplicates ? new HashSet<T>() : null;
		if (level < permutation.length) {
			for (int i = 0; i < elements.length; i++) {
				T tmp = elements[i];			
				if (tmp != null) {
					if (usedElements != null) {
						if (usedElements.contains(tmp)) continue;
						else usedElements.add(tmp);
					}
					T[] newPerm = permutation.clone();
					newPerm[level] = tmp;
					//permutations.add(newPerm);
					elements[i] = null;
					permute(elements, permutations, newPerm, level + 1, noDuplicates);
					elements[i] = tmp;
				}
			}
		} else {
			permutations.add(permutation);
		}
	}
}

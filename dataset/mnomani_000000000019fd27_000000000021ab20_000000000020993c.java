import java.util.*;

public class Solution {

	static boolean hasDuplicate(int[] items) {
		  Set<Integer> appeared = new HashSet<>();
		  for (int item : items) {
		    if (!appeared.add(item)) {
		      return true;
		    }
		  }
		  return false;
		}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);	
		int t = sc.nextInt();
		
		int count = 1;
		for(; t > 0; t--) {
			int n = sc.nextInt();
			
			int k = 0;
			int[][] matrix = new int[n][n];
			int[][] matrixInv = new int[n][n];
			int rsame = 0;
			int csame = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int a = sc.nextInt();
					if(i == j)
						k += a;
					matrix[i][j] = a;
					matrixInv[j][i] = a;
				}
			}
			
			for(int[] a : matrix) {
				if(hasDuplicate(a))
					rsame++;
			}
			
			for(int[] a : matrixInv) {
				if(hasDuplicate(a))
					csame++;
			}
			
			System.out.println("Case #" + count + ": " + k + " " + rsame + " " + csame );
			count++;
		}
	}

}

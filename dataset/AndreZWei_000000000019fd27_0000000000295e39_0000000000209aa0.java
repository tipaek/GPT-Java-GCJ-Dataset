import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      int k = in.nextInt();
	      System.out.println("Case #" + i + ": " + solve(n, k));
	    }
  	}

  	public static String solve(int n, int k){
  		int[][] square = new int[n][n];
  		Integer[] dias = new Integer[3];
  		// type 1: keep the matrix
  		// type 2: Special
  		// type 3: swap the last two row
  		int type = 1;
  		if (k % n == 0) {
  			dias[0] = k / n;
  		} else {
  			type = 2;
  			if (n == 2 || n == 3) return "IMPOSSIBLE";
  			if (k == n + 1 || k == n * n - 1) return "IMPOSSIBLE";
  			int a = k / n;
  			int b = k % n;
  			if (k < 2 * n - 2) {
  				dias[0] = 1;
  				dias[1] = (k - n + 2) / 2;
  				if (k-n+2-dias[1] != dias[1]) {
  					type = 3;
  					dias[2] = k-n+2-dias[1];
  				}
  			} else if (b == n-1) {
  				if ((2*a+b) / 2 < n && (2*a+b) / 2 > 0) {
					dias[0] = a;
	  				dias[1] = (2*a+b) / 2;
	  				if (2*a+b-dias[1] != dias[1]) {
	  					type = 3;
	  					dias[2] = 2*a+b-dias[1];
	  				}
  				} else {
  					dias[0] = a+2;
  					dias[1] = (k - (a+2)*(n-2)) / 2;
  					if (k - (a+2)*(n-2)-dias[1] != dias[1]) {
	  					type = 3;
	  					dias[2] = k - (a+2)*(n-2)-dias[1];
	  				}
  				}
  				
  			} else {
  				if ((k - (a+1) * (n-2)) / 2 > 0) {
  					dias[0] = a+1;
	  				dias[1] = (k - (a+1) * (n-2)) / 2;
	  				if (k - (a+1)*(n-2) - dias[1] != dias[1]) {
	  					type = 3;
	  					dias[2] = k - (a+1)*(n-2) - dias[1];
	  				}
  				} else {
  					dias[0] = a-1;
  					dias[1] = (k - (a-1) * (n-2)) / 2;
  					if (k - (a-1)*(n-2) - dias[1] != dias[1]) {
	  					type = 3;
	  					dias[2] = k - (a-1)*(n-2) - dias[1];
	  				}
  				}
  				
  			}
  		}

  		List<Integer> list = new ArrayList<>();
  		Set<Integer> set = new HashSet<>();
  		for (int i = 0; i < 3; i++) {
  			if (dias[i] != null) {
  				list.add(dias[i]);
  				if (dias[i] == n) {
  					set.add(0);
  				} else {
  					set.add(dias[i]);
  				}
  			}
  		}
  		int cur = list.get(list.size()-1);
		while (list.size() < n) {
			while (set.contains(cur % n)) cur++;
			if (cur % n == 0) {
				set.add(0);
				list.add(n);
			} else {
				set.add(cur % n);
				list.add(cur % n);
			}
		}

		// swap pos 0 and pos 1, and we start building from index 1
		int temp = list.get(0);
		list.set(0, list.get(1));
		list.set(1, temp);

		switch (type) {
			case 1:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						square[i][j] = list.get((n+1+j-i) % n);
					}
				}
				break;
			case 2:
				for (int i = 0; i < n-2; i++) {
					square[i][i] = list.get(1);
					square[i][(i+1)%(n-2)] = list.get(0);
					int curCol = i+2;
					for (int cnt = 0; cnt < n-2; cnt++) {
						while (square[i][curCol%n] != 0) curCol++;
						square[i][curCol%n] = list.get(cnt+2);
					}
				}
				for (int i = n-2; i < n; i++) square[i][i] = list.get(0);
				square[n-1][n-2] = list.get(1);
				square[n-2][n-1] = list.get(1);

				Set<Integer> row2 = new HashSet<Integer>();
				Set<Integer> row1 = new HashSet<Integer>();
				for (int i = 2; i < n; i++) {
					row2.add(list.get(i));
					row1.add(list.get(i));
				}

				for (int j = 0; j < n-2; j++) {
					Set<Integer> col = new HashSet<>();
					for (int m = 2; m < n; m++) col.add(list.get(m));
					for (int m = 0; m < n-2; m++) col.remove(square[m][j]);
					List<Integer> colList = new ArrayList<>(col);
					if (j == 0) {
						int num = colList.get(0);
						square[n-2][0] = num;
						row2.remove(num);
						num = colList.get(1);
						square[n-1][0] = num;
						row1.remove(num);
					} else {
						int[] count = new int[2];
						for (int i = 0; i < 2; i++) {
							if (row1.contains(colList.get(i))) count[i]++;
							if (row2.contains(colList.get(i))) count[i]++;
						}
						if (count[0] == 1) {
							if (row1.contains(colList.get(0))) {
								square[n-1][j] = colList.get(0);
								square[n-2][j] = colList.get(1);
								row1.remove(colList.get(0));
								row2.remove(colList.get(1));
							} else {
								square[n-2][j] = colList.get(0);
								square[n-1][j] = colList.get(1);
								row2.remove(colList.get(0));
								row1.remove(colList.get(1));
							}
						} else {
							if (row1.contains(colList.get(1))) {
								square[n-1][j] = colList.get(1);
								square[n-2][j] = colList.get(0);
								row2.remove(colList.get(0));
								row1.remove(colList.get(1));
							} else {
								square[n-2][j] = colList.get(1);
								square[n-1][j] = colList.get(0);
								row1.remove(colList.get(0));
								row2.remove(colList.get(1));
							}
						}
					}
				}
				break;
			case 3:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						square[i][j] = list.get((n+1+j-i) % n);
					}
				}
				int[] t = square[n-2];
				square[n-2] = square[n-1];
				square[n-1] = t;
				break;

		}

  		return printSquare(square);
		
  	}

  	private static String printSquare(int[][] square) {
  		StringBuilder sb = new StringBuilder();
  		sb.append("POSSIBLE\n");
  		for (int i = 0; i < square.length; i++) {
  			for (int j = 0; j < square.length; j++) {
  				sb.append(square[i][j]);
  				if (j != square.length-1) sb.append(" ");
  			}
  			if (i != square.length-1) sb.append("\n");
  		}
  		return sb.toString();
  	}
}

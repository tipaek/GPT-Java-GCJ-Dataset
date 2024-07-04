import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Vestigium {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=t;test++) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[n][n];
			for(int line=0;line<n;line++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for(int i=0;i<n;i++) {
					a[line][i] = Integer.parseInt(stk.nextToken());
				}				
			}
			
			int trace = getTrace(a);
			int numRowWithDup = rowsWithDup(a);
			int numColWithDup = colsWithDup(a);
			
			System.out.printf("Case #%d: %d %d %d\n",test,trace,numRowWithDup,numColWithDup);
		}

	}

	private static int colsWithDup(int[][] a) {
		int n = a.length;
		int colCount = 0;
		for(int j=0;j<n;j++) {
			Set<Integer> h = new HashSet<>();
			for(int i=0;i<n;i++) {
				if(!h.contains(a[i][j])) {
					h.add(a[i][j]);
				} else {
					colCount++;
					break;
				}
			}
		}
		return colCount;
	}

	private static int rowsWithDup(int[][] a) {
		int n = a.length;
		int rowCount = 0;
		for(int i=0;i<n;i++) {
			Set<Integer> h = new HashSet<>();
			for(int j=0;j<n;j++) {
				if(!h.contains(a[i][j])) {
					h.add(a[i][j]);
				} else {
					rowCount++;
					break;
				}
			}			
		}
		return rowCount;
	}

	private static int getTrace(int[][] a) {
		int sum = 0, r = a.length;		
		for(int i=0;i<r;i++) {
			sum += a[i][i];
		}
		return sum;
	}

}

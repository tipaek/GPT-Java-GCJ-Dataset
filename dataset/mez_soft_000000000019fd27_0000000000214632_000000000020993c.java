import java.util.*;


public class Solution {
	private static int t;
	private static int n;
	private static int trace(Scanner input,int n,int [][] m) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = input.nextInt();
				if(i == j) s+= m[i][j];
			}
		}
		return s;
	}
	
	private static int row(int x, int [][] m) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int r = 0;
		for (int i = 0; i < n; i++) {
			l.add(m[i][0]);
			for (int j = 1; j < n; j++) {
				if(l.contains(m[i][j])) {
					r++;
					break;
				}else l.add(m[i][j]);
			}
			l.clear();
		}
		return r;
	}
	
	private static int column(int x,int [][] m) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		int c = 0;
		for (int i = 0; i < n; i++) {
			l.add(m[0][i]);
			for (int j = 1; j < n; j++) {
				if(l.contains(m[j][i])) {
					c++;
					break;
				}else l.add(m[j][i]);
			}
			l.clear();
		}
		return c;
	}
	
	public static void main(String[] args) {
		int x = 0;
		Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 1;i <= t;i++) {
        	n = input.nextInt();
        	int[][] m = new int[n][n];
        	for (int j = 1; j <= n; j++) x+=j;
            System.out.println(String.format("Case #%d: %d %d %d", i, trace(input,n,m),row(x,m),column(x,m)));
        }
		
	}
}
   
 
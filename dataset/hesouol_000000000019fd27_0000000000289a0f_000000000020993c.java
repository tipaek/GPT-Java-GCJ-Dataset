import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int t1=0; t1<t; t1++) {
			int n = in.nextInt();
			long[][] m = new long[n][n];
			
			for(int i=0; i<n;i++) {
				for(int j=0; j<n; j++) {
					m[i][j]=in.nextLong();
				}
			}
			
			System.out.format("Case #%d: %d %d %d\n",t1+1, getTrace(m), getColumns(m), getLines(m));
		}
		in.close();
	}
	
	
	public static long getTrace(long[][] m) {
		long sum=0;
		for(int i=0; i<m.length; i++) {
			sum+=m[i][i];
		}
		
		return sum;
	}
	
	public static int getColumns(long[][] m) {
		int sum = 0;
		
		for(int i=0; i<m.length;i++) {
			HashSet<Long> hashColumns = new HashSet<>();
			for(int j=0; j<m.length; j++) {
				if(hashColumns.contains(m[i][j])) {
					sum++;
					break;
				}
				hashColumns.add(m[i][j]);
			}
		}
		return sum;
	}
	
	public static int getLines(long[][] m) {
		int sum = 0;
		
		for(int i=0; i<m.length;i++) {
			HashSet<Long> hash= new HashSet<>();
			for(int j=0; j<m.length; j++) {
				if(hash.contains(m[j][i])) {
					sum++;
					break;
				}
				hash.add(m[j][i]);
			}
		}
		return sum;
	}

	
	
}




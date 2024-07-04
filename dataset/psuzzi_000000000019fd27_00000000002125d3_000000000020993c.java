import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//scan("problem/qual.p1/input1.txt", in -> {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				int [][] m = new int [n][n];
				for(int r=0; r<n; r++) {
					for(int c=0; c<n; c++) {
						m[r][c] = in.nextInt(); 
					}
				}
				
				System.out.println("Case #" + i + ": " + solve(n,m) );
			}
		//});
		in.close();
	}

	private static String solve(int n, int[][] m) {
		int k = 0, nr = 0, nc = 0, sum = 0;
		
		for(int i=1; i<=n; i++)
			sum += i;
		 
		Set<Integer> rs = new HashSet<>();
		for(int r=0; r<n; r++) {
			rs.clear();
			for(int c=0; c<n; c++) {
				int v = m[r][c];
				if(r==c) {
					k += v;
				}
				rs.add(v);
			}
			if(rs.size()!=n) {
				nr++;
			}
		}
		
		for(int c=0; c<n; c++) {
			rs.clear();
			for(int r=0; r<n; r++) {
				int v = m[r][c];
				rs.add(v);
			}
			if(rs.size()!=n) {
				nc++;
			}
		}
		
		return String.format("%s %s %s", k, nr, nc);
	}

	static void scan(String filename, Consumer<Scanner> consumer) {
		try (Scanner sc = new Scanner(new File(filename))) {
			consumer.accept(sc);
		} catch (FileNotFoundException e) {
			System.err.printf("Error scanning %s", filename);
			e.printStackTrace();
		}
	}

}
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		for(int test = 1; test <= Q; test ++){
			System.out.printf("Case #%d: ", test);
			
			solve(in);
			
			System.out.println();
		}
	}
	
	public static void solve(Scanner in) {
		
		int U = in.nextInt();
		//Entry[] entries = new Entry[10000];
		Set<Entry> entries = new TreeSet<Entry>();
		
		int k = 0;
		int queries = 10000;
		for(int i = 0; i < queries; i ++) {	
			long M = in.nextLong();
			String R = in.next();
			//if(R.length() == cntDec(M))
				entries.add(new Entry(M,R));
		}		
		int remaining = 10;
		char[] result = new char[10];
		int[] mapping = new int[30];
		for(int i = 0; i < 30 ; i++)
			mapping[i] = -1;
		while(remaining > 0) {
			for(Entry e : entries) {
			//	System.out.println(e);
				long M = e.M;
				String R = e.R;
				long powTen = (long) Math.pow(10, R.length());
				M = M % powTen;
				boolean ok = false;
				if(R.length() != cntDec(M))
					ok = true;
				for(int i = 0; i < R.length(); i ++) {
					int lwBound = (i == 0 && R.length() == cntDec(M)) ? 1 : 0;
					char C = R.charAt(i);
					powTen /= 10;
					if(mapping[C-'A'] == -1) {
						int upperBound = ok ? 9 : (int) (M / powTen);
						int possibleMap = -1;
						for(int j = lwBound; j <= upperBound; j ++) {
							if(result[j] == 0) {
								if(possibleMap == -1)
									possibleMap = j;
								else {
									possibleMap = -1;
									break;
								}
							}
						}
						if(possibleMap != -1) {
							mapping[C-'A'] = possibleMap;
							result[possibleMap] = C;
							remaining--;
						}
						ok = true;
					}
					M = M % powTen;
				}
			}
		}
		System.out.println(result);
		
	}
	
	public static int cntDec(long X) {
		int cnt = 1;
		X/=10;
		while(X > 0) {
			cnt++;
			X/=10;
		}
		return cnt;
	}

}

class Entry implements Comparable<Entry>{
	long M;
	String R;
	Entry(long M, String R){
		this.M = M;
		this.R = R;
	}
	
	public int compareTo(Entry o) {
		if(this.M == o.M) return this.R.compareTo(o.R);
		return this.M < o.M ? -1 : this.M > o.M ? 1 : 0;
	}
	
	public String toString() {
		return "" + M + " " + R;
	}
}
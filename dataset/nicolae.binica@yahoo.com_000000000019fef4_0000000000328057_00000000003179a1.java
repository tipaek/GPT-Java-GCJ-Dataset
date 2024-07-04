import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		for(int test = 1; test <= Q; test ++){
			System.out.printf("Case #%d: ", test);
			
			solve1(in);
			
			System.out.println();
		}
	}
	

	public static void solve1(Scanner in) {
		
		int U = in.nextInt();
		//Entry[] entries = new Entry[10000];
		Map<Character,Integer> entries = new TreeMap<Character,Integer>();
		
		int k = 0;
		char[] result = new char[10];
		int queries = 10000;
		char lastC = 'A';
		for(int i = 0; i < queries; i ++) {	
			long M = in.nextLong();
			String R = in.next();
			char C = R.charAt(0);
			int value = 1;
			if(!(entries.get(C) == null)) 
				value = entries.get(C) + 1;
			for(int j = 0; j < R.length(); j ++)
				if(entries.get(R.charAt(j)) == null)
					lastC = R.charAt(j);
			entries.put(C,value);
		}
		LetterPair[] letters = new LetterPair[10];
		for(char res : entries.keySet()) {
			letters[k++] = new LetterPair(res, entries.get(res));
		}
		letters[k] = new LetterPair(lastC, Integer.MAX_VALUE);
		Arrays.sort(letters);
		k = 0;
		for(int i = 0 ; i < 10; i ++)
			result[i] = letters[i].C;
		
		System.out.println(result);
		
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
				boolean ok = false; /// Always take upperbound 9
				if(R.length() != cntDec(M))
					ok = true;
				for(int i = 0; i < R.length(); i ++) {
					int lwBound = (i==0) ? 1 : 0;
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
						ok = ok ? true : !(possibleMap == (M / powTen));
						if(possibleMap != -1) {
							mapping[C-'A'] = possibleMap;
							result[possibleMap] = C;
							remaining--;
						}
					}
					else if(!ok && mapping[C-'A'] != M / powTen)
						ok = true;
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


class LetterPair implements Comparable<LetterPair>{
	char C;
	int value;
	LetterPair(char C, int value){
		this.C = C;
		this.value = value;
	}
	
	public int compareTo(LetterPair o) {
		//if(this.value == o.value) return this.C < o.C ? -1 : 1;
		if(this == null) return -1;
		if(o == null) return -1;
		return this.value < o.value ? 1 : -1 ;//this.value > o.value ? -1 : 0;
	}
	
	public String toString() {
		return "" + C + " " + value;
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
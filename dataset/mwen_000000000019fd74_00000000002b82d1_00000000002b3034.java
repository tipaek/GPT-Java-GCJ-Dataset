import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			int n = file.nextInt();
			S[] patterns = new S[n];
			for(int j = 0; j < n; j++) {
				patterns[j] = new S(file.next());
			}
			Arrays.sort(patterns);
			boolean possible = true;
			A: for(int j = 0; j < n; j++) {
				String end = patterns[j].pat.substring(1);
				for(int h = j+1; h < n; h++) {
					if(!patterns[h].pat.endsWith(end)) {
						possible = false;
						break A;
					}
				}
			}
			System.out.println("Case #" + i + ": " + (possible ? patterns[n-1].pat.substring(1) : '*'));
		}
		file.close();
	}

}

class S implements Comparable<S> {
	String pat;
	public S(String p) {
		pat = p;
	}
	public int compareTo(S s) {
		return pat.length() - s.pat.length();
	}
	public String toString() {
		return pat;
	}
}

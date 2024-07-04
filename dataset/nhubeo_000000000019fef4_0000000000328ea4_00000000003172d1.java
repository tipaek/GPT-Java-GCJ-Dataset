import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i=0; i<testCase; i++) {
			System.out.println("Case #" + (i+1) + ": " + solution(sc));
		}
	}

	private static int solution(Scanner sc) {
		int s = sc.nextInt();
		int g = sc.nextInt();
		
		
			
		long[] c = new long[s];
		for (int i=0; i<s; i++) {
			c[i] = sc.nextLong();
		}
		
		if (s == 1 || g == 1) {
			//sc.nextInt();
			return g-1;
		}
		
		Arrays.sort(c);
		
		int numEquals = 0;
		
		for (int i=0; i<s; i++) {
			int equal = 0;
			for (int j=i+1; j<s; j++) {
				if (c[i] == c[j]) {
					equal++;
					if (g==2) {
						return 0;
					}
					for (int k=j+1; k<s; k++) {
						if (c[k] == c[j]) {
							equal++;
							if (g==3) {
								return 0;
							}
						}
					}
				}
			}
			numEquals = Math.max(numEquals, equal);
		}
		
		if (g == 2) {
			return 1;
		}
		
		for (int i=0; i<s; i++) {
			for (int j=i+1; j<s; j++) {
				if (c[i] == c[j]) {
					if (j<s-1) {
						return 1;
					}
				}
				if (c[j] == 2*c[i]) {
					return 1;
				}
			}
		}
		return 2;
	}
	
	
}

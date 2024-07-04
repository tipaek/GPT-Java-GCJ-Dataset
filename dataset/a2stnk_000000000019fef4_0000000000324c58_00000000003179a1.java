import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}
	
	static void solve(Scanner sc) {
		
		int U = sc.nextInt();
		final int N = 10000;
		char[][] R = new char[N][];
		
		int[] count = new int[26];
		HashSet<Character> letters = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			String Q = sc.next();
			R[i] = sc.next().toCharArray();
			count[R[i][0]-'A']++;
			for(char c : R[i]) {
				letters.add(c);
			}
		}
		
		String ans = "";
		for(int i=1; i<=9; i++) {
			int maxIndex = 0;
			for(int j=1; j<26; j++) {
				if(count[j]>count[maxIndex]) {
					maxIndex = j;
				}
			}
			ans += Character.valueOf((char)('A'+maxIndex));
			count[maxIndex]=0;
			letters.remove((char)('A'+maxIndex));
		}
		Iterator<Character> it = letters.iterator();
		char zero = it.next();
		ans = String.valueOf(zero) + ans;
		
		System.out.println(ans);
	}

}

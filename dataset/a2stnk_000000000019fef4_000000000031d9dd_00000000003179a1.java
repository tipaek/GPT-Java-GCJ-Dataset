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
		char[][] Q = new char[N][];
		char[][] R = new char[N][];
		
		int[][] count = new int[10][26];
		HashSet<Character> letters = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			Q[i] = sc.next().toCharArray();
			R[i] = sc.next().toCharArray();
			if(Q[i].length == R[i].length) {
				count[Q[i][0]-'0'][R[i][0]-'A']++;
			}
			for(char c : R[i]) {
				letters.add(c);
			}
		}
		
		String ans = "";
		for(int i=1; i<=9; i++) {
			for(int j=0; j<26; j++) {
				if(count[i][j]>0) {
					ans += Character.valueOf((char)('A'+j));
					for(int k=i+1; k<=9; k++) {
						count[k][j]=0;
					}
					letters.remove((char)('A'+j));
					break;
				}
			}
		}
		Iterator<Character> it = letters.iterator();
		char zero = it.next();
		ans = String.valueOf(zero) + ans;
		
		System.out.println(ans);
	}

}

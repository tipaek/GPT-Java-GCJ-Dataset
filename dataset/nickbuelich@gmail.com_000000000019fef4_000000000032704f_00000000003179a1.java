import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	static int N = 10000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long L = sc.nextLong();
			long[] V = new long[N];
			String[] S = new String[N];
			int[] map = new int[26];
			HashSet<Character> all = new HashSet<Character>();
			for(int a=0;a<N;a++){
				V[a] = sc.nextLong();
				if(V[a]==-1L)System.exit(1);
				S[a] = sc.next();
				for(int b=0;b<S[a].length();b++){
					all.add(S[a].charAt(b));
				}
			}
			TreeSet<Character> possible[] = new TreeSet[10];
			for(int a=0;a<10;a++)possible[a]=new TreeSet<Character>(all);
			
			for(int a=0;a<N;a++){
				String test = V[a]+"";
				if(test.length()==S[a].length()){
			//		System.out.println(V[a]+" "+S[a]);
					possible[0].remove(S[a].charAt(0));
					int v = test.charAt(0)-'0';
					for(int xx=v+1;xx<=9;xx++)possible[xx].remove(S[a].charAt(0));
				}
			}
			
			
			HashSet<Character> used = new HashSet<Character>();
			char[] answer = new char[10];
			answer[0] = possible[0].first();
			used.add(answer[0]);
			
			for(int a=9;a>=1;a--){
				possible[a].removeAll(used);
				answer[a]=possible[a].first();
				used.add(answer[a]);
			}
							
			System.out.printf("Case #%d: %s%n", t, String.valueOf(answer));
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int N = 10000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int L = sc.nextInt();
			long[] V = new long[N];
			String[] S = new String[N];
			String answer = "";
			int[] map = new int[26];
			HashSet<Character> possible = new HashSet<Character>();
			for(int a=0;a<N;a++){
				V[a]=sc.nextLong();
				S[a]=sc.next();
				for(int b=0;b<=0;b++){
					map[S[a].charAt(b)-'A']++;
				}
				for(int b=0;b<S[a].length();b++){
					possible.add(S[a].charAt(b));					
				}
			}
			
			PriorityQueue<Pair> PQ = new PriorityQueue<Pair>();
			for(int a=0;a<26;a++){
				if(possible.contains((char)(a+'A')))PQ.add(new Pair((char)(a+'A'), map[a]));
			}
			
			for(int a=0;a<9;a++){
			 //   if (PQ.peek().m != 0) System.out.println(PQ.peek().c+" "+PQ.peek().m);
				answer+=(char)PQ.poll().c;
			}
			answer=(char)PQ.poll().c + answer;
			
			
			System.out.printf("Case #%d: %s%n", t, answer);
		}
	}
	static class Pair implements Comparable<Pair>{
		char c;
		int m;
		Pair(char cc, int mm){
			c=cc;
			m=mm;
		}

	@Override
	public int compareTo(Pair that) {
		return Integer.compare(that.m, this.m);
	}
	}
	
}

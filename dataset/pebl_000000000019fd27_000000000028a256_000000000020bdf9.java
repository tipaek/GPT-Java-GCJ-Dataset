import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	private static class A {
		int nr;
		int start;
		int end;
		char c;
		
		public static Comparator<? super A> cmpStart = new Comparator<A>() {
			public int compare(A o1, A o2) {
				return o1.start-o2.start;
			}
		};
	}
	
	
	private static void solve(int nr, Scanner sc) {
		int N = sc.nextInt();

		ArrayList<A> org = new ArrayList<A>(N);
		ArrayList<A> sorted = new ArrayList<A>(N);
		for(int i=0; i<N; i++) {
			A a = new A();
			a.nr = i;
			a.start = sc.nextInt();
			a.end = sc.nextInt();
			org.add(a);
			sorted.add(a);
		}
	
		sorted.sort(A.cmpStart);
		
		
		int C = 0;
		int J = 0;
		
		for(int i=0; i<N; i++) {
			A a = sorted.get(i);
			if (C <= a.start) {
				a.c = 'C';
				C = a.end;
			} else if (J <= a.start) {
				a.c = 'J';
				J = a.end;
			} else {
				System.out.println("Case #"+nr+": IMPOSSIBLE");
				return;
			}
		}
				
		System.out.print("Case #"+nr+": ");
		for(A a: org) {
			System.out.print(a.c);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}

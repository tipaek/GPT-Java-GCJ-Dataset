import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	class State {
		int [] ar;
		int moveA;
		int moveB;
		State prev;
		public State(int [] a,int b , int c, State pr) {
			ar = a;
			moveA = b;
			moveB = c;
			prev = pr;
		}
	}
	static Solution main;
	
	static int R , S;
	
	public static void main(String[] args) {
		main = new Solution();
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 1 ; i <= t ; i++) {
			R = scan.nextInt();
			S = scan.nextInt();
			int [] p = new int[R*S];
			int iter = 0;
			for(int a = 0 ; a < S ; a++) {
				for(int b = 0 ; b < R ; b++) {
					p[iter++] = b+1;
				}
			}
			State ans = null;
			State start = main.new State(p,-1,-1,null);
			ArrayList<State> list = new ArrayList<State>();
			list.add(start);
			iter = 0;
			while(iter<list.size()) {
				State s = list.get(iter++);
				if(check(s)) {
					ans = s;
					break;
				}
				ArrayList<State> ns = getNext(s);
				for(int d = 0 ; d < ns.size() ; d++) {
					list.add(ns.get(d));
				}
			}
			ArrayList<State> fin = new ArrayList<State>();
			String an = "";
			while(ans.prev!=null) {
				fin.add(ans);
				ans = ans.prev;
			}
			
			System.out.print("Case #" + i + ": ");
			System.out.println(fin.size());
			for(int e = fin.size()-1 ; e>=0 ; e--) {
				System.out.println(fin.get(e).moveA + " " + fin.get(e).moveB);
			}
		}
	}

	public static boolean check(State s) {
		for(int i = 0 ; i < s.ar.length-1 ; i++) {
			if(s.ar[i]>s.ar[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<State> getNext(State s) {
		ArrayList<State> list = new ArrayList<State>();
		for(int a = 1 ; a <R*S-1 ; a++) {
			for(int b = a+1 ; b < R*S ; b++) {
				int m1 = a;
				int m2 = b-a;
				int [] na = new int[R*S];
				for(int c = 0 ; c <= R*S-1-b ; c++) {
					na[c] = s.ar[c];
				}
				for(int c = 0 ; c < a ; c++) {
					na[R*S-b+c] = s.ar[R*S-a+c];
				}
				for(int c = 0 ; c < m2 ; c++) {
					na[R*S-m2+c] = s.ar[R*S-b+c];
				}
				State ns = main.new State(na,a,b-a,s);
				list.add(ns);
			}
		}
		return list;
	}
}

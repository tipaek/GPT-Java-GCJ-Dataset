
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static Person[] P;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1;test<=tests;test++) {
			N = in.nextInt();
			P = new Person[N];
			for(int i=0;i<N;i++) {
				P[i] = Person.make(in.nextInt(), in.nextInt(), i);
			}
			Arrays.parallelSort(P);
			LinkedList<Person> C = new LinkedList<>();
			LinkedList<Person> J = new LinkedList<>();
			boolean can = true;
			for(int i=0;i<N;i++) {
				int len1 = C.size(),len2 = J.size();
				if(len1!=0) {
					Person p1 = C.get(len1-1);
					if(p1.gett()<=P[i].gets()) {
						C.add(P[i]);
					}else if(len2!=0) {
						Person p2 = J.get(len2-1);
						if(p2.gett()<=P[i].gets()) {
							J.add(P[i]);
						}else {
							can = false;
							break;
						}
						
					}else {
						J.add(P[i]);
					}
						
				}else {
					C.add(P[i]);
				}
			}
			
			if(can) {
				int[] cj = new int[N];
				for(int i=0;i<C.size();i++) {
					cj[C.get(i).getn()] = 0;
				}
				for(int i=0;i<J.size();i++) {
					cj[J.get(i).getn()] = 1;
				}
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<N;i++) {
					if(cj[i]==0) {
						sb.append("C");
					}else {
						sb.append("J");
					}
				}
				System.out.printf("Case #%d: %s\n",test,sb.toString());
			}else {
				System.out.printf("Case #%d: %s\n",test,"IMPOSSIBLE");
			}
		}
	}
	static class Person implements Comparable<Person> {
		private int s,t,n;
		static Person make(int s,int t,int n){
	        return new Person(s,t,n);
	    }
		private Person(int s,int t,int n){
	        this.s = s;
	        this.t = t;
	        this.n = n;
	    }
		public int gets() {
			return s;
		}
		public int gett() {
			return t;
		}
		public int getn() {
			return n;
		}
		public int compareTo(Person p) {
			return s<p.gets()?-1:1;
		}
	}
}

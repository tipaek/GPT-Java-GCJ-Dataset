import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

	class Stack {
		char c;
		int pos;
		public Stack(char cc , int pp) {
			c = cc;
			pos = pp;
		}
	}

	static Solution main;

	static int K,Q;
	static String P;
	static int[] match;
	static Stack[] stack;
	static boolean [] visited;

	public static void main(String[] args) {
		main = new Solution();
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int size = 100000;
		visited = new boolean[size];
		int [] L = new int[size];
		int [] R = new int[size];
		int [] p = new int[size];
		match = new int[size];
		stack = new Stack[size];
		for(int i =1 ; i <= t ; i++) {
			long ans = 0;
			K = scan.nextInt();
			Q = scan.nextInt();
			P = scan.next();

			
			for(int j = 0 ; j < K ; j++) {
				L[j] = scan.nextInt();
			}
			for(int j = 0 ; j < K ; j++) {
				R[j] = scan.nextInt();
			}
			for(int j = 0 ; j < K ; j++) {
				p[j] = scan.nextInt();
			}
			
			Arrays.fill(match, -1);
			
			int pos = 0;
			for(int j = 0 ; j < K ; j++) {
				if(P.charAt(j)==')') {
					if(pos>0) {
						if(stack[pos-1].c=='(') {
							match[stack[pos-1].pos] = j;
							match[j] = stack[pos-1].pos;
							pos--;
						} else {
							stack[pos++] = main.new Stack(P.charAt(j),j);
						}
					}
				} else {
					stack[pos++] = main.new Stack(P.charAt(j),j);
				}
			}

			int [] start = new int[Q];
			int [] end = new int[Q];
			for(int j = 0 ; j < Q ; j++) {
				start[j] = scan.nextInt();
			}
			for(int j = 0 ; j < Q ; j++) {
				end[j] = scan.nextInt();
			}
			for(int j = 0 ; j < Q ; j++) {
				ans += findMin(start[j],end[j]);
			}
			System.out.print("Case #" + i + ": ");
			System.out.println(ans);
		}

	}
	static int findMin(int s, int e) {
		s--;
		e--;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(s);
		
		Arrays.fill(visited, false);
		visited[s] = true;
		int iter = 0;
		int depth = 0;
		while(iter<list.size()) {
			
			int size = list.size();
			for(int a = iter ; a < size ; a++) {
				int x = list.get(a);
				if(x==e) {
					return depth;
				}
				if(x<K-1) {
					if(!visited[x+1]) {
						list.add(x+1);
						visited[x+1] = true;
					}

				}
				if(x>0) {
					if(!visited[x-1]) {
						list.add(x-1);
						visited[x-1] = true;
					}

				}
				if(match[x]>=0) {
					if(!visited[match[x]]) {
						list.add(match[x]);
						visited[match[x]] = true;
					}
				}
			}
			iter = size;
			depth++;
		}
		System.out.println(depth);
		return depth;
	}


}

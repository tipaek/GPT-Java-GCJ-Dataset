import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int B;
	static int[] S;
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			solve();
		}
	}
	
	static void solve() throws Exception {
		S = new int[B];
		Arrays.fill(S, -1);
		int p = 0, q = B-1;
		int att=0;
		int ext=0;
		while(p<=q) {
			if (att%10!=0 || att==0) {
				if (ext==0) {
					out(p);
					S[p] = get();
					ext = 1;
					p++;
				}else {
					out(q);
					S[q] = get();
					ext = 0;
					q--;
				}
				att++;
				continue;
			}
			int pos = first_eq(p);
			if (pos!=-1) {
				out(pos);
				int res = get();
				att++;
				if (res == S[pos]) {
					int pos_d = first_dif(p);
					if (pos_d!=-1) {
						out(pos_d);
						res = get();
						att++;
						if (res!=S[pos_d]) {
							reverse();
						}
					}else{
						out(0);
						get();
						att++;
					}
				}else {
					int pos_d = first_dif(p);
					if (pos_d!=-1) {
						out(pos_d);
						res = get();
						att++;
						if (res!=S[pos_d]) {
							complement();
						}else {
							complement();
							reverse();
						}
					}else {
						complement();
						out(0);
						get();
						att++;
					}
				}
			}else {
				out(0);
				int res = get();
				att++;
				if (res!=S[0]) {
					complement();
				}
				out(0);
				res = get();
				att++;
			}
		}
		report(S);
	}
	
	static int first_eq(int p) {
		for (int i = 0; i < p; i++) {
			if (S[i]==S[B-i-1]) return i;
		}		
		return -1;
	}
	
	static int first_dif(int p) {
		for (int i = 0; i < p; i++) {
			if (S[i]!=S[B-i-1]) return i;
		}		
		return -1;
	}
	
	static void report(int[] S) throws Exception {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < B; i++) 
			buf.append(S[i]);
		System.out.println(buf);
		in.readLine();
	}
	
	static int get() throws Exception {
		return Integer.parseInt(in.readLine());
	}
	
	static void out(int b) {
		System.out.println(b+1);
	}
	
	static void reverse() {
		int aux, i = 0, j = B-1; 
		while(i<j) {
			aux = S[i];
			S[i] = S[j];
			S[j] = aux;
			i++;
			j--;
		}
	}
	
	static void complement() {
		for (int i = 0; i < S.length; i++) {
			if (S[i]==-1) continue;
			S[i] = (S[i]+1)%2;
		}
	}
}

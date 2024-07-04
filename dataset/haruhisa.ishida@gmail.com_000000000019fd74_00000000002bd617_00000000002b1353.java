import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
	int T;
	long N;
	Deque<Tuple> deque;

	static class Tuple {
		int r, l;

		Tuple(int r, int l) {
			this.r = r;
			this.l = l;
		}

	}

	Solution(int T, BufferedReader in) throws Exception {
		this.T = T;
		this.N = Long.parseLong(in.readLine());
		this.deque = new ArrayDeque<>();
	}

	void calc() {
		long val = N;
		deque.addLast(new Tuple(1, 1));
		val--;
		int r = 2;
		int l = 2;
		long base = 1;
		while (true) {
			if (val - base >= 0) {
				this.deque.addLast(new Tuple(r, l));
			} else {
				break;
			}
			val -= base;
			++base;
			r++;
		}
		l = 1;
		--r;
		while (val > 0) {
			this.deque.addLast(new Tuple(r, l));
			--r;
			val--;
		}
	}

	void show() {
		System.out.println("Case #" + T + ":");
		while (!deque.isEmpty()) {
			Tuple t = deque.pollFirst();
			System.out.println(t.r + " " + t.l);
		}
	}

	public static void main(String[] args) throws Exception {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		int T = Integer.parseInt(in.readLine());
		for (int i = 1; i <= T; ++i) {
			Solution sol = new Solution(i, in);
			sol.calc();
			sol.show();
		}
		in.close();
	}

}
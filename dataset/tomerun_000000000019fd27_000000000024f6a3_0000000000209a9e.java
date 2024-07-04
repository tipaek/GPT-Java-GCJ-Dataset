import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public final class Solution {
	private static final Scanner sc = new Scanner(System.in);
	private static final boolean LOCAL = false;
	static int B = 100;
	static int qc = 0;
	static int[] TRUTH = new int[B];
	static int[] A = new int[B];
	static SplittableRandom rnd = new SplittableRandom(1);

	public static void main(String[] args) {
		int T = 1;
		if (LOCAL) {
			if (args.length > 0) {
				T = Integer.parseInt(args[0]);
			}
			for (int i = 0; i < B; i++) {
				TRUTH[i] = rnd.nextInt(2);
			}
		} else {
			T = sc.nextInt();
			B = sc.nextInt();
		}
		for (int i = 1; i <= T; i++) {
			if (LOCAL) {
				double p = rnd.nextDouble();
				System.err.println("prob:" + p);
				for (int j = 0; j < B; j++) {
					TRUTH[j] = rnd.nextDouble() < p ? 0 : 1;
				}
			}
			qc = 0;
			if (!solve()) {
				break;
			}
		}
	}

	static boolean solve() {
		int[] inner01 = null;
		int[] inter01 = null;
		for (int i = 0; i < 5; i++) {
			A[i] = query(i);
			A[B - 1 - i] = query(B - 1 - i);
		}
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; ++j) {
				if (A[i] != A[j] && A[B - 1 - i] == A[B - 1 - j]) {
					inner01 = new int[]{A[i] == 0 ? i : j, A[i] == 0 ? j : i};
				}
				if (A[i] == A[j] && A[B - 1 - i] != A[B - 1 - j]) {
					inner01 = new int[]{A[B - 1 - i] == 0 ? B - 1 - i : B - 1 - j, A[B - 1 - i] == 0 ? B - 1 - j : B - 1 - i};
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			if (A[i] != A[B - 1 - i]) {
				inter01 = new int[]{A[i] == 0 ? i : B - 1 - i, A[i] == 0 ? B - 1 - i : i};
			}
		}
		for (int i = 0; i < (B - 10 + 7) / 8; i++) {
			if (inner01 != null) {
				int v0 = query(inner01[0]);
				int v1 = query(inner01[1]);
				if (v0 == v1) {
					reverse(A);
					if (v0 != A[inner01[0]]) {
						complement(A);
						swap(inner01);
					}
					inner01[0] = B - 1 - inner01[0];
					inner01[1] = B - 1 - inner01[1];
				} else if (v0 == 1) {
					complement(A);
					swap(inner01);
				}
			} else if (inter01 != null) {
				int v0 = query(inter01[0]);
				int v1 = query(inter01[1]);
				if (v0 == 1) {
					complement(A);
					swap(inter01);
				}
			} else {
				int v0 = query(0);
				query(0);
				if (v0 != A[0]) {
					complement(A);
				}
			}
			int start = 5 + 4 * i;
			int count = Math.min(4, B / 2 - start);
			for (int j = 0; j < count; j++) {
				A[start + j] = query(start + j);
				A[B - 1 - (start + j)] = query(B - 1 - (start + j));
			}

			for (int j = 0; j < start + count; j++) {
				for (int k = j + 1; k < start + count; k++) {
					if (A[j] != A[k] && A[B - 1 - j] == A[B - 1 - k]) {
						inner01 = new int[]{A[j] == 0 ? j : k, A[j] == 0 ? k : j};
					}
					if (A[j] == A[k] && A[B - 1 - j] != A[B - 1 - k]) {
						inner01 = new int[]{A[B - 1 - j] == 0 ? B - 1 - j : B - 1 - k, A[B - 1 - j] == 0 ? B - 1 - k : B - 1 - j};
					}
				}
			}
			for (int j = 0; j < count; j++) {
				int p0 = start + j;
				if (A[p0] != A[B - 1 - p0]) {
					inter01 = new int[]{A[p0] == 0 ? p0 : B - 1 - p0, A[p0] == 0 ? B - 1 - p0 : p0};
				}
			}
		}
		if (inner01 != null) {
			while (qc + 2 <= 150) {
				int v0 = query(inner01[0]);
				int v1 = query(inner01[1]);
				if (v0 == v1) {
					reverse(A);
					if (v0 != A[inner01[0]]) {
						complement(A);
						swap(inner01);
					}
					inner01[0] = B - 1 - inner01[0];
					inner01[1] = B - 1 - inner01[1];
				} else if (v0 == 1) {
					complement(A);
					swap(inner01);
				}
			}
		} else if (inter01 != null) {
			while (qc + 2 <= 150) {
				int v0 = query(inter01[0]);
				int v1 = query(inter01[1]);
				if (v0 == 1) {
					complement(A);
					swap(inter01);
				}
			}
		} else {
			while (qc < 150) {
				int v = query(0);
				if (v != A[0]) {
					complement(A);
				}
			}
		}
		return answer(A);
	}

	static void swap(int[] a) {
		int tmp = a[0];
		a[0] = a[1];
		a[1] = tmp;
	}

	static void reverse(int[] a) {
		for (int i = 0; i < B / 2; i++) {
			int tmp = a[i];
			a[i] = a[B - 1 - i];
			a[B - 1 - i] = tmp;
		}
	}

	static void complement(int[] a) {
		for (int i = 0; i < B; i++) {
			a[i] = 1 - a[i];
		}
	}

	static int query(int p) {
		qc++;
		if (LOCAL) {
			if (qc % 10 == 1) {
				int type = rnd.nextInt(4);
				if (type == 0) {
					complement(TRUTH);
					reverse(TRUTH);
				} else if (type == 1) {
					complement(TRUTH);
				} else if (type == 2) {
					reverse(TRUTH);
				}
			}
//			System.err.println("p:" + p + " v:" + TRUTH[p]);
			return TRUTH[p];
		} else {
			System.out.println(p + 1);
			return sc.nextInt();
		}
	}

	static boolean answer(int[] a) {
		if (LOCAL) {
			boolean result = true;
			for (int i = 0; i < B; i++) {
				if (a[i] != TRUTH[i]) {
					result = false;
				}
			}
			if (!result) {
				System.err.println(Arrays.toString(a));
				System.err.println(Arrays.toString(TRUTH));
			}
			return result;
		} else {
			StringBuilder sb = new StringBuilder();
			for (int v : a) {
				sb.append(v);
			}
			System.out.println(sb);
			return sc.next().equals("Y");
		}
	}
}

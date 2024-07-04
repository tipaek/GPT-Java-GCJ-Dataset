import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			Timing[] mat = new Timing[n];

			for (int j = 0; j < n; j++) {
				mat[j] = new Timing(sc.nextInt(), sc.nextInt(), j);
			}

			Arrays.sort(mat, new Comparator<Timing>() {

				@Override
				public int compare(Timing o1, Timing o2) {
					return o1.start - o2.start;
				}
			});

			char ch[] = new char[n];

			ch[mat[0].sr] = 'J';
			Timing J = mat[0];
			Timing C = null;
			boolean flag = false;
			for (int j = 1; j < n; j++) {
				flag = false;
				if (J.finish > mat[j].start) {
					if (C == null || C.finish <= mat[j].start) {
						C = mat[j];
						flag = true;
						ch[mat[j].sr] = 'C';
					}
				} else {
					J = mat[j];
					ch[mat[j].sr] = 'J';
					flag = true;
				}

				if (!flag) {
					break;
				}
			}
			if (!flag)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + i + ": " + new String(ch));
		}
		sc.close();
	}

}

class Timing {
	int start;
	int finish;
	int sr;

	public Timing(int start, int finish, int sr) {
		this.start = start;
		this.finish = finish;
		this.sr = sr;
	}

	@Override
	public String toString() {
		return this.start + "," + this.finish;
	}
}
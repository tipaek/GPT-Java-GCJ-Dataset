import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	int[] DY = { 1, 1, 0, 0 };
	int[] DX = { 0, 1, 1, -1 };

	class Pos {
		public int r, k, bi, sum;
	}

	String fnc(int n) {

		Pos p1 = new Pos();
		p1.r = 1;
		p1.k = 1;
		p1.bi = -1;
		p1.sum = 1;

		Set<Integer> sumset = new HashSet<Integer>();
		sumset.add(1);

		List<Pos> list1 = new ArrayList<Pos>();
		List<Pos> list2 = new ArrayList<Pos>();

		list1.add(p1);

		int index = -1;
		int startIndex = 0;
		int endIndex = 0;
		while (true) {
			list2.clear();
			for (int i = startIndex; i <= endIndex; i++) {
				Pos p = list1.get(i);
				if (p.sum == n) {
					index = i;
					break;
				}

				for (int kk = 0; kk < 4; kk++) {
					int nr = p.r + DY[kk];
					int nk = p.k + DX[kk];

					if (nk > 0) {
						int val = calcNCR(nr - 1, nk - 1);
						int sum = p.sum + val;
						if (!sumset.contains(sum)) {
							sumset.add(sum);

							Pos np = new Pos();
							np.r = nr;
							np.k = nk;
							np.bi = i;
							np.sum = sum;
							list2.add(np);
						}
					}
				}
			}

			if (index != -1) {
				break;
			}

			startIndex = list1.size();
			endIndex = startIndex + list2.size() - 1;

			list1.addAll(list2);
		}

		List<Pos> poses = new ArrayList<Pos>();
		while (true) {
			Pos pp = list1.get(index);
			poses.add(0, pp);

			if (pp.bi == -1) {
				break;
			}

			index = pp.bi;
		}

		return System.lineSeparator() + makeAns(poses);
	}

	String makeAns(List<Pos> poses) {
		StringBuilder sb = new StringBuilder();

		for (Pos pos : poses) {
			sb.append(pos.r).append(" ").append(pos.k).append(System.lineSeparator());
		}

		return sb.toString();
	}

	int calcNCR(int n, int r) {
		long sum = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
		}
		for (int i = n - r; i >= 2; i--) {
			sum /= i;
		}
		for (int i = r; i >= 2; i--) {
			sum /= i;
		}

		return (int) sum;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int n = sc.nextInt();

				System.out.print("Case #" + t + ": " + fnc(n));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}

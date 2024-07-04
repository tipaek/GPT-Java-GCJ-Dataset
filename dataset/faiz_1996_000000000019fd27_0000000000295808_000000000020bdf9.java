import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		List<Model> l = new ArrayList<>(t);
		List<Model2> l2;
		Solution sol = new Solution();
		while (t >= 1 && t <= 100 && t-- > 0) {
			int n = s.nextInt();
			int k = n;

			l2 = new ArrayList<>();
			Model2 m2;
			while (n >= 2 && n <= 1000 && k-- > 0) {

				int st = s.nextInt();
				int et = s.nextInt();

				if (st >= 0 && st <= 1440 && et >= 0 && et <= 1440) {
					m2 = sol.new Model2("", st, et);
					l2.add(m2);
				}

			}
			if (l2.size() > 0)
				l.add(sol.new Model(l2));

		}
		s.close();

		// solve Problem

		if (l.size() > 0) {
			for (int i = 0; i < l.size(); i++) {
				System.out.println("Case #" + (i + 1) + ": "
						+ calculateResult(l.get(i)));
			}
		}

	}

	public class Model {

		List<Model2> list;

		public List<Model2> getList() {
			return list;
		}

		public void setList(List<Model2> list) {
			this.list = list;
		}

		public Model(List<Model2> list) {
			super();
			this.list = list;
		}

		public Model() {
			super();
		}

	}

	public class Model2 {

		String p;
		int st;
		int et;

		public Model2(String p, int st, int et) {
			super();
			this.p = p;
			this.st = st;
			this.et = et;
		}

		public Model2() {
			super();
		}

		public String getP() {
			return p;
		}

		public void setP(String p) {
			this.p = p;
		}

		public int getSt() {
			return st;
		}

		public void setSt(int st) {
			this.st = st;
		}

		public int getEt() {
			return et;
		}

		public void setEt(int et) {
			this.et = et;
		}

	}

	private static String calculateResult(Model model) {

		List<String> users = Arrays.asList(new String[] { "C", "J" });

		List<Model2> l = model.getList();
		String du = users.get(0);
		String du2 = users.get(1);
		String k = du;
		List<Model2> l1;

		Model2 m2;
		for (int i = 0; i < l.size(); i++) {

			m2 = l.get(i);
			if (i == 0) {
				m2.setP(k);
			}
			if (i != 0) {
				l1 = new ArrayList<>();
				l1 = getSpecifiedList(l, k);
				if (!computeForUser(m2.getSt(), m2.getEt(), l1)) {
					k = k.equalsIgnoreCase("J") ? "C" : "J";
					l1 = getSpecifiedList(l, k);
					if (!computeForUser(m2.getSt(), m2.getEt(), l1)) {
						return "IMPOSSIBLE";

					} else {
						m2.setP(k);
					}
				} else {
					// when true in first case
					m2.setP(k);
				}
			}
		}
		return formStringFromList(l);
	}

	private static String formStringFromList(List<Model2> l) {
		StringBuilder s = new StringBuilder("");

		for (Model2 m : l) {
			s.append(m.getP());
		}

		return s.toString();
	}

	private static List<Model2> getSpecifiedList(List<Model2> l, String k) {

		return l.stream().filter(e -> e.getP().equalsIgnoreCase(k))
				.collect(Collectors.toList());

	}

	private static boolean computeForUser(int st, int et, List<Model2> l) {
		boolean possible = true;

		for (int i = 0; i < l.size(); i++) {
			Model2 m = l.get(i);
			if (betweenInterval(st, et, m.getSt(), m.getEt()))
				return false;

		}

		return possible;
	}

	private static boolean betweenInterval(int st, int et, int ist, int iet) {

		if ((st > ist && st < iet) || (et > ist && et < iet)
				|| (st <= ist && et >= iet) || (st >= ist && et <= iet))
			return true;

		return false;

	}
}

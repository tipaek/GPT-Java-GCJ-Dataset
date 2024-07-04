import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		List<Model> l = new ArrayList<>(t);
		Vestigium v = new Vestigium();

		while (t >= 1 && t <= 100 && t-- > 0) {
			Model m = v.new Model();
			int n = s.nextInt();
			int[][] arr = new int[n][n];

			if (n >= 2 && n <= 100) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						arr[i][j] = s.nextInt();
					}
				}
			}

			m.setN(n);
			m.setArr(arr);
			l.add(m);

		}
		s.close();

		// solve Problem

		if (l.size() > 0) {

			for (int i = 0; i < l.size(); i++) {

				System.out.println("Case #" + (i + 1) + ": "
						+ calculateTrace(l.get(i)) + " "
						+ rowDupliaction(l.get(i)) + " "
						+ colDupliaction(l.get(i)));

			}

		}

	}

	private static int colDupliaction(Model model) {
		int cd = 0;
		int n = model.getN();
		int[][] arr = model.getArr();
		int j = 0;
		int c = 0;

		List<Integer> l;
		Set<Integer> s;

		while (j < n) {
			l = new ArrayList<>();
			s = new HashSet<>();

			for (int i = 0; i < n; i++) {
				j = c / n;

				l.add(arr[i][j]);
				s.add(arr[i][j]);

				c++;
			}
			if (l.size() != s.size())
				cd++;

			j++;

		}

		return cd;
	}

	private static int rowDupliaction(Model model) {
		int rd = 0;
		int n = model.getN();
		int[][] arr = new int[n][n];
		arr = model.getArr();

		List<Integer> l;
		Set<Integer> s;

		for (int i = 0; i < arr.length; i++) {
			l = new ArrayList<>();
			s = new HashSet<>();
			for (int j = 0; j < arr.length; j++) {
				l.add(arr[i][j]);
				s.add(arr[i][j]);
			}
			if (l.size() != s.size())
				rd++;

		}

		return rd;
	}

	private static int calculateTrace(Model model) {
		int sum = 0;
		int i, j = 0;
		int[][] arr = model.getArr();
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr.length; j++) {
				if (i == j)
					sum = sum + arr[i][j];
			}
		}

		return sum;
	}

	public class Model {

		int n;
		int[][] arr;

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public int[][] getArr() {
			return arr;
		}

		public void setArr(int[][] arr) {
			this.arr = arr;
		}

		public Model(int n, int[][] arr) {
			super();
			this.n = n;
			this.arr = arr;
		}

		public Model() {
			super();

		}

	}

}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Scanner;

public class Vestigium {

	public static void main(final String[] args) {
		new Vestigium().start();

	}

	private InputStream in;

	public Vestigium() {
		in = System.in;
	}

	public Vestigium(final String fileName) {
		try {
			in = new FileInputStream(fileName);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			BitSet[] columns = new BitSet[n];
			for (int j = 0; j < n; j++) {
				columns[j] = new BitSet(n + 1);
			}

			int sum = 0;
			int rr = 0;
			int rc = 0;
			for (int y = 0; y < n; y++) {
				BitSet row = new BitSet(n + 1);
				for (int x = 0; x < n; x++) {
					int v = sc.nextInt();

					if (x == y) {
						sum = sum + v;
					}

					if (row != null) {
						if (row.get(v)) {
							rr++;
							row = null;
						} else {
							row.set(v);
						}
					}

					if (columns[x] != null) {
						if (columns[x].get(v)) {
							rc++;
							columns[x] = null;
						} else {
							columns[x].set(v);
						}
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + sum + " " + rr + " " + rc);
		}
	}
}

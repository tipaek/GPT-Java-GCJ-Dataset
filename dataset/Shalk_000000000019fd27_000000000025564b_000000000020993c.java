import java.util.Scanner;
public class test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter dimentions");
		int d = in.nextInt();
		int a[][] = new int[d][d];
		int sum = 0, ma = 0, na = 0;
		for (int m = 0; m < d; m++) {
			for (int n = 0; n < d; n++) {
				System.out.println("Enter (" + m + "" + n + ") element");
				a[m][n] = in.nextInt();
				if (m == n)
					sum = sum + a[m][n];
			}
		}
		for (int m = 0; m < d; m++) {
			outer: for (int n = 0; n < d; n++) {
				for (int k = n + 1; k < d; k++) {
					if (a[m][n] == a[m][k]) {
						ma++;
						break outer;
					}
				}
			}
		}
		for (int m = 0; m < d; m++) {
			outer: for (int n = 0; n < d; n++) {
				for (int k = n + 1; k < d; k++) {
					if (a[n][m] == a[k][m]) {
						na++;
						break outer;
					}
				}
			}
		}
		System.out.println("Case: " + sum + " " + ma + " " + na);
	}
}

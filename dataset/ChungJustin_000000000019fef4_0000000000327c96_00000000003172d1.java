import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {

		int T = System.in.read();
		System.in.read();
		int b = System.in.read();
		System.in.read();
		for (int t = 0; t < T; t++) {
			int ans;
			String s;
			int N = System.in.read();
			System.in.read();
			int D = System.in.read();
			System.in.read();
			ans = D - 1;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BigInteger[] cakes = new BigInteger[10000];
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				cakes[i] = new BigInteger(s);
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (cakes[i] == cakes[j] && D == 2) {
						ans = 0;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					for (int k = j + 1; k < N; k++) {
						if (cakes[i].compareTo(cakes[j]) == 0 && cakes[j].compareTo(cakes[k]) == 0 && D == 3) {
							ans = 0;
						}
					}
					if ((cakes[i].compareTo(cakes[j].multiply(new BigInteger("2"))) == 0
							|| cakes[i].compareTo(cakes[j].multiply(new BigInteger("2"))) == 0) && D == 3 && ans != 0) {
						ans = 1;
					}
				}
			}
			System.out.print("Case #");
			System.out.print(t + 1);
			System.out.print(": ");
			System.out.println(ans);
		}

	}

}
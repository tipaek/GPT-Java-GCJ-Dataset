

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

 class Vestigium {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int tc = 1;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int a[][] = new int[N][N];
			for (int i = 0; i < a.length; i++) {
				String s[] =  br.readLine().split(" ");
				for (int j = 0; j < a.length; j++) {
					a[i][j] = Integer.parseInt(s[j]);
				}
			}
			int k = 0, r = 0, c = 0;
			for (int i = 0; i < a.length; i++) {
				k += a[i][i];

				HashSet<Integer> checkRow = new HashSet<>();
				for (int j = 0; j < a.length; j++) {
					if (checkRow.contains(a[i][j])) {
						r++;
						break;
					} else {
						checkRow.add(a[i][j]);
					}
				}

				HashSet<Integer> checkCol = new HashSet<>();
				for (int j = 0; j < a.length; j++) {
					if (checkCol.contains(a[j][i])) {
						c++;
						break;
					} else {
						checkCol.add(a[j][i]);
					}
				}
			}
			bw.write(String.format("Case #%d: %d %d %d\n",  tc++, k, r, c));
		}

	}
}

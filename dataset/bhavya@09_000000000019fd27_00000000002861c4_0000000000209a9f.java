

import java.io.*;
import java.util.*;

 class Code5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		while (tc > 0) {
			String str = br.readLine();
			int n = str.length();
			char st[] = str.toCharArray();
			ArrayList<Character> l = new ArrayList<>();

			for (int i = 0; i < st.length; i++) {
				int d = st[i] - '0';

				if (i == 0) {
					for (int j = 0; j < d; j++) {
						l.add('(');
					}
					l.add(st[i]);
					if (i + 1 < n && st[i + 1] == st[i]) {
						l.add(st[i + 1]);
						i++;
						continue;
					}
					if (i + 1 == n) {
						for (int j = 0; j < d; j++) {
							l.add(')');
						}
					} else if (i + 1 < n && st[i + 1] == '0') {
						for (int j = 0; j < d; j++) {
							l.add(')');
						}
					} else {
						for (int j = 0; j < d - 1; j++) {
							l.add(')');
						}
					}
				} else {
					if (st[i - 1] == '0') {
						for (int j = 0; j < d; j++) {
							l.add('(');
						}
						l.add(st[i]);
						if (i + 1 < n && st[i + 1] == st[i]) {
							l.add(st[i + 1]);
							i++;
							continue;
						}
						if (i + 1 == n) {
							for (int j = 0; j < d; j++) {
								l.add(')');
							}
						} else if (i + 1 < n && st[i + 1] == '0') {
							for (int j = 0; j < d; j++) {
								l.add(')');
							}
						} else {
							for (int j = 0; j < d - 1; j++) {
								l.add(')');
							}
						}
					} else {
						for (int j = 0; j < d - 1; j++) {
							l.add('(');
						}
						l.add(st[i]);
						if (i + 1 < n && st[i + 1] == st[i]) {
							l.add(st[i + 1]);
							i++;
							continue;
						}
						if (i + 1 == n) {
							for (int j = 0; j < d; j++) {
								l.add(')');
							}
						} else if (i + 1 < n && st[i + 1] == '0') {
							for (int j = 0; j < d; j++) {
								l.add(')');
							}
						} else {
							for (int j = 0; j < d - 1; j++) {
								l.add(')');
							}
						}
					}

				}
			}

			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i));
			}
			System.out.println();

			tc--;
		}

	}

}

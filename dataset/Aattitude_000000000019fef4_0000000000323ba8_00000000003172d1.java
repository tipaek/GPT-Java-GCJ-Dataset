

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long testCase = Long.parseLong(br.readLine());
		for (long t = 1; t <= testCase; t++) {

			
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			long d = Long.parseLong(s1[1]);
			HashMap<Long, Long> map = new HashMap<Long, Long>();
			s1 = br.readLine().split(" ");
			long arr[] = new long[n];
			boolean duplicate = false;
			long max = 1;
			for (int i = 0; i < n; i++) {
				long key = Long.parseLong(s1[i]);
				arr[i] = key;
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
					duplicate = true;
					max = Math.max(map.get(key), max);
				} else {
					map.put(key, 1l);
				}
			}
			if (d == 2) {
				if (duplicate)
					bw.write("Case #" + t + ": " + 0 + "\n");
				else
					bw.write("Case #" + t + ": " + 1 + "\n");
			} else if (d == 3) {

				if (max >= 3)
					bw.write("Case #" + t + ": " + 0 + "\n");
				else if (max >= 2)
					bw.write("Case #" + t + ": " + 1 + "\n");
				else {
					boolean flag1 = false;
					for (int i = 0; i < n; i++) {
						if (arr[i] % 2 == 0) {
							for (int j = i + 1; j < n; j++) {
								if (arr[i] / 2 == arr[j]) {
									flag1 = true;
								}
								if (flag1)
									break;
							}
						}
						if (flag1)
							break;
					}
					if (flag1)
						bw.write("Case #" + t + ": " + 1 + "\n");
					else
						bw.write("Case #" + t + ": " + 2 + "\n");
				}
			}
		}
		bw.flush();
	}
}

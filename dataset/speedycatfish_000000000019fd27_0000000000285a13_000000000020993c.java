import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			int size = Integer.parseInt(bufread.readLine());
			HashSet<Integer>[] columns = new HashSet[size];
			for (int i = 0; i < size; i++) {
				columns[i] = new HashSet<>();
			}
			int trace = 0;
			int r = 0;
			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(bufread.readLine());
				HashSet<Integer> row = new HashSet<>();
				for (int j = 0; j < size; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (i == j) {
						trace += num;
					}
					row.add(num);
					columns[j].add(num);
				}
				if (row.size() != size) {
					r++;
				}
			}
			int c = 0;
			for (HashSet<Integer> h : columns) {
				if (h.size() != size) {
					c++;
				}
			}
			System.out.println("Case #" + (counter + 1) + ": " + trace + " " + r + " " + c);
		}
		bufread.close();
	}
}

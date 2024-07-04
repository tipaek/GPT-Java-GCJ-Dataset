import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			StringTokenizer st = new StringTokenizer(bufread.readLine());
			int sliceNum = Integer.parseInt(st.nextToken());
			int dinerNum = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bufread.readLine());
			TreeMap<Long, Integer> slices = new TreeMap<>();
			for (int i = 0; i < sliceNum; i++) {
				long newSlice = Long.parseLong(st.nextToken());
				slices.putIfAbsent(newSlice, 0);
				slices.put(newSlice, slices.get(newSlice) + 1);
			}
			if (dinerNum == 2) {
				int minSlices = 1;
				for (long slice : slices.keySet()) {
					if (slices.get(slice) > 1) {
						minSlices = 0;
						break;
					}
				}
				System.out.println("Case #" + (counter + 1) + ": " + minSlices);
			} else if (dinerNum == 3) {
				int minSlices = 2;
				for (long slice : slices.keySet()) {
					if (slices.get(slice) > 2) {
						minSlices = 0;
						break;
					}
					if (minSlices == 2) {
						if (slices.get(slice) == 2) {
							if (slices.lastKey() > slice) {
								minSlices = 1;
							}
						} else if (slices.containsKey(slice * 2)) {
							minSlices = 1;
						}
					}
				}
				System.out.println("Case #" + (counter + 1) + ": " + minSlices);
			}
		}
		bufread.close();
	}

}

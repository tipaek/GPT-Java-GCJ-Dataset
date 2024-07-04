import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br);
	}

	
	public static void solve(BufferedReader br) throws IOException {
		int numberOfTestCases = Integer.parseInt(br.readLine());
		testCases: for (int i = 1; i <= numberOfTestCases; i++) {

			String[] sliceandDine = br.readLine().split(" ");

			int slices = Integer.parseInt(sliceandDine[0]);
			int diners = Integer.parseInt(sliceandDine[1]);

			String[] sliceconfigs = br.readLine().split(" ");

			List<Long> sliceConfigList = new ArrayList();
			Map<Long, Long> dupMapCount = new HashMap<Long, Long>();

			for (int r = 0; r < slices; r++) {

				long sliceConfig = Long.parseLong(sliceconfigs[r]);

				if (dupMapCount.containsKey(sliceConfig)) {
					dupMapCount.put(sliceConfig, dupMapCount.get(sliceConfig) + 1);

				} else {
					dupMapCount.put(sliceConfig, 1L);
				}

				long dups = dupMapCount.get(sliceConfig);

				if (dups == diners) {
					System.out.println("Case #" + i + ": " + 0);
					continue testCases;
				}

				sliceConfigList.add(sliceConfig);
			}

			Collections.sort(sliceConfigList);

			long totalCuts = 0;

			long key = dupMapCount.entrySet().stream()
					.max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

			long dups = dupMapCount.get(key);
			long totalSlices = 0;
			if (dups > 1) {

				totalSlices = dups;
				int lastIndex = sliceConfigList.lastIndexOf(key);

				for (int j = lastIndex; j < sliceConfigList.size(); j++) {

					long sc = sliceConfigList.get(j);

					long slicecuts = sc / key;
					totalSlices = totalSlices + slicecuts;
					if (totalSlices > diners) {

						long sliceNr = totalSlices - diners;

						totalCuts = sliceNr - 1;

					} else {
						totalCuts = totalCuts + slicecuts - 1;
					}

				}

			}

			else if (sliceConfigList.size() == 1) {

				totalCuts = diners - 1;

			} else {
				long slicepart = sliceConfigList.get(0);
				totalSlices++;
				for (int j = 1; j < sliceConfigList.size(); j++) {
					long sc = sliceConfigList.get(j);

					long slicecuts = sc / slicepart;

					totalSlices = totalSlices + slicecuts;
					if (totalSlices > diners) {
						totalCuts = totalCuts + slicecuts - 1;
						long sliceNr = totalSlices - diners;

						if (sliceNr > 1) {
							totalCuts = totalCuts - sliceNr;
						}

						System.out.println("Case #" + i + ": " + totalCuts);

						continue testCases;

					} else {
						totalCuts = totalCuts + slicecuts - 1;
					}

				}
			}

			System.out.println("Case #" + i + ": " + totalCuts);
		}

	}
}

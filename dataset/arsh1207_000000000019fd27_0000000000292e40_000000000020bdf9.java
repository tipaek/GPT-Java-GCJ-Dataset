import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			int test = Integer.parseInt(br.readLine());
			for (int t = 0; t < test; t++) {
				int n = Integer.parseInt(br.readLine());
				int arr[][] = new int[n][2];
				//int arr2[][] = new int[n][2];
				for (int i = 0; i < n; i++) {
					String line = br.readLine();
					arr[i][0] = Integer.parseInt(line.split(" ")[0]);
					arr[i][1] = Integer.parseInt(line.split(" ")[1]);					
				}
				//Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
				Map<Integer, String> schedule = new HashMap();
				String result = "";
				int j_start = 0;
				int j_end = 0;
				int c_start = 0;
				int c_end = 0;
				for (int i = 0; i < n; i++) {
					if (arr[i][0] >= c_end || arr[i][1] <= c_start) {
						result += "C";
						//schedule.put(i, "C");
						c_start = arr[i][0];
						c_end = arr[i][1];
					}
					else if (arr[i][0] >= j_end || arr[i][1] <= j_start) {
						result += "J";
						//schedule.put(i, "J");
						j_start = arr[i][0];
						j_end = arr[i][1];
					} else {
						result = "IMPOSSIBLE";
						break;
					}
				}
				System.out.println("Case #" + (t + 1) + ": " + result);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
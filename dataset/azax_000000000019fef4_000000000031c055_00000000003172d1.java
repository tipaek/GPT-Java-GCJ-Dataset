import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			String[] line = sc.nextLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int d = Integer.parseInt(line[1]);
			
			line = sc.nextLine().split(" ");
			long[] sizes = new long[n];
			for (int i = 0; i < n; i++) {
				sizes[i] = Long.parseLong(line[i]);
			}
			
			System.out.println(
					"Case #" + (index + 1) + ": " +  cut(d, sizes)
			);
		}
		sc.close();
		
	}
	
	private static int cut(int d, long[] sizes) {
		Arrays.sort(sizes);
		if (d == 2) {
			for (int i = 0; i < sizes.length - 1; i++) {
				if (sizes[i] == sizes[i + 1]) {
					return 0;
				}
			}
			return 1;
		} else { // d == 3
			int ret = 2;
			for (int i = 0; i < sizes.length - 1; i++) {
				if (sizes[i] == sizes[i + 1] && i < sizes.length - 2) {
					if (sizes[i] == sizes[i + 2]) {
						return 0;
					} else {
						ret = 1;
					}
				}
			}
			
			if (ret < 2) {
				return ret;
			}
			
			for (int i = 0; i < sizes.length; i++) {
				for (int j = i + 1; j < sizes.length; j++) {
					long val = sizes[j] - 2 * sizes[i];
					if (val == 0) {
						return 1;
					} else if (val > 0) {
						continue;
					}
				}
			}
			return 2;
		}
	}
}

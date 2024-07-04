import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.r2.task1.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\r2\\task1\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = Integer.parseInt(in.nextLine());

			for (int t = 1; t <= T; t++) {
				String[] line = in.nextLine().split(" ");
				long L = Long.parseLong(line[0]);
				long R = Long.parseLong(line[1]);

				long S = L + R;
				long max = (long) Math.floor((Math.sqrt(1 + 8 * S) - 1) / 2);
				
				long D = Math.abs(L - R);				
				long count = 0;
				if (D > 0) {
					count = (long) Math.floor((Math.sqrt(1 + 8 * D) - 1) / 2);
				}
				if (R > L && count > 0) {
					R -= count * (count + 1) / 2;
				} else {
					L -= count * (count + 1) / 2;
				}
				boolean isLeft = L >= R;
				if (!isLeft) {
					long b = R;
					R = L;
					L = b;
				}
				
				long more = max - count;
				long cl = (more + 1) / 2;
				long cr = more / 2;
				long suml = (count + 1) * cl + cl * (cl - 1);
				if (suml > L) {
					cl--;
					suml = (count + 1) * cl + cl * (cl - 1);
					max--;
				}
				long sumr = (count + 2) * cr + cr * (cr - 1);
				if (sumr > R) {
					cr--;
					sumr = (count + 2) * cr + cr * (cr - 1);
					max--;
				}
				
				L -= suml;
				R -= sumr;
				if (!isLeft) {
					long b = R;
					R = L;
					L = b;
				}
				
				System.out.println("Case #" + t + ": " + max + " " + L + " " + R);
			}
		}
	}
}

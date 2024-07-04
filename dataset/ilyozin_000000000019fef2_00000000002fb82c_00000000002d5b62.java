import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream stream = Solution.class.getName().equals("year2020.r1b.task1.Solution") ?
				new FileInputStream("C:\\Users\\One\\eclipse-workspace\\Test\\src\\year2020\\r1b\\task1\\in.txt") :
					System.in;
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(stream)))) {
			int T = Integer.parseInt(in.nextLine());

			for (int t = 1; t <= T; t++) {
				String[] line = in.nextLine().split(" ");
				long H = Long.parseLong(line[0]);
				long V = Long.parseLong(line[1]);
				
				List<String> path = new ArrayList<>();
				if ((Math.abs(V) + Math.abs(H)) % 2 == 1) {
					long v = V;
					long h = H;
					
					long div = 2;
					long d2 = 1;
					for (int i = 0; i < 32; i++) {
						if (Math.abs(v) == d2) {
							path.add(v == d2 ? "N" : "S");
							v = 0;
						} else if (Math.abs(h) == d2) {
							path.add(h == d2 ? "E" : "W");
							h = 0;
						} else if (Math.abs(v) % div != 0) {
							if (Math.abs(h) % (div * 2) != 0) {
								if (Math.abs(v) % (div * 2) == 0) {
									path.add(v > 0 ? "N" : "S");
									v -= v > 0 ? d2 : -d2;
								} else {
									path.add(v < 0 ? "N" : "S");
									v += v > 0 ? d2 : -d2;
								}
							} else {
								if (Math.abs(v) % (div * 2) != 0) {
									path.add(v > 0 ? "N" : "S");
									v -= v > 0 ? d2 : -d2;
								} else {
									path.add(v < 0 ? "N" : "S");
									v += v > 0 ? d2 : -d2;
								}
							}
						} else if (Math.abs(h) % div != 0) {
							if (Math.abs(v) % (div * 2) != 0) {
								if (Math.abs(h) % (div * 2) == 0) {
									path.add(h > 0 ? "E" : "W");
									h -= h > 0 ? d2 : -d2;
								} else {
									path.add(h < 0 ? "E" : "W");
									h += h > 0 ? d2 : -d2;
								}
							} else {
								if (Math.abs(h) % (div * 2) != 0) {
									path.add(h > 0 ? "E" : "W");
									h -= h > 0 ? d2 : -d2;
								} else {
									path.add(h < 0 ? "E" : "W");
									h += h > 0 ? d2 : -d2;
								}
							}
						} else {
							path.clear();
							break;
						}
						
						if (v == 0 && h == 0)
							break;
						
						d2 *= 2;
						div *= 2;
					}
					
					if (v != 0 || h != 0) {
						path.clear();
					}
				}
				
				System.out.print("Case #" + t + ": ");
				if (path.isEmpty()) {
					System.out.println("IMPOSSIBLE");
				} else {
					for (String s : path) {
						System.out.print(s);
					}
					System.out.println();
				}
			}
		}
	}
}

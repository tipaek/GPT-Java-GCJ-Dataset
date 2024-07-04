package qualificationRound;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			String jamie = new String(new char[1441]).replace("\0", "0");
			String cameron = new String(new char[1441]).replace("\0", "0");
			int n = in.nextInt();
			String solution = "";
			for (int j = 0; j < n; j++) {
				int beginTime = in.nextInt();
				int endTime = in.nextInt();
				if (!jamie.substring(beginTime, endTime).contains("1")) {
					solution = solution + "J";
					String part1 = jamie.substring(0, beginTime);
					String part2 = 
							jamie.substring(beginTime, endTime).replace("0", "1");
					String part3 = jamie.substring(endTime, jamie.length());
					jamie = part1 + part2 + part3;
				} else if (!cameron.substring(beginTime, endTime).contains("1")) {
					solution = solution + "C";
					String part1 = cameron.substring(0, beginTime);
					String part2 = 
							cameron.substring(beginTime, endTime).replace("0", "1");
					String part3 = cameron.substring(endTime, cameron.length());
					cameron = part1 + part2 + part3;
				} else {
					solution = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}

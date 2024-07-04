import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			int len = in.nextInt();
			in.nextLine();
			String before = "";
			String after = "";
			boolean suc = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				String k = in.nextLine().trim();
				int ast = k.indexOf('*');
				if (ast == -1) {
					suc = false;
					break;
				}
				if (before.startsWith(k.substring(0, ast)));
				else if (k.startsWith(before))
					before = k.substring(0, ast);
				else {
					suc = false;
					break;
				}
				if (k.endsWith(after))
					after = k.substring(ast + 1);
				else if (!after.endsWith(k.substring(ast + 1))) {
					suc = false;
					break;
				}
			}
			System.out.println("Case #" + y + ": " + (suc ? before + after : '*'));
		}
		in.close();
	}
}

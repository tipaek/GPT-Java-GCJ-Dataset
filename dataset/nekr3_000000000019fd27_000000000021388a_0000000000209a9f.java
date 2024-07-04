import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for (int x = 1; x <= t; x++) {
			String cur = in.nextLine();
			int nest = 0;
			String out = "";
			for (int i = 0; i < cur.length(); i++) {
				int num = Integer.parseInt(cur.charAt(i) + "");
				for ( ; nest < num; nest++) out = out + "(";
				for ( ; nest > num; nest--) out = out + ")";
				out = out + num;
			}
			for ( ; nest > 0; nest--) out = out + ")";
			System.out.println("Case #" + x + ": " + out);
		}
	}
}

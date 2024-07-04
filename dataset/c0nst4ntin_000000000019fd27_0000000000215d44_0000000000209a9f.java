import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		in.nextLine();
		for (int _t = 1; _t <= t; ++_t) {
			String str = in.nextLine();
			str = "0"+ str;
			str += "0";
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				char c1 = i < str.length()-1 ? str.charAt(i+1) : c;

				int diff = c-c1;
				if (diff < 0) {
					result += c;
					for (int j = 0; j < Math.abs(diff); j ++) {
						result += "(";
					}
				} else if (diff > 0) {
					result += c;
					for (int j = 0; j < Math.abs(diff); j ++) {
						result += ")";
					}
				} else {
					result += c;
				}
			}
			System.out.println("Case #" + _t + ": " + result.substring(1, result.length()-1));
		}
	}

}

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			String s = in.next();
			String out = "";
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < s.length(); j++) 
				list.add(Integer.parseInt(Character.toString(s.charAt(j))));
			for (int j = 0; j < s.length(); j++) {
				for (int k = list.get(j); k > 0; k--) {
					if (out.length() != 0 && out.charAt(out.length() - 1) == ')')
						out = out.substring(0, out.length() - 1);
					else
						out += "(";
				}
				out += list.get(j);
				for (int k = list.get(j); k > 0; k--)
					out += ")";
			}
			System.out.println("Case #" + i + ": " + out);
		}
	}
}
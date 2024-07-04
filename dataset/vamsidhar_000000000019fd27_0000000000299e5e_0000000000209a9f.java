import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int i =1;
		int left = 0;
		while (i<=n) {
			StringBuilder sb = new StringBuilder();
			char[] test = reader.readLine().toCharArray();
			char prev = ' ';
			for (char c : test) {
				if (prev == c) {
					sb.append(c);
					continue;
				} else {
					prev = c;
					while (left > 0) {
						sb.append(")");
						left--;
					}
				}
				int num = Character.getNumericValue(c);
				while (left < num) {
					sb.append("(");
					left++;
				}

				sb.append(c);
			}
			while (left > 0) {
				sb.append(")");
				left--;
			}
			
			System.out.println("Case #" +i+": "+ remove(sb.toString()));
			i++;
		}
	}

	private static String remove(String str) {
		while(str.contains(")(")){
			str = str.replaceAll("\\)\\(", "");
		}
		return str;
	}
}

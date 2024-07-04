import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			String input = bufread.readLine();
			StringBuilder sb = new StringBuilder();
			int nestingDepth = 0;
			for (int i = 0; i < input.length(); i++) {
				int num = Character.getNumericValue(input.charAt(i));
				if (nestingDepth < num) {
					for (int j = 0; j < num - nestingDepth; j++) {
						sb.append("(");
					}
				} else if (nestingDepth > num) {
					for (int j = 0; j < nestingDepth - num; j++) {
						sb.append(")");
					}
				}
				sb.append(num);
				nestingDepth = num;
			}
			for (int i = 0; i < nestingDepth; i++) {
				sb.append(")");
			}
			System.out.println("Case #" + (counter + 1) + ": " + sb.toString());
		}
		bufread.close();
	}

}

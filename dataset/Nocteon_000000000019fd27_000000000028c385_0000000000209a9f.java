import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(kb.readLine());
		for(int cc = 1; cc <= cases; cc++) {
			System.out.print("Case #" + cc + ": ");
			int current = 0;
			String line = kb.readLine();
			String result = "";
			for(int i = 0; i < line.length(); i++) {
				int c = Integer.parseInt(line.substring(i,i+1));
				while(c > current) {
					result+="(";
					current++;
				}
				while(c < current) {
					result+=")";
					current--;
				}
				result += c;
			}
			while(current > 0) {
				current--;
				result+=")";
			}
			System.out.println(result);
		}
	}
}

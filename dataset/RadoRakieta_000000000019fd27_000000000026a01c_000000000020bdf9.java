import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String currLine = br.readLine();
		if(currLine != null && !currLine.isEmpty()) {
			int cases = Integer.valueOf(currLine);
			for (int i = 1; i <= cases; i++) {
				System.out.print("Case #" + i + ": CJC");
				if(i != cases) {
					System.out.println();
				}
			}
		}
	}
}
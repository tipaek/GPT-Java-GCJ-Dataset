import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int b = Integer.parseInt(br.readLine());
			String out = "";
			for (int j = 0; j < 10; j++) {
				System.out.println(j);
				out+=br.readLine();
			}
			System.out.println(out);
			if(br.readLine().equals("Y")) {
				continue;
			} else {
				System.exit(0);
			}
		}
	}

}

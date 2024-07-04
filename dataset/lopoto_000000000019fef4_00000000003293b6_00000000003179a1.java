import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int U = in.nextInt();
			
			List<Map<Character, Integer>> alphabet = new ArrayList<>();
			for (int k = 0; k < 10; k++) {
				alphabet.add(new HashMap<Character, Integer>());
			}
			
			for (int p = 0; p < Math.pow(10, 4); p++) {
				int Q = in.nextInt();
				String QString = Integer.toString(Q);
				String R = in.next();
				
				if (Q < 9) {
					for (int u = (Q + 1); u <= 9; u++) {
						alphabet.get(u).put(R.charAt(0), -1);
					}
				}
				
				for (int j = 0; j < R.length(); j++) {
					if (alphabet.get(Character.getNumericValue(QString.charAt(j))).containsKey(R.charAt(j)) &&
							alphabet.get(Character.getNumericValue(QString.charAt(j))).get(R.charAt(j)) == -1) {
						
					} else {
						alphabet.get(Character.getNumericValue(QString.charAt(j))).merge(R.charAt(j), 1, Integer::sum);
					}
				}
			}
			
			String res = "";
			
			for (int m = 0; m < 10; m++) {
				if (!alphabet.get(m).isEmpty()) {
					int max = Collections.max(alphabet.get(m).values());
					
					for (Entry<Character, Integer> entry : alphabet.get(m).entrySet()) {
					    if (entry.getValue() == max) {
					    	res += entry.getKey();
					    }
					}
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + res);
		}

	}
}

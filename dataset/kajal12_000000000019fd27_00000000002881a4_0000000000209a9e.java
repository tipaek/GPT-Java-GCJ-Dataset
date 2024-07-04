import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Kajal
 *
 */
public class Solution {

	public static void main(String[] args) {
		
		int testCases, b;
		String input[];
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
//			br = new BufferedReader(new FileReader("in.txt"));
			Map<Integer, Integer> quantum = quantumFluctuate();
			input = br.readLine().trim().split(" ");
			testCases = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);

			for (int t = 1;t <= testCases;t++) {
				StringBuilder s = new StringBuilder();
				for (int i = 1;i <= b;i++) {
					System.out.println(i);
					if (quantum.containsKey(i)) {
						br.readLine(); // ignore the output
						System.out.println(i);
						s.append(br.readLine());
					} else {
						s.append(br.readLine());
					}
				}
				System.out.println(s);
				if ("Y".equals(br.readLine())){
					continue;
				} else {
					System.exit(0);
				}
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Map<Integer, Integer> quantumFluctuate() {
		Map<Integer, Integer> quantum = new HashMap<Integer, Integer>();
		for (int i = 1;i <= 150;i+=10) {
			quantum.put(i, null);
		}
		return quantum;
	}
}

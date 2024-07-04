import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Kajal
 *
 */
public class Solution {

	public static void main(String[] args) {
		
		int testCases, n;
		String input[];
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
//			br = new BufferedReader(new FileReader("in.txt"));
			
			testCases = Integer.parseInt(br.readLine().trim());
			
			for (int t = 1;t <= testCases;t++) {
				
				Map<Integer,Integer> startEndTimesMap = new TreeMap<Integer, Integer>();
				n = Integer.parseInt(br.readLine().trim());
				
				for (int i = 0;i < n;i++) {
					input = br.readLine().trim().split(" ");
					startEndTimesMap.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
				}
				
				int cam = 0;
				int jam = 0;
				boolean impossible = false;
				StringBuilder order = new StringBuilder();
				for (int start: startEndTimesMap.keySet()) {
					if (cam <= start) {
						cam = startEndTimesMap.get(start);
						order.append("C");
					} else if (jam <= start) {
						jam = startEndTimesMap.get(start);
						order.append("J");
					} else {
						impossible = true;
						break;
					}
				}
				out.append("Case #"+t+": ");
				if (!impossible) {
					out.append(order);
				} else {
					out.append("IMPOSSIBLE");
				}
				out.append("\n");
			}
			
			System.out.println(out);
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

}

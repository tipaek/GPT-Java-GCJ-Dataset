import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
				
				Map<Integer,List<Integer>> startEndTimesMap = new TreeMap<>();
				n = Integer.parseInt(br.readLine().trim());
				
				for (int i = 0;i < n;i++) {
					input = br.readLine().trim().split(" ");
					int startTime = Integer.parseInt(input[0]);
					int endTime = Integer.parseInt(input[1]);
					if (startEndTimesMap.containsKey(startTime)) {
						List<Integer> endTimes = startEndTimesMap.get(startTime);
						endTimes.add(endTime);
						Collections.sort(endTimes);
						startEndTimesMap.put(startTime, endTimes);
					} else {
						List<Integer> endTimes = new ArrayList<>();
						endTimes.add(endTime);
						startEndTimesMap.put(startTime, endTimes);
					}
					
				}
				
				int cam = 0;
				int jam = 0;
				boolean impossible = false;
				StringBuilder order = new StringBuilder();
				for (int start: startEndTimesMap.keySet()) {
					for (int end: startEndTimesMap.get(start)) {
						if (cam <= start) {
							cam = end;
							order.append("C");
						} else if (jam <= start) {
							jam = end;
							order.append("J");
						} else {
							impossible = true;
							break;
						}
					}	
					if (impossible)
						break;
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

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
		String input[], machineInput;
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
				for (int i = 1, count = 0;i <= b && count < 150;i++) {
					System.out.println(i);
					machineInput = br.readLine();
					count++;
					if (quantum.containsKey(i) /*|| "1".equals(machineInput)*/) {
						boolean machineViewPossiblyCorrected = false;
						for (int j = 1;j <= 4;j++) {
							System.out.println(i);
							machineInput = br.readLine();
							count++;
							if ("0".equals(machineInput)) {
								s.append(machineInput);
								machineViewPossiblyCorrected = true;
								break;
							}
						}
						if (!machineViewPossiblyCorrected) {
							s.append(machineInput);
						}
						
					} else {
						s.append(machineInput);
					}
				}
				System.out.println(s);
				machineInput = br.readLine(); // Y or N
				if ("Y".equals(machineInput)){
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

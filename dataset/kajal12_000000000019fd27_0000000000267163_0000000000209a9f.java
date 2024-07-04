import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * 
 * @author Kajal
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		
		int testCases;
		String inputStr;
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
//			br = new BufferedReader(new FileReader("in.txt"));
			
			testCases = Integer.parseInt(br.readLine().trim());
			
			for (int t = 1;t <= testCases;t++) {
				StringBuilder nestedStr = new StringBuilder();
				
				int openParanthesisCount = 0; 
				inputStr = br.readLine().trim();
				
				for (char c: inputStr.toCharArray()) {
					int inputIntChar = c - '0';
					
//					if (openParanthesisCount == 0) {
//						for (int i = 0;i < inputIntChar;i++) {
//							nestedStr.append('(');
//						}
//						nestedStr.append(c);
//						openParanthesisCount += inputIntChar;
//						continue;
//					}

					if (openParanthesisCount > inputIntChar) {
						
						for (int i = 0;i < openParanthesisCount-inputIntChar;i++) {
							nestedStr.append(')');
						}
						nestedStr.append(c);
						openParanthesisCount = inputIntChar;
					} else if (openParanthesisCount < inputIntChar) {
						for (int i = 0;i < inputIntChar-openParanthesisCount;i++) {
							nestedStr.append('(');
						}
						nestedStr.append(c);
						openParanthesisCount = inputIntChar;
					}
					else {
						nestedStr.append(c);
					}
				}
				while (openParanthesisCount > 0){
					nestedStr.append(')');
					openParanthesisCount--;
				}
			
				
			out.append("Case #"+t+": ").append(nestedStr).append("\n");
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

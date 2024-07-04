import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		String[] inputs = new String[t];
		String[] outputs = new String[t];
		
		for(int i=0; i<t; i++) {
			inputs[i] = br.readLine().trim();
		}
		
		for(int i=0; i<t; i++) {
			outputs[i] =  "Case #" + (i+1) + ": " + parseDepth(inputs[i]);
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(outputs[i]);
		}
		
		br.close();
	}

	private static String parseDepth(String input) {
		
		char[] carr = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		int openBrackets = 0;
		
		for(int i=0; i<input.length(); i++) {
			char ch = carr[i];
			int requiredBrackets = Character.getNumericValue(ch);
			
			if(requiredBrackets > openBrackets) {
				while(requiredBrackets > openBrackets) {
					sb.append('(');
					openBrackets++;
				}
			}
			else if(requiredBrackets < openBrackets) {
				while(requiredBrackets < openBrackets) {
					sb.append(')');
					openBrackets--;
				}
			}
			sb.append(ch);
		}
		
		while(openBrackets > 0) {
			sb.append(')');
			openBrackets--;
		}
		return sb.toString();
			
	}

}
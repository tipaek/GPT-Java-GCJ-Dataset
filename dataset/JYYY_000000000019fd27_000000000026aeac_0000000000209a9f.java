import java.io.*;
import java.util.*;

public class Solution {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTest = Integer.parseInt(br.readLine());
	  
		for (int n = 1; n <= numTest; n++) {
			
			char[] line = br.readLine().toCharArray();
			int depth = 0;
			StringBuilder sb = new StringBuilder();
			sb.append("Case #" + n + ": ");
			for (int i = 0; i < line.length; i++) {
				int curNum = line[i] - '0';
				
				if (depth < curNum) {
					int diff = curNum - depth;
					for (int j = 0; j < diff; j++) {
						sb.append("(");
					}
					depth = curNum;
				}
				else if (depth > curNum) {
					int diff = depth - curNum;
					for (int j = 0; j < diff; j++) {
						sb.append(")");
					}
					depth = curNum;
				}
				sb.append(line[i]);
			}
			
			for (int i = 0; i < depth; i++) {
				sb.append(")");
			}
			
			System.out.println(sb.toString());
		}

	}

}
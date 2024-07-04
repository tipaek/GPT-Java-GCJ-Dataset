

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
		
		int testCases, n, square[][];
		String input[];
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
//			br = new BufferedReader(new FileReader("in.txt"));
			
			testCases = Integer.parseInt(br.readLine().trim());
			
			for (int t = 1;t <= testCases;t++) {
				
				n = Integer.parseInt(br.readLine().trim());
				square = new int[n][n];
				
				int duplicateInRows = 0;
				int diagonalSum = 0;
				for (int i = 0;i < n;i++) {
					input = br.readLine().trim().split(" ");
					
					Map<Integer, Integer> uniqueNos = map1ToN(n);
					for (int j = 0;j < n;j++) {
						square[i][j] = Integer.parseInt(input[j]);
						uniqueNos.remove(square[i][j]);
						if (i == j)
							diagonalSum += square[i][j];
					}
					if (!uniqueNos.isEmpty())
						duplicateInRows++;
				}
				
				int duplicateInColumns = 0;
				for (int i = 0;i < n;i++) {
					Map<Integer, Integer> uniqueNos = map1ToN(n);
					for (int j = 0;j < n;j++) {
						uniqueNos.remove(square[j][i]);
					}
					if (!uniqueNos.isEmpty())
						duplicateInColumns++;
				}	
				
				out.append("Case #"+t+": ").append(diagonalSum).append(" ").append(duplicateInRows)
					.append(" ").append(duplicateInColumns).append("\n");
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

	private static Map<Integer, Integer> map1ToN(int n) {
		Map<Integer, Integer> uniqueNos = new HashMap<Integer, Integer>();
		for (int i = 1;i <= n;i++) {
			uniqueNos.put(i, null);
		}
		return uniqueNos;
	}
}

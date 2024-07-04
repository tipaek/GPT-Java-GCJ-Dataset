import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNum = in.nextInt();
		
		for (int i = 1; i <= testCasesNum; i++) {
			int matrixSize = in.nextInt();
			in.nextLine(); // Consume the newline character

			List<Integer> matrix = new ArrayList<>();
			for (int j = 0; j < matrixSize; j++) {
				String[] line = in.nextLine().split(" ");
				for (String num : line) {
					matrix.add(Integer.parseInt(num));
				}
			}
			
			System.out.println("Case #" + i + ": " + calculateTrace(matrix, matrixSize) + " " + rowMaxCount(matrix, matrixSize) + " " + colMaxCount(matrix, matrixSize));
		}
	}
	
	public static int calculateTrace(List<Integer> matrix, int matrixSize) {
		int trace = 0;
		for (int i = 0; i < matrixSize; i++) {
			trace += matrix.get(i * matrixSize + i);
		}
		return trace;
	}
	
	public static int rowMaxCount(List<Integer> matrix, int matrixSize) {
		int maxCount = 0;
		for (int i = 0; i < matrixSize; i++) {
			Map<Integer, Integer> countMap = new HashMap<>();
			for (int j = 0; j < matrixSize; j++) {
				int num = matrix.get(i * matrixSize + j);
				countMap.put(num, countMap.getOrDefault(num, 0) + 1);
			}
			maxCount = Math.max(maxCount, Collections.max(countMap.values()));
		}
		return maxCount == 1 ? 0 : maxCount;
	}

	public static int colMaxCount(List<Integer> matrix, int matrixSize) {
		int maxCount = 0;
		for (int j = 0; j < matrixSize; j++) {
			Map<Integer, Integer> countMap = new HashMap<>();
			for (int i = 0; i < matrixSize; i++) {
				int num = matrix.get(i * matrixSize + j);
				countMap.put(num, countMap.getOrDefault(num, 0) + 1);
			}
			maxCount = Math.max(maxCount, Collections.max(countMap.values()));
		}
		return maxCount == 1 ? 0 : maxCount;
	}
}
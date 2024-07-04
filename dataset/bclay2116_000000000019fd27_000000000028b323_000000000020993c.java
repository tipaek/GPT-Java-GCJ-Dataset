import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<testCases;i++) {
			int matrixSize = Integer.parseInt(in.nextLine());
			int[][] matrix = new int[matrixSize][matrixSize];
			for(int j=0;j<matrixSize;j++) {
				String[] matrixEntries = in.nextLine().split(" ");
				for(int k=0;k<matrixEntries.length;k++) {
					matrix[j][k] = Integer.parseInt(matrixEntries[k]);
				}
			}
			int trace = 0;
			int rowRepeats = 0;
			int columnRepeats = 0;
			for(int j=0;j<matrixSize;j++) {
				trace += matrix[j][j];
			}
			for(int j=0;j<matrixSize;j++) {
				Set<Integer> intsSeen = new HashSet<>();
				for(int k=0;k<matrixSize;k++) {
					if(!intsSeen.add(matrix[j][k])) {
						rowRepeats++;
						break;
					}
				}
			}
			for(int j=0;j<matrixSize;j++) {
				Set<Integer> intsSeen = new HashSet<>();
				for(int k=0;k<matrixSize;k++) {
					if(!intsSeen.add(matrix[k][j])) {
						columnRepeats++;
						break;
					}
				}
			}
			sb.append("Case #").append(i+1).append(": ")
				.append(trace).append(" ").append(rowRepeats).append(" ").append(columnRepeats).append("\n");
		}
		System.out.print(sb);
	}
}

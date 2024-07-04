import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int nbTestCases = sc.nextInt();
		for(int t = 1 ; t <= nbTestCases ; ++t) {
			System.out.println(
				"Case #" + t + ": " + testCase(sc)
			);
		}
		sc.close();
	}
	
	public static String testCase(Scanner sc) throws Exception {
		//Read data
		final int matrixSize = sc.nextInt();
		List<List<Integer>> rows = new ArrayList<>(matrixSize);
		for(int r = 0 ; r < matrixSize ; ++r) {
			List<Integer> row = new ArrayList<Integer>(matrixSize);
			for(int c = 0 ; c < matrixSize ; ++c) {
				row.add(sc.nextInt());
			}
			rows.add(row);
		}
		
		//Test data
		int trace = 0;
		int rdup = 0;
		int cdup = 0;
		for(int r = 0 ; r < matrixSize ; ++r) {
			List<Integer> row = rows.get(r);
			trace += row.get(r);
			if(matrixSize - row.stream().distinct().collect(Collectors.toList()).size() != 0) {
				rdup += 1;
			}
		}
		for(int c = 0 ; c < matrixSize ; ++c) {
			final int cf = c;
			if(matrixSize - rows.stream().map(row -> row.get(cf)).distinct().collect(Collectors.toList()).size() != 0) {
				cdup += 1;
			}
		}
		
		return trace + " " + rdup + " " + cdup;
	}
	
}

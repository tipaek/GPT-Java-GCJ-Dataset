
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MatrixTrace {

	private Integer[][] intArray2D;

	MatrixTrace(int N) {
		this.intArray2D = new Integer[N][N];
	}

	public Integer[][] getIntArray2D() {
		return intArray2D;
	}

	public void setIntArray2D(Integer[][] intArray2D) {
		this.intArray2D = intArray2D;
	}

	public int calcTrace() {
		int trace = 0;
		for (int rows = 0; rows < intArray2D.length; rows++) {
			trace = trace + intArray2D[rows][rows];
		}

		// System.out.println ( "trace " + trace );
		return trace;
	}

	public int calcRepeatedRowElements() {
		int repeatElementCount = 0;

		for (int rows = 0; rows < intArray2D.length; rows++) {
			Set<Integer> set = new HashSet<Integer>();
			Integer[] row = intArray2D[rows];
			for (int i = 0; i < row.length; i++) {
				if (!set.add(row[i])) {
					repeatElementCount++;
					break;
				}
			}
			// System.out.println("Repeat count " + repeatElementCount);
		}

		return repeatElementCount;
	}

	public int calcRepeatedColElements() {
		int repeatElementCount = 0;

		for (int rows = 0; rows < intArray2D.length; rows++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int cols = 0; cols < intArray2D.length; cols++) {
				if (!set.add(intArray2D[cols][rows])) {
					repeatElementCount++;
					break;
				}
			}
		}
		// System.out.println("Repeat count " + repeatElementCount);
		return repeatElementCount;
	}

	static void print(String key, List<Integer> list) {
		System.out.print(key + " ");
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size()) {
				System.out.print(list.get(i) + " ");
			} else {
				System.out.println(list.get(i));
			}
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<MatrixTrace> twoDPracticeList = new ArrayList<MatrixTrace>();

		Map<String, List<Integer>> outResultMap = new TreeMap<String, List<Integer>>();

		int T = scanner.nextInt();
		int testCaseCounter = T;
		while (testCaseCounter > 0) {
			int N = scanner.nextInt();
			MatrixTrace twoDPractice = new MatrixTrace(N);
			int rowNum = 0;
			for (int lineSize = 0; lineSize < N; lineSize++) {
				for (int col = 0; col < N; col++) {
					twoDPractice.intArray2D[rowNum][col] = scanner.nextInt();
				}
				rowNum++;
			}

			twoDPracticeList.add(twoDPractice);
			testCaseCounter--;
		}

		for (int i = 0; i < twoDPracticeList.size(); i++) {
			List<Integer> val = outResultMap.get("Case #" + i + ":");
			if (val == null) {
				val = new ArrayList<Integer>();
				val.add(twoDPracticeList.get(i).calcTrace());
				val.add(twoDPracticeList.get(i).calcRepeatedRowElements());
				val.add(twoDPracticeList.get(i).calcRepeatedColElements());
				outResultMap.put("Case #" + i + ":", val);
			}
		}

		// System.out.println(outResultMap );

		for (String key : outResultMap.keySet()) {
			print(key, outResultMap.get(key));
			System.out.println();
		}

		scanner.close();

	}

}

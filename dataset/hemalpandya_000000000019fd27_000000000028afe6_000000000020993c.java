
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numberOfTC = sc.nextInt();

		int[] traces = new int[numberOfTC];
		int[] rowUCounts = new int[numberOfTC];
		int[] colUCounts = new int[numberOfTC];
		for (int tcI = 0; tcI < numberOfTC; tcI++) {
			int matrixN = sc.nextInt();
			int[][] inpArr = new int[matrixN][matrixN];
			int traceI = 0;
			int rowUCountI = 0;
			int colUCountI = 0;
			for (int mi = 0; mi < matrixN; mi++) {
				Set<Integer> rowUnique = new HashSet<Integer>();
				boolean isRepeatedR = false;
				for (int mj = 0; mj < matrixN; mj++) {

					Integer userInput = sc.nextInt();
					inpArr[mi][mj] = userInput;
					if (rowUnique.contains(userInput))
						isRepeatedR = true;
					else if (!isRepeatedR)
						rowUnique.add(userInput);

					if (mj == mi)
						traceI += userInput;

				}
				if (isRepeatedR)
					rowUCountI++;

			}
			rowUCounts[tcI] = rowUCountI;
			traces[tcI] = traceI;

			// col wise duplicate
			for (int mi = 0; mi < matrixN; mi++) {
				Set<Integer> colUnique = new HashSet<Integer>();
				boolean isRepeatedC = false;
				for (int mj = 0; mj < matrixN; mj++) {

					if (colUnique.contains(inpArr[mj][mi]))
						isRepeatedC = true;
					else if (!isRepeatedC)
						colUnique.add(inpArr[mj][mi]);
				}

				if (isRepeatedC)
					colUCountI++;
			}

			colUCounts[tcI] = colUCountI;

			System.out.println(String.format("Case #%d: %d %d %d", (tcI + 1), traceI, rowUCountI, colUCountI));
		}

//		System.out.println(IntStream.of(traces).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
//		System.out.println(IntStream.of(rowUCounts).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
//		System.out.println(IntStream.of(colUCounts).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
		sc.close();
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * cd /Users/ottsjo/dev/spec/codejam/target
 * cd classes && java Solution && cd ..
 */
class Solution {

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	// paste from here :)

	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private String getCaseResult(Scanner scanner) {
		int N = ScannerExtensions.getInt(scanner); // matrix size
		Matrix matrix = populateMatrix(scanner, N);

		long trace = matrix.getTrace();
		int repeatedRows = matrix.getRepeatedRows();
		int repeatedColumns = matrix.getRepeatedColumns();

		return trace + " " + repeatedRows + " " + repeatedColumns;
	}

	private Matrix populateMatrix(Scanner scanner, int n) {
		Matrix matrix = new Matrix(n);
		for (int i = 0; i < n; i++) {
			matrix.addRow(ScannerExtensions.getLongArray(scanner), i);
		}
		return matrix;
	}

	private static class Matrix {

		private final long[][] matrix;
		private final int size;

		Matrix(int size) {
			this.size = size;
			this.matrix = new long[size][size];
		}

		public long get(int row, int column) {
			return matrix[row][column];
		}

		public long getSize() {
			return size;
		}

		public void addRow(long[] row, int index) {
			matrix[index] = row;
		}

		public long getTrace() {
			long trace = 0;
			for (int i = 0; i < size; i++) {
				trace += get(i, i);
			}
			return trace;
		}

		public long[] getRow(int index) {
			return matrix[index];
		}

		public long[] getColumn(int index) {
			long[] column = new long[size];
			for (int i = 0; i < size; i++) {
				column[i] = matrix[i][index];
			}
			return column;
		}

		public int getRepeatedRows() {
			int repeated = 0;
			for (int i = 0; i < size; i++) {
				if (this.isRepeated(getRow(i))){
					repeated++;
				}
			}
			return repeated;
		}

		public int getRepeatedColumns() {
			int repeated = 0;
			for (int i = 0; i < size; i++) {
				if (this.isRepeated(getColumn(i))){
					repeated++;
				}
			}
			return repeated;
		}

		public boolean isRepeated(long[] items) {
			long distinct = LongStream.of(items)
					.boxed()
					.distinct()
					.count();
			return distinct != items.length;
		}
	}

	private static class MathUtils {
		private MathUtils() {}

		static boolean isDivisibleBy(long n, long div) {
			return n % div == 0;
		}

		static int getMaxIndex(long[] numbers) {
			int maxIndex = 0;
			for(int i=1;i < numbers.length;i++){
				if(numbers[i] > numbers[maxIndex]){
					maxIndex = i;
				}
			}
			return maxIndex;
		}

		static long getMaxValue(long[] numbers){
			return numbers[getMaxIndex(numbers)];
		}

		static int getMinIndex(long[] numbers){
			int minIndex = 0;
			for(int i=1;i < numbers.length;i++){
				if(numbers[i] < numbers[minIndex]){
					minIndex = i;
				}
			}
			return minIndex;
		}

		static long getMinValue(long[] numbers){
			return numbers[getMinIndex(numbers)];
		}

		static void primeFactors(long n, Consumer<Long> onFactor)
		{
			// Print the number of 2s that divide n
			while (n%2L==0) {
				onFactor.accept(2L);
				n /= 2L;
			}

			// n must be odd at this point.  So we can skip one element
			for (long i = 3; i <= Math.sqrt(n); i+= 2) {
				while (n%i == 0) {
					onFactor.accept(i);
					n /= i;
				}
			}

			// This condition is to handle the case when n is a prime number greater than 2
			if (n > 2L) {
				onFactor.accept(n);
			}
		}
	}

	private static class Executor {

		static void executeDefault(Function<Scanner, String> getCaseResult) {
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			execute(input, getCaseResult, System.out::println);
		}

		private static void execute(Scanner reader, Function<Scanner, String> getCaseResult, Consumer<String> resultConsumer) {
			int numberOfCases = ScannerExtensions.getInt(reader);
			for (int i = 0; i < numberOfCases; i++) {
				String result = getCaseResult.apply(reader);
				String caseString = createCaseString(i+1, result);
				resultConsumer.accept(caseString);
			}
		}

		static String createCaseString(long caseNumber, String result) {
			return "Case #" + caseNumber + ": " + result;
		}
	}

	private static class ScannerExtensions {

		private ScannerExtensions() {}

		static int getInt(Scanner scanner) {
			return Integer.parseInt(scanner.nextLine());
		}

		static long getLong(Scanner scanner) {
			return Long.parseLong(scanner.nextLine());
		}

		static double getDouble(Scanner scanner) {
			return Double.parseDouble(scanner.nextLine());
		}

		static int[] getIntArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		static long[] getLongArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}

		static double[] getDoubleArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		}
	}
}

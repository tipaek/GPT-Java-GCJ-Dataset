//package codejam;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {

	public static void main(String[] args) throws Exception {
		try(InputUtil input = new InputUtil()) {
			int t = input.readLineAsInt();
			for(int i = 0; i < t; i++)
				solve(i, input);
		}
	}

	private static void solve(int t, InputUtil input) throws Exception {
		int n = input.readLineAsInt();
		int matrix[][] = new int[n][];
		for(int i = 0; i < n; i++) {
			matrix[i] = input.readInts();
		}
		int rowsWithRepeatedNums = 0, colsWithRepeatedNums = 0, trace = 0;
		boolean visited[] = new boolean[n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited, false);
			for(int j = 0; j < n; j++) {
				if(visited[matrix[i][j] - 1]) {
					rowsWithRepeatedNums++;
					break;
				} else {
					visited[matrix[i][j] - 1] = true;
				}
			}
			Arrays.fill(visited, false);
			for(int j = 0; j < n; j++) {
				if(visited[matrix[j][i] - 1]) {
					colsWithRepeatedNums++;
					break;
				} else {
					visited[matrix[j][i] - 1] = true;
				}
			}
			
			trace += matrix[i][i];
		}
		
		System.out.println("Case #" + t + ": " + trace + " " + rowsWithRepeatedNums + " " + colsWithRepeatedNums);
	}
	
	public static class InputUtil implements Closeable {

		private final BufferedReader reader;
		
		public InputUtil() throws Exception {
			this.reader = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String nextLine() throws IOException {
			return reader.readLine();
		}
		
		
		public int readLineAsInt() throws Exception {
			return Integer.parseInt(reader.readLine().trim());
		}
		
		public long readLineAsLong() throws Exception {
			return Long.parseLong(reader.readLine());
		}
		
		public String getSpaceSeperatedInts(int[] ints) {
			return Stream.of(ints)
					.map(String::valueOf)
					.collect(Collectors.joining(" "));
		}

		public String getSpaceSeperatedBigInteger(BigInteger[] nums) {
			return Stream.of(nums)
					.map(BigInteger::toString)
					.collect(Collectors.joining(" "));
		}

		public boolean isEven(long number) {
			return number % 2 == 0;
		}

		public boolean isOdd(long number) {
			return !isEven(number);
		}

		public boolean isEven(BigInteger number) {
			return !number.testBit(1);
		}

		public boolean isOdd(BigInteger number) {
			return !isEven(number);
		}

		public int[] readInts() throws IOException {
			return toIntArray(reader.readLine());
		}

		public int[] toIntArray(String s) {
			return Stream.of(s.split("\\s"))
					.mapToInt(Integer::parseInt)
					.toArray();
		}

		public long[] readLongs() throws IOException {
			return toLongArray(reader.readLine().trim());
		}

		public String[] readStrings() throws IOException {
			return reader.readLine().split("\\s");
			
		}
		
		
		public long[] toLongArray(String s) {
			return Stream.of(s.split("\\s"))
					.mapToLong(Long::parseLong)
					.toArray();
		}

		public BigInteger[] readBigInts() throws IOException {
			return toBigIntArray(reader.readLine());
		}

		public BigInteger[] toBigIntArray(String s) {
			String[] nums = s.split("\\s");
			return IntStream.range(0, nums.length)
					.boxed()
					.map(index -> new BigInteger(nums[index]))
					.toArray(size -> new BigInteger[size]);

		}

		public char[] readChars() throws IOException {
			return reader.readLine().toCharArray();
		}

		public BufferedReader getReader() {
			return reader;
		}
		
		@Override
		public void close() throws IOException {
			reader.close();
		}

	}
	
}

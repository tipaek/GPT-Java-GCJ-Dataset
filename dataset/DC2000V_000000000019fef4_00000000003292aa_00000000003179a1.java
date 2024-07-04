//package codejam;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {

	public static void main(String[] args) throws IOException, Exception {
		try(InputUtil input = new InputUtil()) {
			int t = input.readLineAsInt();
			for(int i = 0; i < t; i++)
				solve(input, i);
				
			
			
			
		}
		
		
		
		
		
	}

	private static void solve(InputUtil input, int t) throws IOException {
		input.nextLine();
		String[][] question = new String[10_000][];
		Set<Character> allChars = new HashSet<>(10);
		for(int i = 0; i < question.length; i++) {
			question[i] = input.readStrings();
			for(int j = 0; j < question[i][1].length(); j++) {
				allChars.add(question[i][1].charAt(j));
			}
		}
		Map<Character, Integer> mapping = new HashMap<>();
		for(int i = 0; i < question.length; i++) {
			final int i2 = i;
			if(!"-1".equals(question[i][0]) && question[i][0].length() == question[i][1].length()) {
				for(int j = 0; j < 1; j++) {
					final int j2 = j;
					mapping.computeIfPresent(question[i][1].charAt(j), (key, value) -> Math.min(value, question[i2][0].charAt(j2) - '0'));
					mapping.computeIfAbsent(question[i][1].charAt(j), (key) -> question[i2][0].charAt(j2) - '0');
				}
			}
		}
		allChars.removeAll(mapping.keySet());
		Iterator<Character> it = allChars.iterator();
		char[] result = new char[10];
		Arrays.fill(result, ((char)11));
		for(char c : mapping.keySet()) {
			result[mapping.get(c)] = c;
		}
		for(int i = 0; i < 10; i++) {
			if(result[i] == (char)11) {
				result[i] = it.next();
			}
		}
		
		System.out.println("Case #" + t + ": " + new String(result));
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
			return toLongArray(reader.readLine());
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

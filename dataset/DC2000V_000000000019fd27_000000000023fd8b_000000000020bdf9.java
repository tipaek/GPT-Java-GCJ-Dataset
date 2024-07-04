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
	
	
	public static void main(String[] args) throws Exception {
		try(InputUtil input = new InputUtil()) {
			int t = input.readLineAsInt();
			for(int i = 0; i < t; i++)
				solve(i + 1, input);
		}
	}

	private static class Span {
		final int start, end;
		byte occupiedBy = 0;
		public Span(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		void setOccupiedByCameron() {
			this.occupiedBy = 'c';
		}
		
		void setOccupiedByJamie() {
			this.occupiedBy = 'j';
		}
	}
	
	private static void solve(int t, InputUtil input) throws Exception {
		int n = input.readLineAsInt();
		byte[] minutes = new byte[24 * 60];
		Span pairs[] = new Span[n];
		for(int i = 0; i < n; i++) {
			int[] se = input.readInts();
			pairs[i] = new Span(se[0], se[1]);
		}
		Span[] copy = Arrays.copyOf(pairs, n);
		Arrays.sort(pairs, (a, b) -> Integer.compare(a.start, b.start) == 0 ? Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start));
		for(Span s: pairs) {
			boolean c = false, j = false;
			for(int i = s.start; i < s.end; i++) {
				if(minutes[i] == 'c') {
					c = true;
				} else if(minutes[i] == 'j') {
					j = true;
				} else if(minutes[i] == 'b') {
					c = true;
					j = true;
					break;
				}
			}
			if(!c && !j) {
				Arrays.fill(minutes, s.start, s.end, (byte)'c');
				s.setOccupiedByCameron();
			} else if(c && !j) {
				for(int i = s.start; i < s.end; i++) {
					minutes[i] = (byte) ((minutes[i] == 'c') ? 'b' : 'j');
				}
				s.setOccupiedByJamie();
			} else if(j && !c) {
				for(int i = s.start; i < s.end; i++) {
					minutes[i] = (byte) ((minutes[i] == 'j') ? 'b' : 'c');
				}
				s.setOccupiedByCameron();
			} else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				return;
			}
		}
		System.out.print("Case #" + t + ": ");
		for(int i = 0; i < n; i++) {
			System.out.print((char)copy[i].occupiedBy);
		}
			
		System.out.println();
	}
	
}

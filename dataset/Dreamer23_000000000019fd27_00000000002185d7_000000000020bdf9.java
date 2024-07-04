import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	
	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int c = 1; c <= t; ++c) {
			System.out.println("Case #" + c + ": " + getResult(Integer.parseInt(in.nextLine()), in));
		}
		in.close();
	}


	// Seems straight forward enough? Just sort and assign to whoever is free, right?
	private static String getResult(final int numChores, final Scanner in) {
		final List<HouseholdChore> chores = new ArrayList<>(numChores);
		final char[] choreAssignment = new char[numChores];
		for(int i = 0; i < numChores; i++) {
			String[] inp = in.nextLine().split(" ");
			final HouseholdChore chore = new HouseholdChore(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), i);
			chores.add(chore);
		}
		Collections.sort(chores);
		int cameronFreeAt = 0;
		int jamieFreeAt = 0;
		for (int i = 0; i < numChores; i++) {
			final HouseholdChore chore = chores.get(i);
			final int startTime = chore.startTime;
			if (startTime >= cameronFreeAt) {
				cameronFreeAt = chore.endTime;
				choreAssignment[chore.originalPosition] = 'C';
			} else if (startTime >= jamieFreeAt) {
				jamieFreeAt = chore.endTime;
				choreAssignment[chore.originalPosition] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(choreAssignment);
	}
	
	private static class HouseholdChore implements Comparable<HouseholdChore> {
		private final int startTime, endTime, originalPosition;

		private HouseholdChore(final int startTime, final int endTime, final int originalPosition) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.originalPosition = originalPosition;
		}
		
		@Override
		public int compareTo(HouseholdChore o) {
			return this.startTime - o.startTime;
		}
		
	}

}

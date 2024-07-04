
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
		for (int x = 1; x <= t; ++x) {
			int patterns = Integer.parseInt(in.nextLine());
			System.out.println("Case #" + x + ": " + getResult(patterns, in));
		}
		in.close();
	}
		
	private static String getResult(int patterns, Scanner in) {
		Set<String> beginsWith = new HashSet<>();
		Set<String> endsWith = new HashSet<>();
		List<MiddlePart> middleParts = new ArrayList<>();
		for (int n = 0; n < patterns; n++) {
			String[] s = in.nextLine().split("\\*", -1);
			if(s[0].length() > 0) beginsWith.add(s[0]);
			if(s[s.length-1].length() > 0) endsWith.add(s[s.length-1]);
			if (s.length > 2) {
				middleParts.add(new MiddlePart(s));
			}
		}
		String beginning = areConsistentBeginStrings(beginsWith);
		if (beginning == null) return "*";
		String end = areConsistentEndStrings(endsWith);
		if (end == null) return "*";
		
		// Middle Parts:
		// So the problem is, I can't just stack them all together since 10^4 > 50*100
		// I'll just do some hopeful length-based sorting and contains and hope that's good enough :)
		// If not I'll come back after other problems.
		Collections.sort(middleParts);
		Collections.reverse(middleParts);
		String middlePart = "";
		for(MiddlePart mp : middleParts) {
			boolean maybeContains = true;
			String tempMiddle = middlePart;
			for(String s : mp.strings) {
				if(!maybeContains) {
					middlePart += s;
					continue;
				}
				int maybeIndex = tempMiddle.indexOf(s);
				if (maybeIndex == -1) {
					maybeContains = false;
					middlePart += s;
					continue;
				}
				int newIndex = maybeIndex + s.length();
				if (newIndex == tempMiddle.length()) tempMiddle = "";
				else tempMiddle = tempMiddle.substring(maybeIndex + newIndex);
			}
		}
		
		return beginning + middlePart + end;
	}
	
	private static class MiddlePart implements Comparable<MiddlePart>{
		private String[] strings;
		private int length;
		private MiddlePart(String[] fullLine) {
			length = 0;
			strings = new String[fullLine.length-2];
			for(int i = 1; i < fullLine.length-1;i++) {
				strings[i-1] = fullLine[i];
				length += strings[i-1].length();
			}
		}
		@Override
		public int compareTo(MiddlePart o) {
			return length - o.length;
		}
	}
	
	private static String areConsistentBeginStrings(Set<String> strs) {
		String longest = "";
		for(String s : strs) {
			if(s.length() >= longest.length()) {
				if(!s.startsWith(longest)) return null;
				longest = s;
			} else if (!longest.startsWith(s)) return null;
		}
		return longest;
	}
	
	private static String areConsistentEndStrings(Set<String> strs) {
		String longest = "";
		for(String s : strs) {
			if(s.length() >= longest.length()) {
				if(!s.endsWith(longest)) return null;
				longest = s;
			} else if (!longest.endsWith(s)) return null;
		}
		return longest;
	}
}

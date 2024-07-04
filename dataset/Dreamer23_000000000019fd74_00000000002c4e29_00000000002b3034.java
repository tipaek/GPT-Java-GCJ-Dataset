
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
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
			String m = in.nextLine();
			while(m.contains("**")) m = m.replace("**", "*"); 
			String[] s = m.split("\\*", -1);
			System.out.println(s.length);
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
		/*
		 * This was attempt 1. Ran into RE (answer > 1000 = RE)
		 * New attempt: BFS the order
		 */
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
		/* Meh, getting too complicated; there has to be a better way
		String middlePart = null;
		Queue<MiddlePartState> queue = new ArrayDeque<>();
		queue.add(new MiddlePartState("", middleParts));
		while(queue.isEmpty()) {
			MiddlePartState curr = queue.poll();
			if(middlePart != null && curr.currentMiddlePart.length() > middlePart.length()) continue;
			List<MiddlePart> trimmedMiddleParts = new ArrayList<>();
			for(int i = 0; i < curr.middleParts.size(); i++) {
				MiddlePart mNew = new MiddlePart();
				MiddlePart mOld = curr.middleParts.get(i);
				int offset = mOld.currentOffset;
				for(int n = 0; n < mOld.strings.length; n++) {
					String s = mOld.strings[n];
					int maybeIndex = curr.currentMiddlePart.indexOf(s);
					if(maybeIndex == -1) {
						mNew.strings = new String[mOld.strings.length-n];
						for(int x = n; x < mOld.strings.length; x++) mNew.strings[x - n] = mOld.strings[x];
						mNew.currentOffset = offset;
						break;
					}  else {
						offset += maybeIndex + s.length();
					}
				}
				if(mNew.le)
				if(mNew.length > 0) trimmedMiddleParts.add(mNew);
			}
			for(int n = 0; n < trimmedMiddleParts.size(); n++) {
				List<MiddlePart> clone = new ArrayList<>();
				for (int l = 0; l < trimmedMiddleParts.size(); l++)
				MiddlePartState st = new MiddlePartState();
			}
				
			if(curr.middleParts.size() == 0) {
				if (middlePart == null || curr.currentMiddlePart.length() < middlePart.length()) middlePart = curr.currentMiddlePart;
				continue;
			}
		}*/
		
		return beginning + middlePart + end;
	}
	
	private static class MiddlePartState {
		public MiddlePartState(String currentMiddlePart, List<MiddlePart> middleParts) {
			super();
			this.currentMiddlePart = currentMiddlePart;
			this.middleParts = middleParts;
		}
		String currentMiddlePart;
		List<MiddlePart> middleParts;
	}
	
	private static class MiddlePart implements Comparable<MiddlePart>{
		private String[] strings;
		private int length;
		private int currentOffset = 0;
		private MiddlePart() {
		}
		
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

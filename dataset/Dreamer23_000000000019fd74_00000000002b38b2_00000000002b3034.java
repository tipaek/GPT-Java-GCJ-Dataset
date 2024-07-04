
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		Set<List<String>> middleParts = new HashSet<>();
		for (int n = 0; n < patterns; n++) {
			String[] s = in.nextLine().split("\\*");
			if(s[0].length() > 0) beginsWith.add(s[0]);
			if(s[s.length-1].length() > 0) endsWith.add(s[s.length-1]);
			if (s.length > 2) {
				List<String> middleP = new ArrayList<>();
				for (int i = 1; i < s.length-1;i++) middleP.add(s[i]);
				middleParts.add(middleP);
			}
		}
		String beginning = areConsistentBeginStrings(beginsWith);
		if (beginning == null) return "*";
		String end = areConsistentEndStrings(endsWith);
		if (end == null) return "*";
		
		// TODO: Middle Parts
		
		return beginning + end;
	}
	
	private static String areConsistentBeginStrings(Set<String> strs) {
		String longest = "";
		for(String s : strs) {
			if(s.length() >= longest.length()) {
				if(!s.startsWith(longest)) return null;
				longest = s;
			}
		}
		return longest;
	}
	
	private static String areConsistentEndStrings(Set<String> strs) {
		String longest = "";
		for(String s : strs) {
			if(s.length() >= longest.length()) {
				if(!s.endsWith(longest)) return null;
				longest = s;
			}
		}
		return longest;
	}
}

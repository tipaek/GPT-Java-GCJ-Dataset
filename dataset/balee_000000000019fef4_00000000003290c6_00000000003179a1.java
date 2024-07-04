import java.io.FileInputStream;
import java.util.*;

public class Solution {

	static class Info implements Comparable<Info> {
		public int count;
		public char chr;
		Info(char chr, int count) {
			this.count = count;
			this.chr = chr;
		}
		@Override
		public String toString() {
			return chr+"-"+count;
		}
		@Override
		public int compareTo(Info o) {
			return o.count - count;
		}
	}


	private static String process(Scanner in) {

		Set<Character> s = new HashSet<>();

		int U = in.nextInt();
		int[] digitCount = new int[255]; 
		for(int i = 0; i < 10000; i++) {
			char[] qDigitsNotUsed = in.next().toCharArray();
			char[] rDigits = in.next().toCharArray();
			if (rDigits.length == U) 
				digitCount[rDigits[0]]++;
			for(int j = 0; j < rDigits.length; j++)
				s.add(rDigits[j]);
		}
		ArrayList<Info> info = new ArrayList<>();
		char[] result = new char[10];
		for(char i = 'A'; i <= 'Z'; i++) {
			if (digitCount[i] > 0) {
				//System.out.println(i + " " + digitCount[i]);
				info.add(new Info(i, digitCount[i]));
			}
		}

		//Arrays.sort(info, (a,b) -> a.count - b.count);
		Collections.sort(info);

		for(int i = 0; i < info.size(); i++) {
			result[i+1] = info.get(i).chr;
			s.remove(info.get(i).chr);
		}
	
		result[0] = s.iterator().next();

		//System.out.println(info);

		return new String(result);
	}

	private static String processOrig(Scanner in) {

		int U = in.nextInt();
		int[] maxCharPos = new int[255]; 
		for(int i = 'A'; i <= 'Z'; i++)
			maxCharPos[i] = 99;
		for(int i = 0; i < 10000; i++) {
			char[] qDigits = in.next().toCharArray();
			char[] rDigits = in.next().toCharArray();
			if (qDigits.length == rDigits.length) {
				int digit = qDigits[0] - '0';
				if (digit < maxCharPos[rDigits[0]])
					maxCharPos[rDigits[0]] = digit;
			}
			for(int j = 0; j < rDigits.length; j++)
				if (maxCharPos[rDigits[j]] > 10)
					maxCharPos[rDigits[j]] = 10;
		}
		char[] result = new char[10];
		for(char i = 'A'; i <= 'Z'; i++) {
			if (maxCharPos[i] <= 10) {
				//System.out.println(i + " " + maxCharPos[i]);
				if (maxCharPos[i] == 10)
					result[0] = i;
				else
					result[maxCharPos[i]] = i; 
			}
		}			
		return new String(result);
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in.available() > 0 ? System.in : 
			new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) 
			System.out.format("Case #%d: %s\n", i, process(in));
	}
}

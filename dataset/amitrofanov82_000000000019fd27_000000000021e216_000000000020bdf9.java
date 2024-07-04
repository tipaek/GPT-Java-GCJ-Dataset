import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Alexey")) {
			sc = new Scanner(new FileInputStream("input.txt"));;
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < testCases + 1; i++) {
			int intervals = Integer.parseInt(sc.nextLine());
			Range[] input = new Range[intervals];
			for (int j = 0; j < intervals; j++) {
				String[] vals = sc.nextLine().split(" ");
				input[j] = new Range(vals[0], vals[1]);
			}
			String result = readAndresolveSingleCase(input);
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndresolveSingleCase(Range[] input) {
		StringBuilder result = new StringBuilder();
		Range[] sortedInput = Arrays.copyOf(input, input.length);
		Arrays.sort(sortedInput);
		//System.err.println(Arrays.toString(sortedInput));
		
		int balance = 0;
		int cIsFreeAt = 0;
		int jIsFreeAt = 0;
		for (int i = 0; i < sortedInput.length; i++) {
			if (balance == 2) {
				if (jIsFreeAt <= sortedInput[i].start && cIsFreeAt <= sortedInput[i].start) {
					balance-=2;
				} else if (jIsFreeAt <= sortedInput[i].start || cIsFreeAt <= sortedInput[i].start) {
					balance--;
				} else {
					return "IMPOSSIBLE";
				}
			}
			if (balance == 1) {
				if (cIsFreeAt <= sortedInput[i].start) {
					balance--;
				} else {
					balance++;
					sortedInput[i].who = 'J';
					jIsFreeAt = sortedInput[i].end;
				}
			}
			if (balance == 0) {
				balance++;
				sortedInput[i].who = 'C';
				cIsFreeAt = sortedInput[i].end;
			}

		}
		
		for (int i = 0; i < input.length; i++) {
			result.append(input[i].who);
		}
		return result.toString();
	}

}

class Range implements Comparable<Range> {
	
	public int start;
	public int end;
	Character who = null;
	
	Range(int s, int e)  {
		start = s; end = e;		
	}
	
	Range(String s, String e)  {
		start = Integer.parseInt(s); end = Integer.parseInt(e);		
	}
	
	@Override
	public int compareTo(Range arg0) {
		return start - arg0.start;
	}
	
	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
	
}









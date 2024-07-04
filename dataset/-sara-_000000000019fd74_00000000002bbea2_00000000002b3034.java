import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			in.nextLine();
			List<String> patterns = new ArrayList<String>();
			List<String> endings = new ArrayList<String>();
			List<Integer> lengths = new ArrayList<Integer>();
			int maxLength = 0;
			String solution = "";
			for (int j = 0; j < n; j++) {
				patterns.add(in.nextLine());
				endings.add(patterns.get(j).substring(1));
				lengths.add(endings.get(j).length());
				if (lengths.get(j) > maxLength) {
					maxLength = lengths.get(j);
				}
			}
			String endingPattern = endings.get(lengths.indexOf(maxLength));
			boolean possible = true;
			for (int j = 0; j < n; j++) {
				if(!endingPattern.contains(endings.get(j))) {
					possible = false;
					break;
				}
			}
			if(possible) {
				solution = endingPattern;
			} else {
				solution = "*";
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}

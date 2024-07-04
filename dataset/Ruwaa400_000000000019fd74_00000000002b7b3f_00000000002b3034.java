import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int dummy = 0;
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		String s;
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			ArrayList<String> arr = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				s = scanner.next();
				s = s.replace("*", "");
				arr.add(s);
			}

			Collections.sort(arr, new Comparator<String>() {// Descending order

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.length() - o1.length();
				}
			});

			String maxLen = arr.get(0);
			int count = 0;
			while (count != n) {
				String test = arr.get(count);
				if(test.equals("")) {
					count ++;
					continue;
				}
				if(maxLen.contains(test)) {
					if((maxLen.indexOf(test) + test.length()) < n) {
						break;
					}
					count ++;
				}
				else {
					break;
				}
			}
			dummy = i+1;
			if(count != n) {
				System.out.println("Case #"+dummy+":"+" *");
			}
			else {
				System.out.println("Case #"+dummy+":"+" "+maxLen);				
			}
		}

	}

}

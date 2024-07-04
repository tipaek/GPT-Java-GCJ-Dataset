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
		String s, x;
		int countT1 = 0;
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			ArrayList<String> arr1 = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				s = scanner.next();
				if (s.indexOf("*") == 0) {
					x = s.replaceFirst("*", "");
					if (!x.contains("*")) {
						countT1++;
					}
				}
//				s = s.replace("*", "");
				arr1.add(s);
			}
			
			ArrayList<String> arr = new ArrayList<String>();			
			if(countT1 == n) {
				for (int j = 0; j < n; j++) {
					s = arr1.get(j).replace("*", "");
					arr.add(s);
				}
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
				
				if (maxLen.contains(test)) {
					if ((maxLen.lastIndexOf(test) + test.length()) < maxLen.length()) {
						break;
					}
					count++;
				} else {
					break;
				}
			}
			dummy = i + 1;
			if (count != n) {
				System.out.println("Case #" + dummy + ":" + " *");
			} else {
				System.out.println("Case #" + dummy + ":" + " " + maxLen);
			}
		}

	}

}

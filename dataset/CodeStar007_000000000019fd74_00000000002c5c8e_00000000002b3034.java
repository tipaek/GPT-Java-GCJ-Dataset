
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static void solve(int N, String[] patterns, int test_num) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < patterns.length; i++) {
			String S = patterns[i];
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) != '*') {
					sb.append(S.charAt(j));
				}
			}
			list.add(sb.toString());
		}
		
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length()>o2.length()) {
					return 1;
				}else if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}else {
					return -1;
				}
			}
			
		});

		boolean flag=false;
		
		String check=list.get(patterns.length-1);
		
		for(int i=0;i<list.size()-1;i++) {
			String check2=list.get(i);
			if(isSubSequence(check2, check, check2.length(), check.length())) {
				flag=true;
			}else {
				flag=false;
			}
		}
		
		if(flag==true) {
			System.out.println("Case #" + test_num + ": " +check);
			return;
		}
		System.out.println("Case #" + test_num + ": " +"*");
	}

	static boolean isSubSequence(String str1, String str2, int m, int n) {
		int j = 0;
		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		return (j == m);
	}

}

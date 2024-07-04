import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int [] s = new int[n];
			int [] e = new int[n];
			int [] result = new int[n];
			
			for(int j=0; j<n; j++) {
				s[j] = sc.nextInt();
				e[j] = sc.nextInt();
			}
			System.out.println("Case #"+(i+1)+": "+calcOverlap(s, e));
		}
	}
	
	public static String calcOverlap(int [] s, int []e) {
		ArrayList[] result = new ArrayList[s.length];
		for(int i=0; i<s.length; i++) {
			int overlap = 0;
			ArrayList<Integer> index = new ArrayList<Integer>();
			for(int k=0; k<i; k++) {
				if(s[i] > s[k] && s[i] < e[k]) {
					overlap++;
					index.add(k);
				}
				if(e[i] > s[k] && e[i] < e[k]) {
					overlap++;
					index.add(k);
				}
			}
			if(overlap > 0) {
				result[i] = index;
			}
		}
		
		String str = "";
		for(int i=0; i<result.length; i++) {
			if(result[i] == null) {
				str += "J";
			}else {
				String busy = "";
				for(int j=0; j<result[i].size(); j++) {
					int temp = (int) result[i].get(j);
					if(str.substring(temp, temp+1).equals("J")) {
						busy += "J";
					}else {
						busy += "C";
					}
				}
				if(busy.contains("C")) {
					if(busy.contains("J")) {
						return "IMPOSSIBLE";
					}
					str += "J";
				} else {
					str += "C";
				}
			}
		}
		
		return str;
	}
}

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		String result = "";
		
		for(int tc = 0; tc < t; tc++) {
			String s = sc.next();
			for(int i = 0; i < 9; i++) {
				ArrayList<String> splits = new ArrayList<String>();
				
				int slen = s.length();
				int previndex = 0;
				
				for(int j = 0; j < slen; j++) {
					if(s.charAt(j) == (char)(i + '0')) {
						splits.add(s.substring(previndex, j));
						previndex = j+1;
					}
				}
				splits.add(s.substring(previndex, slen));
				
				
				int len = splits.size();
				for (int aind = 0; aind < len; aind++) {
					String curr = splits.get(aind);
		            boolean contain = false;
		            for(int j = i+1; j <= 9; j++) {
		            	if(curr.contains("" + j)) {
		            		contain = true;
		            	}
		            }
		            if(contain) {
		            	splits.set(aind, "(" + splits.get(aind) + ")");
		            }
				}
				
				s = splits.get(0);
				for (int aind = 1; aind < len; aind++) {
					s += "" + i + splits.get(aind);
				}
			}
			
			result += "Case #" + (tc+1) + ": " + s + "\n";
		}
		
		System.out.print(result);
		
		sc.close();
	}
}
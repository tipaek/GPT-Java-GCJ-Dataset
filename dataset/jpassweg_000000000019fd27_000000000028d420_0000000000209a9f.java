import java.util.Scanner;

class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		String result = "";
		
		for(int tc = 0; tc < t; tc++) {
			String s = sc.nextLine();
			for(int i = 0; i < 9; i++) {
				String[] splits = s.split("" + i);
				int len = splits.length;
				for (int aind = 0; aind < len; aind++) {
					String curr = splits[aind];
		            boolean contain = false;
		            for(int j = i+1; j <= 9; j++) {
		            	if(curr.contains("" + j)) {
		            		contain = true;
		            	}
		            }
		            if(contain) {
		            	splits[aind] = "(" + splits[aind] + ")";
		            }
				}
				
				s = String.join("", splits);
			}
			
			result += "Case #" + (tc+1) + ": " + s + "\n";
		}
		
		System.out.print(result);
		
		sc.close();
	}
}

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static String result;
	static int oX;
	static int oY;
	static int maxNum;
	static ArrayList<String> ans;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testsSets;
		int currentCase = 0;
		testsSets = scan.nextInt();
		
		while(testsSets > currentCase) {
			ans = new ArrayList<String>();
			int x = scan.nextInt();
			int y = scan.nextInt();
			oX = x;
			oY = y;
			int num = 1;
			
			while(num < (Math.abs(x) + Math.abs(y)) * 2) {
				num *= 2;
			}
			maxNum = num;
			
			int curX = 0;
			int curY = 0;
			
			//can't be odd
			if((x + y) % 2 == 0) {
			}
			else {
				String s = "";
				
				tryAll(1, 0, 0, s);
			}
			
			String str;
			
			if(ans.size() == 0) {
				str = "IMPOSSIBLE";
			}
			else{
				int min = ans.get(0).length();
				int minIdx = 0;
				for(int i = 1; i < ans.size(); i++) {
					if(min > ans.get(i).length()) {
						min = ans.get(i).length();
						minIdx = i;
					}
				}
				
				str = ans.get(minIdx);
				
			}
			
			System.out.printf("Case #%d:%s\n", currentCase + 1, str);
			
			currentCase++;
		}
	}
	private static void tryAll(int curNum, int x, int y, String s) {
		if(x == oX && y == oY) {
			result = s;
			ans.add(s);
			return ;
		}
		else if(curNum  == maxNum) {
			return ;
		}
		tryAll(curNum * 2, x - curNum, y, s + "E");
		tryAll(curNum * 2, x + curNum, y, s + "W");
		tryAll(curNum * 2, x, y - curNum, s + "S");
		tryAll(curNum * 2, x, y + curNum, s + "N");
	}

}
// minimum number of opening and closing parentheses
// 
import java.util.*;
class Solution {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < cases; ++i) {
            String str = scanner.nextLine();
            System.out.println(solve(str));
        }
        scanner.close();
	}
	
	public static String solve(String str) {
		int i = 0;
		
		StringBuilder res = new StringBuilder();
		int open = 0;
		while(i < str.length()) {
			int num = str.charAt(i) - '0';
			int diff = num - open;
			if(diff >= 0) {
				for(int j = 0; j < diff; ++j) {
					res.append('(');
				}
				res.append(num);
				open = num;
			}
			else {
				for(int j = 0; j > diff; --j) {
					res.append(')');
				}
				res.append(num);
				open = num;
			}
			++i;
			
		}
		
		while(open > 0) {
			res.append(')');
			--open;
		}
		return res.toString();
	}

}
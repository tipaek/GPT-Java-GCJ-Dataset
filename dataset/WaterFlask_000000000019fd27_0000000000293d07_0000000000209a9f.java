// minimum number of opening and closing parentheses
// 
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for(int i = 1; i <= cases; ++i) {
            String str = in.next();
            System.out.print("Case #" + i + ": ");
            System.out.println(solve(str));
        }
        in.close();
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
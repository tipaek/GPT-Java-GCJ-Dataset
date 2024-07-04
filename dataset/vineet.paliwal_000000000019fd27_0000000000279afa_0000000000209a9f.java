import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 1 ; i <= t ; i++) {
			String s = scan.next();
			String ans = solve(s,0,0);
			System.out.println("Case #" + i + ": " + ans);
		}
	}
	
	public static String solve(String s,int depth,int applied) {
		String ss = s;
		if(depth==10) {
			return ss;
		}
		if(s.equalsIgnoreCase("")) {
			return s;
		}
		
		if(s.contains(new Integer(depth).toString())) {
			String[] list = s.split(new Integer(depth).toString(),-1);
			//System.out.println(list.length);
			ss = "";
			for(int i = applied ; i < depth ;i++) {
				ss += "(";
			}
			for(int i = 0 ; i < list.length ; i++) {
				ss = ss + solve(list[i],depth+1,depth);
				if(i!=(list.length-1)) {
					ss += depth;
				}
			}
			for(int i = applied ; i < depth ;i++) {
				ss += ")";
			}
		} else {
			ss = solve(s,depth+1,applied);
		}
		return ss;
	}

}

import java.util.*;
public class NestingDepth {
	public static void main(String[] args) {
		//System.out.println("Please Provide input: ");
        Scanner in = new Scanner(System.in);
        int t = Integer.valueOf(in.nextLine());
        for (int k = 1; k <= t; k++) {
        	String s = in.nextLine();
        	//System.out.println(k + " " + s);
        	StringBuilder res = new StringBuilder();
        	int prev = 0;
        	for (char c: s.toCharArray()) {
        		insert(res, prev, c-'0', c);
        		prev = c-'0';
        	}
        	
        	System.out.println("Case #" + k + ": " + res.toString());
        }
	}
	public static void insert(StringBuilder res, int prev, int cur, char c) {
		if (prev >= cur) {
			res.insert(res.length()-cur, c);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cur-prev; i++) {
			sb.append('(');
		}
		sb.append(c);
		for (int i = 0; i < cur-prev; i++) {
			sb.append(')');
		}
		res.insert(res.length()-prev, sb.toString());
	}
}
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public List<String> solve(int N) {
		
		List<String> ans = new ArrayList<>();
		ans.add("1 1");
		N -= 1;
		
		int cur = 1;
		while(N > 0) {
			if(cur > N) break;
			N -= cur;
			ans.add((cur+1) + " 2");
			cur++;
		}
		if(N > 0) {
			ans.add(cur + " 1");
			N--;
		}
		while(N > 0) {
			ans.add((cur+1) + " 1");
			N--;
			cur++;
		}
		//System.out.println(ans.size());
		return ans;
		
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(1000000000));
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			in.nextLine();
			List<String> output = Q.solve(N);
			System.out.println("Case #" + i + ":");
			for(String s : output) System.out.println(s);
			System.out.flush();
		}
	}

}

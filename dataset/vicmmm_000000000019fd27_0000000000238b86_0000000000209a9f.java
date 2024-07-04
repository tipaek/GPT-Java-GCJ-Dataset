import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fst = reader.readLine();
		int n = Integer.parseInt(fst);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			String s = reader.readLine();
			sb.append("Case #"+(i+1)+": "+addParens(s)+"\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static String addParens(String s) {
		char[] chs = s.toCharArray();
		
		int n = chs.length;
		int[] digits = new int[n];
		for(int i=0;i<n;i++) digits[i] = chs[i]-'0';
		
		return helper(digits, 0, n-1, 0);
	}
	
	public static String helper(int[] digits, int s, int t, int diff) {
		if(s>t) return "";
		
		// find min values, and indices
		int min = Integer.MAX_VALUE;
		List<Integer> indices = new ArrayList<>();
		
		for(int i=s;i<=t;i++) {
			if(digits[i]>min) continue;
			
			if(digits[i]<min) indices = new ArrayList<>();
			
			min = digits[i];
			indices.add(i);
		}
		
		indices.add(0, s-1);
		
		StringBuffer sb = new StringBuffer();
		int cnt = min-diff;
		
		for(int i=0;i<cnt;i++) sb.append("("); // left (
		
		int size = indices.size();
		for(int i=1;i<size;i++) {
			int s1 = indices.get(i-1)+1;
			int t1 = indices.get(i)-1;
			sb.append(helper(digits, s1, t1, min));
			sb.append(min);
		}
		
		sb.append(helper(digits, indices.get(size-1)+1, t, min));
		
		for(int i=0;i<cnt;i++) sb.append(")"); // right )
		
		return sb.toString();
	}
}

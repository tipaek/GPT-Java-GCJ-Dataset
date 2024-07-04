import java.util.*;
public class Solution {
	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			String[] s = new String[n];
			for(int j=0;j<n;j++) {
				s[j] = sc.next();
			}
			String[] left = new String[n];
			String[] right = new String[n];
			for(int j=0;j<n;j++) {
				int index = s[j].indexOf('*');
				left[j] = s[j].substring(0,index);
				if(index!=s[j].length()-1)
					right[j] = s[j].substring(index+1,s[j].length());
				else
					right[j]="";
			}
			String left_side = calculate(left);
			String right_side = calculate(right);
			if(left_side.equals("") && right_side.equals("")) {
				System.out.println("Case #"+i+": *");
			}else
				System.out.println("Case #"+i+": "+left_side+right_side);
		}
	}

	private static String calculate(String[] left) {
		// TODO Auto-generated method stub
		String longest = "";
		int max = Integer.MIN_VALUE;
		for(int i=0;i<left.length;i++) {
			if(left[i].length()>max) {
				max = left[i].length();
				longest = left[i];
			}
		}
		if(longest.equals("")) {
			return "";
		}
		for(int i=0;i<left.length;i++) {
			int index = longest.indexOf(left[i]);
			if(index<0)
				return "";
		}
		return longest;
	}

}

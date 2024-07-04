import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			String s = sc.next();
			int n = s.length();
			String result = "";
			int prev = 0;
			for(int j=0;j<n;j++) {
				int val = Integer.parseInt(Character.toString(s.charAt(j)));
				if(val>prev) {
					for(int k=1;k<=(val-prev);k++) {
						result = result + "(";
					}
				}else if(val<prev) {
					for(int k=1;k<=(prev-val);k++) {
						result = result + ")";
					}
				}
				prev = val;
				result = result + Character.toString(s.charAt(j));
			}
			for(int j=1;j<=prev;j++) {
				result = result + ")";
			}
			System.out.println("Case #"+i+": "+result);
		}
	}

}
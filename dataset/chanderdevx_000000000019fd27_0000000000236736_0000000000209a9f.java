import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		String[] resarr = new String[t];
		for(int x=1; x<=t; x++) {
			String s = sc.nextLine();
			StringBuilder result = new StringBuilder();
			
			char[] a = s.toCharArray();
			
			int curopen = 0;
			for(int i=0; i<a.length; i++) {
				int current = Character. getNumericValue(a[i]);
				if(current != 0) {
					if(curopen <= current) {
						int cur = curopen;
						for(int j=cur; j < current; j++) {
							result.append("(");
							curopen = curopen + 1;
						}
					} else {
						int cur = curopen - current;
						for(int j=0; j < cur; j++) {
							result.append(")");
							curopen = curopen - 1;
						}
					}
				} else {
					int cur = curopen;
					for(int j=0; j < cur; j++) {
						result.append(")");
						curopen = curopen - 1;
					}
				}
				result.append(a[i]);
			}
			
			for(int i=0; i<curopen; i++) {
				result.append(')');
			}
			
			resarr[x-1] = "Case #"+ x +": "+ result.toString();
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(resarr[i]);
		}
	}

}

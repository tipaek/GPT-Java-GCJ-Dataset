import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.nextLine());
		
		for(int x=1; x<=t; x++) {
			String s = sc.nextLine();
			StringBuilder result = new StringBuilder();
			
			char[] a = s.toCharArray();
			
			boolean flag = false;
			for(int i=0; i<a.length; i++) {
				if(a[i] == '1') {
					if(!flag) {
						result.append('(');
						flag = true;
					} 
				} else {
					if(flag) {
						result.append(')');
						flag = false;
					}
					
				}
				result.append(a[i]);
			}
			
			if(flag) {
				result.append(')');
			}
			
			resarr[x-1] = "Case #"+ x +": "+ result.toString();
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(resarr[i]);
		}
	}

}

import java.util.*;

public class Solution {
    public static boolean check(String s,String b) {
		int i = s.length() - 1, j = b.length() - 1;
		while(s.charAt(i) != '*') {
			if(s.charAt(i--) != b.charAt(j--)) return false;
		}
		return true;
	}
	
	public static String answer(String a[]) {
		int n = a.length;
		String lamba = a[n-1];
		for(int i=0;i<n-1;i++)
			if(!check(a[i],lamba)) return "*";
		return lamba;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int q=1;q<=t;q++) {
			int n = scn.nextInt();
			String a[] = new String[n];
			for(int i=0;i<n;i++) a[i] = scn.next();
			
			Arrays.sort(a, new Comparator<String>() {
				public int compare(String x,String y) {
					return Integer.compare(x.length(), y.length());
				}
			});
			
			System.out.println("Case #" + q + ": " + answer(a));
		}
	}
}
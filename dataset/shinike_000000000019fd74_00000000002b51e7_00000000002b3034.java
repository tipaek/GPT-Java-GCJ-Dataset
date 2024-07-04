import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		// TODO
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {

			int n = sc.nextInt();
			ArrayList<String> strings = new ArrayList<>();
			for (int j=0;j<n;j++) {
				strings.add(sc.next());
			}
			
			List<String> pre = strings.stream().map(Solution::prefix).collect(Collectors.toList());
			String longPre = pre.stream().max(Comparator.comparing(String::length)).get();
			boolean preOk = pre.stream().allMatch(s -> isPrefix(s, longPre));
				
			List<String> suf = strings.stream().map(Solution::suffix).collect(Collectors.toList());
			String longSuf = suf.stream().max(Comparator.comparing(String::length)).get();
			boolean sufOk = suf.stream().allMatch(s -> isSuffix(s, longSuf));
			
			String ans = "*";
			if (preOk && sufOk) {
				ans = longPre;
				ans += strings.stream().map(Solution::mid).map(s -> s.replace('*', 'A')).collect(Collectors.joining());
				ans += longSuf;
			} 
			System.out.println("Case #"+i+": "+ans);
		}
	}
	
	public static String prefix(String s) {
		int n = s.length();
		for (int i=0;i<n;i++) {
			if (s.charAt(i)=='*') {
				return s.substring(0,i);
			}
		}
		return "";
	}
	
	public static String suffix(String s) {
		int n = s.length();
		for (int i=n-1;i>=0;i--) {
			if (s.charAt(i)=='*') {
				return s.substring(i+1);
			}
		}
		return "";
	}
	
	public static String mid(String s) {
		int n = s.length();
		int first=0;
		int last=0;
		for (int i=0;i<n;i++) {
			if (s.charAt(i)=='*') {
				first=i;
				break;
			}
		}
		
		for (int i=n-1;i>=0;i--) {
			if (s.charAt(i)=='*') {
				last=i;
				break;
			}
		}
		return s.substring(first, last+1);
	}
	
	public static boolean isPrefix(String s, String t) {
		int m = s.length();
		int n = t.length();
		return m<=n && t.substring(0,m).equals(s);

	}
	
	public static boolean isSuffix(String s, String t) {
		int m = s.length();
		int n = t.length();
		return m<=n && t.substring(n-m).equals(s);
	}

}

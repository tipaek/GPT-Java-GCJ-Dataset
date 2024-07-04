import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			StringBuilder front = new StringBuilder();
			StringBuilder back = new StringBuilder();
			boolean works = true;
			for(int i = 0; i < n; i++) {
				String curr = sc.next();
				String[] strings = curr.split("\\*");
				if(curr.charAt(curr.length()-1)=='*') {
					String[] newstrings = new String[strings.length+1];
					for(int j = 0; j < strings.length; j++) {
						newstrings[j] = strings[j];
					}
					newstrings[strings.length] = "";
					strings = newstrings;
				}
				if(front.length()<strings[0].length()) {
					if(front.toString().equals(strings[0].substring(0, front.length()))) {
						front = new StringBuilder(strings[0]);
					}else {
						works = false;
					}
				}else {
					if(front.toString().substring(0,strings[0].length()).equals(strings[0])) {
						
					}else {
						works = false;
					}
				}
				if(back.length()<strings[1].length()) {
					if(back.toString().equals(strings[1].substring(strings[1].length()-back.length()))) {
						back = new StringBuilder(strings[1]);
					}else {
						works = false;
					}
				}else {
					if(back.toString().substring(back.length()-strings[1].length()).equals(strings[1])) {
						
					}else {
						works = false;
					}
				}
			}
			if(works) {
				System.out.println("Case #" + t + ": " + combine(front.toString(),back.toString()));
			}else {
				System.out.println("Case #" + t + ": *");
			}
		}
		sc.close();
	}
	
	public static String combine(String s1, String s2) {
		for(int i = Math.min(s1.length(), s2.length()); i >=0 ; i--) {
			if(s1.substring(s1.length()-i).equals(s2.subSequence(0, i))) {
				return s1.substring(0,s1.length()-i) + s2;
			}
		}
		return s1+s2;
	}
	
}

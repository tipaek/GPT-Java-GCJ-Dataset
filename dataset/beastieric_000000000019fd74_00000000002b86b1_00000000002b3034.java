import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			StringBuilder front = new StringBuilder(), middle = new StringBuilder(), back = new StringBuilder();
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
				if(curr.charAt(0)!='*') {
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
				}
				if(curr.charAt(curr.length()-1)!='*') {
					if(back.length()<strings[strings.length-1].length()) {
						if(back.toString().equals(strings[strings.length-1].substring(strings[strings.length-1].length()-back.length()))) {
							back = new StringBuilder(strings[strings.length-1]);
						}else {
							works = false;
						}
					}else {
						if(back.toString().substring(back.length()-strings[strings.length-1].length()).equals(strings[strings.length-1])) {
							
						}else {
							works = false;
						}
					}
				}
				for(int j = 1; j < strings.length-1; j++) {
					middle.append(strings[j]);
				}
			}
			if(works) {
				System.out.println("Case #" + t + ": " + front.toString()+middle.toString()+back.toString());
			}else {
				System.out.println("Case #" + t + ": *");
			}
		}
		sc.close();
	}
	
}

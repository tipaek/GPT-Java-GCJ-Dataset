import java.util.*;
/**
 * For Google Code Jam 2020: Round 1A
 */

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> output = new ArrayList<>();
		int t = scanner.nextInt();
		for(int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			String start = "";
			String end = "";
			boolean stop = false;
			scanner.nextLine();
			for(int j = 0; j < n; j++) {
				String pattern = scanner.nextLine();
				String[] strArray = pattern.split("\\*");
				System.out.println(pattern);
				System.out.println(strArray[1]);
				if(strArray.length == 2 && !stop) {
					if(strArray[0].isEmpty()) {
						//Star at beginning
						if(end.length() == strArray[1].length()) {
							if(!end.equals(strArray[1])) {
								output.add("*");
								stop = true;
							} 
						} else if(end.length() < strArray[1].length()) {
							if(!strArray[1].endsWith(end)) {
								output.add("*");
								stop = true;
							} else {
								end = strArray[1];
							}
						} else {
							if(!end.endsWith(strArray[1])) {
								output.add("*");
								stop = true;
							}
						}
					} else {
						// Star in the middle
						if(end.length() == strArray[1].length()) {
							if(!end.equals(strArray[1])) {
								output.add("*");
								stop = true;
							} 
						} else if(end.length() < strArray[1].length()) {
							if(!strArray[1].endsWith(end)) {
								output.add("*");
								stop = true;
							} else {
								end = strArray[1];
							}
						} else {
							if(!end.endsWith(strArray[1])) {
								output.add("*");
								stop = true;
							}
						}
						if(start.length() == strArray[0].length()) {
							if(!start.equals(strArray[0])) {
								output.add("*");
								stop = true;
							} 
						} else if(start.length() < strArray[0].length()) {
							if(!strArray[0].startsWith(end)) {
								output.add("*");
								stop = true;
							} else {
								end = strArray[0];
							}
						} else {
							if(!start.startsWith(strArray[0])) {
								output.add("*");
								stop = true;
							}
						}
					}
				} else if(!stop){
					//Star ending
					if(start.length() == strArray[0].length()) {
						if(!start.equals(strArray[0])) {
							output.add("*");
							stop = true;
						} 
					} else if(start.length() < strArray[0].length()) {
						if(!strArray[0].startsWith(end)) {
							output.add("*");
							stop = true;
						} else {
							end = strArray[0];
						}
					} else {
						if(!start.startsWith(strArray[0])) {
							output.add("*");
							stop = true;
						}
					}
				}
			}
			if(!stop) {
				if(start.length() + end.length() < (10 * 10 * 10 * 10)) {
					output.add(start + end);
				} else {
					output.add("*");
				}
			}
		}
		
		for(int i = 0; i < output.size(); i++) {
			System.out.println("Case #" + (i + 1) + ": " + output.get(i));
		}
		scanner.close();
	}
}
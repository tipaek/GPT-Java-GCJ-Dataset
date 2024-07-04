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
			String middle = "";
			boolean stop = false;
			scanner.nextLine();
			for(int j = 0; j < n; j++) {
				String pattern = scanner.nextLine();
				if(!stop && pattern.length() != 0 && !(pattern.length() == 1 && pattern.charAt(0) == '*')) {
					boolean isStartElement = true;
					boolean isEndElement = true;
					isStartElement = (pattern.charAt(0) != '*');
					isEndElement = (pattern.charAt(pattern.length() - 1) != '*');
					
					String[] strArray = pattern.split("\\*");
					for(int k = 0; k < strArray.length; k++) {
						if(k == 0 && isStartElement) {
							start = processStart(start, strArray[0]);
							if(start.equals("*")) {
								stop = true;
								output.add("*");
							}
						} else if(k == (strArray.length - 1) && isEndElement) {
							end = processEnd(end, strArray[strArray.length - 1]);
							if(end.equals("*")) {
								stop = true;
								output.add("*");
							}
						} else {
						    //if(!middle.contains(strArray[k])) {
						        middle += strArray[k];   
						    //}
						}
					}
				}
			}
			if(!stop) {
				if(start.length() + end.length() + middle.length() < (10 * 10 * 10 * 10)) {
					output.add(start + middle + end);
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

	private static String processEnd(String end, String endElement) {
		if(end.length() == endElement.length()) {
			if(!end.equals(endElement)) {
				return "*";
			} 
		} else if(end.length() < endElement.length()) {
			if(!endElement.endsWith(end)) {
				return "*";
			} else {
				 return endElement;
			}
		} else {
			if(!end.endsWith(endElement)) {
				return "*";
			}
		}
		return end;
	}

	private static String processStart(String start, String startElement) {
		if(start.length() == startElement.length()) {
			if(!start.equals(startElement)) {
				return "*";
			} 
		} else if(start.length() < startElement.length()) {
			if(!startElement.startsWith(start)) {
				return "*";
			} else {
				return startElement;
			}
		} else {
			if(!start.startsWith(startElement)) {
				return "*";
			}
		}
		return start;
	}
}
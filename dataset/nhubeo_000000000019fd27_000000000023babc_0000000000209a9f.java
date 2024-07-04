
import java.util.Scanner;
import java.util.LinkedList;

public class Solution {
	public static String compute(String s) {
		String tempS = "";
		LinkedList<Integer> list = new LinkedList<Integer>();
		char[] arr = s.toCharArray();
		for (int i=0; i<arr.length; i++) {
			int digit = arr[i] - '0';
			if (list.size() == digit) {
				tempS += digit;
			} else if (list.size() > digit) {
				while (list.size() > digit) {
					list.remove(0);
					tempS += ")";
				}
				tempS+=digit;
			} else {
				while (list.size() < digit) {
					list.add(0,0);
					tempS += "(";
				}
				tempS+=digit;
			}
		}
		
		while (list.size() >0) {
			list.remove(0);
			tempS += ")";
		}
		return tempS;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < testCases; i++) {
		    String s = scanner.nextLine();
		    System.out.println("Case #" + (i+1) + ": " + compute(s));
		}

	}
}

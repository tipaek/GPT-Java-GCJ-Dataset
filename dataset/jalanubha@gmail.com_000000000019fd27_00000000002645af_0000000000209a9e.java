import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ip = sc.nextLine().split(" ", 0);
		int T = Integer.parseInt(ip[0]);
		int B = Integer.parseInt(ip[1]);
		char[] arr = new char[B];
		int[] badQueries = new int[] {11,21,31,41,51,61,71,81,91};
		//B - badQueries[i] + 1		
		
		if (10 == B) {
			for (int x = 0; x < T; x++) {
				String y = "";
				for (int i = 1; i <= B; i++) {
					System.out.println(i);
					arr[i - 1] = sc.nextLine().charAt(0);
				}
				
				y = new String(arr);
				System.out.println(y);
				char response = sc.nextLine().charAt(0);
				if (response == 'N') break;
			}	
		} else if (20 == B) {
			for (int x = 0; x < T; x++) {
				String y = "";
				char[] finalarr = new char[B];
				for (int i = 1; i <= B; i++) {
					if (i == 11) continue;
					System.out.println(i);
					arr[i - 1] = sc.nextLine().charAt(0);
				}
				
				System.out.println(11);
				finalarr[10] = sc.nextLine().charAt(0);
				
				for (int i = 2; i <= B; i++) {
					if (i == 11) continue;
					System.out.println(i);
					finalarr[i - 1] = sc.nextLine().charAt(0);
				}
				
				//check for no change
				arr[10] = finalarr[10];
				finalarr[0] = arr[0];
				if(checkChars(arr, finalarr)) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
								
				//check for reverse
				arr[10] = finalarr[9];
				finalarr[0] = arr[19];
				if(checkChars(arr, reverse(finalarr))) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
				
				//check for complement
				arr[10] = finalarr[10] == '1'?'0':'1';
				finalarr[0] = arr[0] == '1'?'0':'1';
				if(checkChars(arr, complement(finalarr))) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
				
				//check for complement + reverse
				arr[10] = finalarr[9] == '1'?'0':'1';
				finalarr[0] = arr[19] == '1'?'0':'1';
				if(checkChars(arr, comprev(finalarr))) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
				
				System.out.println(y);
				char response = sc.nextLine().charAt(0);
				if (response == 'N') break;
			}
		} else {
			for (int x = 0; x < T; x++) {
				String y = "";
				char[] finalarr = new char[B];
				for (int i = 0; i < badQueries.length; i++) {
					System.out.println(badQueries[i]);
					arr[badQueries[i] - 1] = sc.nextLine().charAt(0);
				}
				
				for (int i = 1; i <= B; i++) {
					if (i%10 == 1) continue;
					System.out.println(i);
					arr[i - 1] = sc.nextLine().charAt(0);
				}
				
				System.out.println(1);
				finalarr[0] = sc.nextLine().charAt(0);
				
				for (int i = 1; i <= B; i++) {
					if (i%10 == 1) continue;
					System.out.println(i);
					finalarr[i - 1] = sc.nextLine().charAt(0);
				}
				
				//check for no change
				arr[0] = finalarr[0];
				finalarr[90] = arr[90];
				if(checkChars(arr, finalarr)) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
								
				//check for reverse
				arr[10] = finalarr[9];
				finalarr[0] = arr[19];
				if(checkChars(arr, reverse(finalarr))) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
				
				//check for complement
				arr[10] = finalarr[10] == '1'?'0':'1';
				finalarr[0] = arr[0] == '1'?'0':'1';
				if(checkChars(arr, complement(finalarr))) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
				
				//check for complement + reverse
				arr[10] = finalarr[9] == '1'?'0':'1';
				finalarr[0] = arr[19] == '1'?'0':'1';
				if(checkChars(arr, comprev(finalarr))) {
					y = new String(finalarr);
					System.out.println(y);
					char response = sc.nextLine().charAt(0);
					if (response == 'N') break;
				}
				
				System.out.println(y);
				char response = sc.nextLine().charAt(0);
				if (response == 'N') break;
				
			}
		}
		
		sc.close();
	}
	
	static char[] complement(char[] arr) {
		char[] newarr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newarr[i] = arr[i] == '1'?'0':'1';
		}
		return newarr;
	}
	
	static char[] reverse(char[] arr) {
		char[] newarr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newarr[i] = arr[arr.length - i - 1];
		}
		return newarr;
	}
	
	static char[] comprev(char[] arr) {
		char[] newarr = complement(arr);
		newarr = reverse(newarr);
		return newarr;
		
	}
	
	static boolean checkChars(char[] c1, char[] c2) {
		boolean breaked = false;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] == c2[i]) {
				continue;
			}
			breaked = true;
			break;
		}
		
		return !breaked;
	}
}

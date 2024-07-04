import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
	public static int caseNum(String str, int[] arr) {
		int zero = 0;
		int one = 0;
		if (arr[0] == 0) {
			zero++;
		}
		else one++;
		if (arr[arr.length-1] == 0) {
			zero++;
		}
		else one++;
		if (arr[Integer.parseInt(str.substring(1,2))] == 0) {
			zero++;
		}
		else one++;
		if (arr[arr.length-1-Integer.parseInt(str.substring(1,2))] == 0) {
			zero++;
		}
		else one++;
		if (one == 1 && zero == 3 || one == 3 && zero == 1) {
			return 1;
		}
		else if (one == 2 && zero == 2) {
			return 2;
		}
		else return 3;
	}
	public static String formation(int[] arr) {
		String query = "0";
		if (arr[0] == arr[arr.length-1]) {
		for (int i = 1; i < arr.length/2; i++) {
			if (arr[i] != -1) {
				if (arr[i] != arr[arr.length-1-i]) {
					query += i;
					return query;
				}
			}
		}
		}
		else {
			for (int i = 1; i < arr.length/2; i++) {
				if (arr[i] != -1) {
					if (arr[i] == arr[arr.length-1-i]) {
						query += i;
						return query;
					}
				}
			}
		}
		query += "1";
		return query;
	}
	public static void invert(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
			}
			else if (arr[i] == 1) {
				arr[i] = 0;
			}
		}
	}
	public static void flip(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr2[arr2.length-1-i];
		}
	}
	public static void both(int[] arr) {
		invert(arr);
		flip(arr);
	}
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        
        int queries = sc.nextInt();
        int length = sc.nextInt();
//        pw.println("HI");
        hi:
        while (queries --> 0) {
        	if (length == 10) {
        		int[] arr = new int[10];
        		for (int i = 1; i <= 10; i++) {
        			pw.println(i);
        			pw.flush();
        			String str = sc.next();
        			arr[i-1] = Integer.parseInt(str);
        		}
        		StringBuilder ans = new StringBuilder("");
        		for (int i = 0; i < arr.length; i++) {
        			ans.append(arr[i]);
        		}
        		pw.println(ans.toString());
        		pw.flush();
        		String str = sc.next();
        		if (str.equals("N")) {
        			break hi;
        		}
        		else continue;
        	}
        	else if (length > 10) {
//        		pw.println("WTMOO");
        		int pos = 6;
        		int[] arr = new int[length];
        		for (int i = 0; i < arr.length; i++) {
        			arr[i] = -1;
        		}
        		for (int i = 1; i <= 5; i++) {
        			pw.println(i);
        			pw.flush();
        			String str = sc.next();
        			arr[i-1] = Integer.parseInt(str);
        		}
        		for (int i = length-4; i <= length; i++) {
        			pw.println(i);
        			pw.flush();
        			String str = sc.next();
        			arr[i-1] = Integer.parseInt(str);
        		}
        		while (pos-1 <= arr.length/2) {
        		String str = formation(arr);
//        		pw.println(str);
        		pw.println(1);
        		pw.flush();
        		int query1 = sc.nextInt();
        		pw.println(Integer.parseInt(str.substring(1,2))+1);
        		pw.flush();
        		int query2 = sc.nextInt();
        		int caseNum = caseNum(str, arr);
//        		pw.println("caseNum = " + caseNum);
        		boolean invert = true;
        		boolean reverse = true;
        		boolean both = true;
        		boolean nothing = true;
        		if (caseNum == 1) {
        			if (arr[0] == arr[arr.length-1]) {
        				if (query1 == arr[0]) {
        					invert = false;
        					both = false;
        				}
        				else {
        					reverse = false;
        					nothing = false;
        				}
        			}
        			else {
        				if (arr[0] == query1) {
        					invert = false;
        					reverse = false;
        				}
        				else {
        					both = false;
        					nothing = false;
        				}
        			}
        			if (arr[Integer.parseInt(str.substring(1,2))] == arr[arr.length-1-Integer.parseInt(str.substring(1,2))]) {
        				if (query2 == arr[Integer.parseInt(str.substring(1,2))]) {
        					invert = false;
        					both = false;
        				}
        				else {
        					reverse = false;
        					nothing = false;
        				}
        			}
        			else {
        				if (arr[Integer.parseInt(str.substring(1,2))] == query2) {
        					invert = false;
        					reverse = false;
        				}
        				else {
        					both = false;
        					nothing = false;
        				}
        			}
        		}
        		else if (caseNum == 2) {
        			if (arr[0] == query1) {
        				invert = false;
        				reverse = false;
//        				both = false;
        			}
        			if (arr[arr.length-1] == query1) {
//        				reverse = false;
        				both = false;
        				nothing = false;
        			}
        		}
        		else if (caseNum == 3) {
        			reverse = false;
        			invert = false;
        			both = false;
        		}
        		if (reverse) {
//        			pw.println("WTMOO");
        			flip(arr);
        		}
        		else if (invert) {
        			invert(arr);
        		}
        		else if (both) {
        			both(arr);
        		}
//        		pw.println(Arrays.toString(arr));
        		for (int i = pos; i <= pos+3; i++) {
        			pw.println(i);
        			pw.flush();
        			String str1 = sc.next();
        			arr[i-1] = Integer.parseInt(str1);
        		}
        		for (int i = arr.length-2-pos; i <= arr.length+1-pos; i++) {
        			pw.println(i);
        			pw.flush();
        			String str1 = sc.next();
        			arr[i-1] = Integer.parseInt(str1);
        		}
        		pos += 4;
        	}
        		StringBuilder ans = new StringBuilder("");
        		for (int i = 0; i < arr.length; i++) {
        			ans.append(arr[i]);
        		}
        		pw.println(ans.toString());
        		pw.flush();
        		String str2 = sc.next();
        		if (str2.equals("N")) {
        			break hi;
        		}
        	}
        }
        
        pw.close();
    }
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
}
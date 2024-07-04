
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//Split based on "";
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c =0;
		while(t>0) {
			c++;
			int n = sc.nextInt();
			String [] arr = new String[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.next();
			}
			ArrayList<String> prefix = new ArrayList<String>();
			ArrayList<String> suffix = new ArrayList<String>();
			String ret = "";
			for(int i=0;i<n;i++) {
				for(int j=0;j<arr[i].length();j++) {
					if(arr[i].charAt(j)=='*') {
						
						prefix.add(arr[i].substring(0,j));
						suffix.add(arr[i].substring(j+1,arr[i].length()));
					}
				}
			}
			ret = constructPref(prefix)+constructSuf(suffix);
			if(works) {
				System.out.println("Case #" + (c)+": " + ret);
			}
			else {
				System.out.println("*");
			}
			t--;
		}
	}
	static boolean works = true;
	static String constructPref(ArrayList<String> p) {
		//get largest all need same prefix
		String biggest = "";
		int biggestLength = 0;
		for(String k : p) {
			if(k.length()>biggestLength) {
				biggestLength = k.length();
				biggest = k;
			}
		}
		for(String k : p) {
			if(biggest.substring(0,k.length()).equals(k)) {
				continue;
			}
			else {
				works = false;
			}
		}
		return biggest;
	}
	static String constructSuf(ArrayList<String> s) {
		String biggest = "";
		int biggestLength = 0;
		for(String k : s) {
			if(k.length()>biggestLength) {
				biggestLength = k.length();
				biggest = k;
			}
		}
		for(String k : s) {
			if(biggest.substring(biggest.length()-k.length(),biggest.length()).equals(k)) {
				continue;
			}
			else {
				works = false;
			}
		}
		return biggest;
	}
}

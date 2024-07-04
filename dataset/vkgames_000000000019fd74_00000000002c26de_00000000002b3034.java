
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
			String [] prefix = new String[n];
			String [] suffix = new String[n];
			String ret = "";
			for(int i=0;i<n;i++) {
				for(int j=0;j<arr[i].length();j++) {
					if(arr[i].charAt(j)=='*') {
						prefix[i] = arr[i].substring(0,j);
						suffix[i] = arr[i].substring(j+1,arr[i].length());
						break;
					}
				}
			}
		
			boolean works = true;
			String biggestSuf = "";
			int biggestLength = 0;
			for(int i=0;i<n;i++) {
				if(suffix[i].length()>biggestLength) {
					biggestLength = suffix[i].length();
					biggestSuf = suffix[i];
				}
			}
			for(int i=0;i<n;i++) {
				if(biggestSuf.substring(biggestSuf.length()-suffix[i].length(),biggestSuf.length()).equals(suffix[i])) {
					continue;
				}
				else {
					works =false;
				}
			}
			if(!works) {
				System.out.println("Case #" + (c)+": " + "*");
				t--;
				continue;
			}
			String biggestPref = "";
			biggestLength = 0;
			for(int i=0;i<n;i++) {
				if(prefix[i].length()>biggestLength) {
					biggestLength = prefix[i].length();
					biggestPref = prefix[i];
				}
			}
			for(int i=0;i<n;i++) {
				if(biggestPref.substring(0,prefix[i].length()).equals(prefix[i])) {
					continue;
				}
				else {
					works = false;
				}
			}
			if(!works) {
				System.out.println("Case #" + (c)+": " + "*");
				t--;
				continue;
			}
			ret = biggestPref + biggestSuf;
			System.out.println("Case #" + (c)+": " + ret);

			t--;
		}
	}
	
}

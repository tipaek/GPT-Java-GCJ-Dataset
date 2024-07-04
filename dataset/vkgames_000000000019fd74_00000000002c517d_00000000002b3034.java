
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
			String [][] k = new String[n][102];
			for(int i=0;i<n;i++) {
				for(int j=0;j<102;j++) {
					k[i][j] = "";
				}
			}
			String ret = "";
			for(int i=0;i<n;i++) {
				String [] temp = arr[i].split("\\*");
				prefix[i] = temp[0];
				if(arr[i].charAt(arr[i].length()-1)=='*') {
					suffix[i] = "";
				}
				else
					suffix[i] = temp[temp.length-1];
				for(int j=1;j<temp.length-1;j++) {
					k[i][j] = temp[j];
				}
				if(arr[i].charAt(arr[i].length()-1)=='*') {
					k[i][temp.length-1] = temp[temp.length-1];
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
			ret = biggestPref;
			for(int i=0;i<102;i++) {
				ret+=obtain(k,i);
			}
			ret+=biggestSuf;
			System.out.println("Case #" + (c)+": " + ret);

			t--;
		}
	}
	static String obtain(String [][] temp,int index) {
		String ret = "";
		for(int i=0;i<temp.length;i++) {
			ret+=temp[i][index];
		}
		return ret;
	}

}

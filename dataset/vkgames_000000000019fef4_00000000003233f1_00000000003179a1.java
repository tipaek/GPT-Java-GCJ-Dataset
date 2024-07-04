import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c =0;
		while(t>0) {
			t--;
			c++;
			int u = sc.nextInt();
			int [] arr = new int[26];

			Arrays.fill(arr,1000);
			String ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			boolean[] seen = new boolean[26];
			boolean[] zero = new boolean[26];
			for(int i=0;i<26;i++) zero[i] = true;
			boolean thirdSet= false;
			for(int i=0;i<10000;i++) {
				long q = sc.nextLong();
				if(q==-1) {
					String r = sc.next();
					for(int j=0;j<r.length();j++) seen[ref.indexOf(r.charAt(j))] = true;

					zero[ref.indexOf(r.charAt(0))] = false;
					thirdSet = true;
					continue;
				}
				long temp = q;
				int len = 0;
				while(temp>0) {
					len++;
					temp/=10;
				}
				int [] digits = new int[len];
				len--;
				temp = q;
				while(temp>0) {
					digits[len] = (int) (temp%10);
					temp/=10;
					len--;
				}
				String r = sc.next();
				if(digits.length!=r.length()) {
					for(int j=0;j<r.length();j++) {
						arr[ref.indexOf(r.charAt(j))] = Math.min(arr[ref.indexOf(r.charAt(j))],9);
					}
					continue;
				}
				arr[ref.indexOf(r.charAt(0))] = Math.min(arr[ref.indexOf(r.charAt(0))],digits[0]);
				for(int j=1;j<r.length();j++) {
					//boundary?
					long boundary =(long) (Math.pow(10,r.length()-1)+Math.pow(10,r.length()-j));
					if(q<boundary) {
						arr[ref.indexOf(r.charAt(j))] = Math.min(arr[ref.indexOf(r.charAt(j))],digits[j]);
					}
					else {
						arr[ref.indexOf(r.charAt(j))] = Math.min(arr[ref.indexOf(r.charAt(j))],9);
					}
				}
			}
			if(!thirdSet) {
				String d = "";
				for(int num=0;num<10;num++) {
					for(int i=0;i<26;i++) {
						if(arr[i]==num) {
							d+=ref.charAt(i);
						}
					}
				}

				System.out.println("Case #"+c+": "+d);
			}
			else {
				String d = "";
				int zeroIndex = 0;
				for(int i=0;i<26;i++) {
					if(seen[i] && zero[i]) {
						d+=ref.charAt(i);
						zeroIndex = i;
					}
				}
				for(int i=0;i<26;i++) {
					if(seen[i] && i!=zeroIndex) {
						d+=ref.charAt(i);
					}
				}
				System.out.println("Case #"+c+": "+d);

			}
		}
	}

}

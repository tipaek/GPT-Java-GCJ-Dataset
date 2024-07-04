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
			for(int i=0;i<10000;i++) {
				int q = sc.nextInt();
				String r = sc.next();
				if(r.length()==1) {
					if(q<10) {
						arr[ref.indexOf(r.charAt(0))] = Math.min(arr[ref.indexOf(r.charAt(0))],q);

					}

					else {
						arr[ref.indexOf(r.charAt(0))] = Math.min(arr[ref.indexOf(r.charAt(0))],9);

					}

				}
				else {
					arr[ref.indexOf(r.charAt(0))] = Math.min(arr[ref.indexOf(r.charAt(0))],q/10);
					if(q<20) {
						arr[ref.indexOf(r.charAt(1))] = Math.min(arr[ref.indexOf(r.charAt(1))],q%10);

					}
					else {
						arr[ref.indexOf(r.charAt(1))] = Math.min(arr[ref.indexOf(r.charAt(1))],9);

					}
				}
			}
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
	}

}


import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
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
			boolean works = true;
			String biggest = "";
			int biggestLength = 0;
			for(int i=0;i<n;i++) {
				if(arr[i].length()>biggestLength) {
					biggestLength = arr[i].length();
					biggest = arr[i];
				}
			}
			for(int i=0;i<n;i++) {
				if(biggest.contains(arr[i].substring(1,arr[i].length()))) {
					continue;
				}
				else {
					works =false;
				}
			}
			if(works) {
				System.out.println("Case #" + c +": "+biggest.substring(1,biggest.length()));
			}
			else {
				System.out.println("Case #" + c +": "+"*");
			}
			
			
			t--;
		}
	}
}

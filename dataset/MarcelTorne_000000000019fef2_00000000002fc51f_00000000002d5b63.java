import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			long a = in.nextLong();
			long b = in.nextLong();
			for(int x = -5;x<=5;++x) {
				String ans="";
				for(int y = -5;y<=5;++y) {
					System.out.println(x+" "+y);
					System.out.flush();
					ans = in.next();
					if(ans == "CENTER") {
						break;
					}
				}
				if(ans == "CENTER") {
					ans = "";
					break;
				}
			}
		}
	}
}

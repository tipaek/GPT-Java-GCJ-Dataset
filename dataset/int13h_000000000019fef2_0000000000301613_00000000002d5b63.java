import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for (int i2 = 1; i2 <= t; i2++) {
			
			for (int i = 0; i < 300; i++) {
				
				boolean found= false;
				for (int j1 = -5; j1<= 5; j1++) {
					if (!found)
					for (int j2 = -5; j2<= 5; j2++) {
						System.out.println((j1) + " " + (j2));
						String resp = sc.next();
						if (resp.equals("CENTER")) {
							found = true;
							break;
						} else if (resp.equals("HIT")) {
							
						} else if (resp.equals("MISS")) {
							
						} else if (resp.equals("WRONG")) {
							return;
						}
					}
				}
				
				if (found) {
					break;
				}
			}
			
		}

		sc.close();
	}


}

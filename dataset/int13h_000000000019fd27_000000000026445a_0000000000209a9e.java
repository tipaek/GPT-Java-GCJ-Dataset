import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		int b = sc.nextInt();
		
		for (int i2 = 1; i2 <= t; i2++) {
			
			interact(sc, b);
			String response2 = sc.next();
			
			if (!response2.equals("Y")) {
				sc.close();
				return;
			}
				
		}
		sc.close();
	}

	private static void interact(Scanner sc, int b) {
		
		ArrayList<String> lines = new ArrayList<String>();
		String line = "";
		for (int i = 0; i < 10; i++) {
			int p = (i % b)+1;
			System.out.println(p);
			int response = sc.nextInt();
			line += response;
			if (line.length() == b) {
				lines.add(line);
				line = "";
			}
		}
		//System.out.println(lines);
		String solution = lines.get(lines.size()-1);
		System.out.println(solution);
		
		// first part 
		// second part
		
	}






}
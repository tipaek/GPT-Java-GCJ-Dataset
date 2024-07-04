import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		
		for(int i = 1; i <= cases; i++) {
			
			int[] Cam = new int[1500];
			int[] Jamie = new int[1500];
			int activities = in.nextInt();
			int start = 0;
			int end = 0;
			boolean flag = true;
			boolean addedToCam = false;
			boolean impossible = false;
			String solution = "";
			
			for(int j = 0; j < activities; j++) {
				addedToCam = false;
				start = in.nextInt();
				end = in.nextInt();
				if(impossible) {
					continue;
				}
				flag = true;
				for(int k = start; k < end; k++) { //Check Cameron's Schedule for availability
					if(Cam[k] == 1) {
						flag = false;
						break;
					}
				}
				if(flag) { //Cameron's schedule was open
					for(int k = start; k < end; k++) {
						Cam[k] = 1;
					}
					solution += "C";
					addedToCam = true;
				}
				if(addedToCam) {
					continue;
				} else {
					for(int k = start; k < end; k++) { //Check Jamie's Schedule for availability
						if(Jamie[k] == 1) {
							solution = "IMPOSSIBLE";
							impossible = true;
							break;
						}
					}
					if(impossible) {
						continue;
					}
					for(int k = start; k < end; k++) {
						Jamie[k] = 1;
					}
					solution += "J";
				}
			}
			
			System.out.println("Case #" + i + ": " + solution);
		}
	}
}

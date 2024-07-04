import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		
		for(int i = 1; i <= cases; i++) {
			
			short[] Cam = new short[10000];
			short[] Jamie = new short[10000];
			int activities = in.nextInt();
			short start = 0;
			short end = 0;
			boolean flag = true;
			boolean addedToCam = false;
			boolean impossible = false;
			String solution = "";
			
	
			for(int j = 0; j < activities; j++) {
				addedToCam = false;
				start = in.nextShort();
				end = in.nextShort();
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
						break;
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

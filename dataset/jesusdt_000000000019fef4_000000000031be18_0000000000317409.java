import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        if(in.hasNextLine()) in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next().replace("\n", "");
            System.out.println("Case #" + i + ": " + solve(x, y, m));
        }
        in.close();
      }

	private static String solve(int x, int y, String m) {
		
		int currentRelativeX = x;
		int currentRelativeY = y;
		for(int i = 0; i <= m.length(); i++) {
			int cartesianDistance = Math.abs(currentRelativeX)+Math.abs(currentRelativeY);
			int stepsAvailableToReachIt = i;
			if(cartesianDistance <= stepsAvailableToReachIt) {
				return ""+(cartesianDistance + ((int) Math.ceil((double) (stepsAvailableToReachIt-cartesianDistance)/2)));
			}
			if(i == m.length()) break;
			switch(m.charAt(i)) {
				case 'N':
					currentRelativeY++;
					break;
				case 'S':
					currentRelativeY--;
					break;
				case 'E':
					currentRelativeX++;
					break;
				case 'W':
					currentRelativeX--;
					break;
			}
		}
		return "IMPOSSIBLE";
	}

}

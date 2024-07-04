import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int totalTests = in.nextInt();
		for (int t = 1; t <= totalTests; ++t) {
			String r = "";
			int n = in.nextInt();
			List<int[]> activities = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int a0 = in.nextInt();
				int a1 = in.nextInt();
				int[] act = new int[]{a0, a1};
			    activities.add(act);
			}
			Collections.sort(activities, new Comparator<int[]>(){
                public int compare(int[] p1, int[] p2){
                    if (p1[0] == p2[0]) {
                        return p1[1] - p2[1];
                    }
                    return p1[0] - p2[0];
                }
            });
			int[] cameron = new int[]{-1, -1};
			int[] jamie = new int[]{-1, -1};
			for (int[] act : activities) {
			    if (cameron[1] <= act[0]) {
			        cameron = act;
			        r += "C";
			    } else if (jamie[1] <= act[0]) {
			        jamie = act;
			        r += "J";
			    } else {
			        r = "IMPOSSIBLE";
			        break;
			    }
			}
			System.out.println("Case #" + t + ": " + r);	
		}
	}
}
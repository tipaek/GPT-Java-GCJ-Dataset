import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		final boolean STD_IO = true;
		final String INPUT_FILE = "A-small-attempt0.in";
		InputStream inStream = STD_IO ? System.in : new FileInputStream(new File(INPUT_FILE));
		OutputStream outStream = STD_IO ? System.out : new FileOutputStream(new File("GCJ.out"));
		Scanner input = new Scanner(inStream);
		PrintWriter out = new PrintWriter(outStream);

		while (input.hasNext()) {
			int T = input.nextInt();

			for (int t = 1; t <= T; ++t) {
				int N = input.nextInt();
				Activity[] activities = new Activity[N]; 
				
				for (int i = 0; i < activities.length; ++i) {
					activities[i] = new Activity(input.nextInt(), input.nextInt(), i);
				}
				
				Arrays.sort(activities, new Comparator<Activity>(){
					@Override
					public int compare(Activity a1, Activity a2) {
						if (a1.S == a2.S) {
							return a1.E - a2.E;
						} else {
							return a1.S - a2.S;
						}
					}
					
				});
				
				int cEnd = 0;
				int jEnd = 0;
				boolean isPossible = true;
				
				for (int i = 0; i < activities.length; ++i) {
					if (activities[i].S >= cEnd) {
						activities[i].doer = 'C';
						cEnd = activities[i].E;
					} else if (activities[i].S >= jEnd) {
						activities[i].doer = 'J';
						jEnd = activities[i].E;
					} else {
						isPossible = false;
						break;
					}
				}
				
				Arrays.sort(activities, new Comparator<Activity>(){
					@Override
					public int compare(Activity a1, Activity a2) {
						return a1.idx - a2.idx;
					}
					
				});
				
				out.printf("Case #%d: ", t);
				
				if (isPossible) {
					for (int i = 0; i < activities.length; ++i) {
						out.printf("%c", activities[i].doer);
					}
					out.println();
				} else {
					out.println("IMPOSSIBLE");
				}
			}
		}

		out.close();
		input.close();
	}
	
	private static class Activity {
		int S = 0;
		int E = 0;
		int idx = 0;
		char doer = ' ';
		
		private Activity (int S, int E, int idx) {
			this.S = S;
			this.E = E;
			this.idx = idx;
		}
	}
}

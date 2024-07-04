import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int T = in.nextInt();		
		for (int casNumero = 1; casNumero <= T; casNumero++) {
			StringBuilder resultat = new StringBuilder();
			resultat.append("Case #");
			resultat.append(casNumero);
			resultat.append(": ");
			
			int n = in.nextInt();
			List<Activity> activities = new ArrayList<>();
			boolean impossible = false;
			
			for (int i = 0; i < n; i++) {
				Activity activity = new Activity();
				activity.start = in.nextInt();
				activity.end = in.nextInt();
				activity.position = i;		
				activities.add(activity);				
			}
			
			Collections.sort(activities, new Comparator<Activity>() {
		        @Override
		        public int compare(Activity a1, Activity a2) {
		        	if (a1.start > a2.start) {
		        		return 1;
		        	}
		        	else if (a1.start < a2.start) {
		        		return -1;
		        	}
		        	return 0;
		        }
		    });		

			char[] scheduled = new char[n];
			Activity activityJ = new Activity();
			Activity activityC = new Activity();
			for (int i = 0; i < activities.size(); i++) {
				if (activityJ.end <= activities.get(i).start) {
					activityJ.end = activities.get(i).end;
					scheduled[activities.get(i).position] = 'J';
				}
				else if (activityC.end <= activities.get(i).start) {
					activityC.end = activities.get(i).end;
					scheduled[activities.get(i).position] = 'C';
				}
				else {
					impossible = true;
					break;
				}
			}
			
			
			if (impossible) {
				resultat.append("IMPOSSIBLE");
			}
			else {
				resultat.append(new String(scheduled));
			}
			
			writer.print(resultat.toString());
			writer.println();
		}
		in.close();
		writer.close();
	}	
}

class Activity {
	public int start = 0;
	public int end = 0;
	public int position = 0;
}

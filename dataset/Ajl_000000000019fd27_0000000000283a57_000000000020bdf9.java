import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T_tests = sc.nextInt();
    for (int i = 1; i <= T_tests; i++) {
	  int N_NumActivities = sc.nextInt();
	  String Schedule = DetermineSchedule(N_NumActivities, sc);
      System.out.println("Case #" + i + ": " + Schedule);
    }
	sc.close();
  }
  
  public static String DetermineSchedule(int N_NumActivities, Scanner sc) {
    int[][] Activities = new int[N_NumActivities][3];
	for (int i = 0; i < N_NumActivities; i++) {
	  Activities[i][0] = sc.nextInt();
	  Activities[i][1] = sc.nextInt();
	  Activities[i][2] = i;
	}
	Arrays.sort(Activities, new Comparator<int[]>() {
	  public int compare(int[] a, int[] b) {
		return Integer.compare(a[0], b[0]);
	  }
	});
	int C_Act = -1;
	int J_Act = -1;
	String Schedule = "";
	char[] ScheduleBuilder = new char[N_NumActivities];
	for (int i = 0; i < N_NumActivities; i++) {
		int[] ActivitiesRow = Activities[i];
		int start_time = ActivitiesRow[0];
		int end_time = ActivitiesRow[1];
		if (C_Act == -1 || Activities[C_Act][1] <= start_time) {
		  C_Act = i;
		  ScheduleBuilder[ActivitiesRow[2]] = 'C';
		} else if (J_Act == -1 || Activities[J_Act][1] <= start_time) {
		  J_Act = i;
		  ScheduleBuilder[ActivitiesRow[2]] = 'J';
		} else {
		  Schedule = "IMPOSSIBLE";
		  break;
		}
	}
	if (!Schedule.equals("IMPOSSIBLE")) {
	  Schedule = new String(ScheduleBuilder);
	}
	return Schedule;
  }
}

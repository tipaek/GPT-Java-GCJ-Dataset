import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	private static enum Parent {
		CAMERON,
		JAMIE
	}
	
	private static class Activity {
		
		private final int index;
		private final int startTime;
		private final int endTime;
		private Parent owner;
		
		public Activity(int index, int startTime, int endTime) {
			this.index = index;
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(System.out))) {
            solve(reader, writer);
        }
    }

    private static void solve(BufferedReader reader, Writer writer)
            throws Exception {
        int testCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCount; i++) {
            solveTestCase(i, reader, writer);
        }
    }

	private static void solveTestCase(int t, BufferedReader reader,
			Writer writer) throws Exception {
		Activity[] activities = parseActivities(reader);
		activities = scheduleActivities(activities);
		printResult(t, activities, writer);
	}

	private static Activity[] parseActivities(BufferedReader reader) throws Exception {
		int n = Integer.parseInt(reader.readLine());
		Activity[] activities = new Activity[n];
		for (int i = 0; i < n; i++) {
			String[] tokens = reader.readLine().split(" ");
			int startTime = Integer.parseInt(tokens[0]);
			int endTime = Integer.parseInt(tokens[1]);
			Activity activity = new Activity(i, startTime, endTime);
			activities[i] = activity;
		}
		return activities;
	}
	
	private static Activity[] scheduleActivities(Activity[] activities) {
		Activity[] activitiesOrderedByStartTime = Arrays.copyOf(activities, activities.length);
		Arrays.sort(activitiesOrderedByStartTime, new Comparator<Activity>() {

			@Override
			public int compare(Activity a1, Activity a2) {
				int comparisonStart = Integer.compare(a1.startTime, a2.startTime);
				if (comparisonStart != 0) {
					return comparisonStart;
				}
				int comparisonEnd = Integer.compare(a1.endTime, a2.endTime);
				if (comparisonEnd != 0) {
					return comparisonEnd;
				}
				int comparisonIndex = Integer.compare(a1.index, a2.index);
				return comparisonIndex;
			}
		});
		int cameronBusyUntil = 0;
		int jamieBusyUntil = 0;
		for (int i = 0; i < activitiesOrderedByStartTime.length; i++) {
			Activity activity = activitiesOrderedByStartTime[i];
			if (cameronBusyUntil <= activity.startTime) {
				activity.owner = Parent.CAMERON;
				cameronBusyUntil = activity.endTime;
			} else if (jamieBusyUntil <= activity.startTime) {
				activity.owner = Parent.JAMIE;
				jamieBusyUntil = activity.endTime;
			} else {
				return null;
			}
		}
		return activities;
	}

	private static void printResult(int t, Activity[] activities, Writer writer) throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Case #%d: ", t + 1));
		if (activities == null) {
			buffer.append("IMPOSSIBLE");
		} else {
			for (Activity activity : activities) {
				buffer.append(activity.owner.name().charAt(0));
			}
		}
		writer.write(buffer.toString());
		writer.write("\n");
		writer.flush();
	}
}

import java.io.*;
import java.util.*; 
public class Main {
	public final static  int MAX_TIME = 24 * 70;
    public static void main(String[] args) {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		OutputStream out = new BufferedOutputStream(System.out);
        try {
            int T = Integer.parseInt(bi.readLine());
            for (int t = 0; t < T; t++) {
				boolean J = false, C = false;
				String answer = "";
                int N = Integer.parseInt(bi.readLine());

            	PriorityQueue<StartActivity> startQ = new PriorityQueue<StartActivity>(N);
            	PriorityQueue<Activity> endQ = new PriorityQueue<Activity>(N);

                for (int n = 0; n < N; n++) {
					String[] raw = bi.readLine().split(" ");
                	StartActivity activity = new StartActivity(n + 1, Integer.parseInt(raw[0]), Integer.parseInt(raw[1]));
					startQ.add(activity);
                }
				int time = startQ.peek().start; 
				while ((!startQ.isEmpty() || !endQ.isEmpty()) && time <= MAX_TIME) {
					if (!endQ.isEmpty() && time == endQ.peek().end)  {
						Activity activity = endQ.poll();
						// System.out.println("[" + activity.i + "] ended " + activity);
						if (activity.isJ) {
							J = false;
						} else {
							C = false;
						}
					} else  {
						StartActivity start = startQ.poll();
						// System.out.println("started " + start);
						Activity activity = new Activity(start);
						if (C == true && J == true) {
							// IMposibble
							answer = "IMPOSSIBLE";
							// System.out.println("IMPossible ! " + activity);
							break;
						} else if (C == false) {
							activity.isJ = false;
							C = true;
							answer += "C";
							// System.out.println("[" + activity.i + "] Assigned to C ! " + activity);
						} else {
							activity.isJ = true;
							J = true;
							answer += "J";
							// System.out.println("[" + activity.i + "] Assigned to J ! " + activity);
						}
						endQ.add(activity);
					} 

					if (startQ.isEmpty() && endQ.isEmpty()) break;
					if (!startQ.isEmpty() && !endQ.isEmpty()) {
						time = Math.min(startQ.peek().start, endQ.peek().end);
					} else if (!startQ.isEmpty()) {
						time = startQ.peek().start;
					} else {
						time = endQ.peek().end;
					}
				}
				
				out.write(("Case #" + (t + 1) + ": " + answer + "\n").getBytes());
				answer = "";
			}
            
            // out.write((ans.toString() + "\n").getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static class StartActivity implements Comparable<StartActivity> {
        public int i, start, end;
        
        public StartActivity(int i, int start, int end) {
            this.i = i;
            this.start = start;
            this.end = end;
        }
        public int compareTo(StartActivity activity) { 
            return Integer.compare(this.start, activity.start);
        } 

		public String toString() {
			return i + "th Start Activity (" + start + " ~ " + end + ")";
		}
    }

	 public static class Activity implements Comparable<Activity> {
        public int i, start, end;
		public boolean isJ;
        
        public Activity(StartActivity act) {
            this.i = act.i;
            this.start = act.start;
            this.end = act.end;
        }
        public int compareTo(Activity activity) { 
            return Integer.compare(this.end, activity.end);
        } 

		public String toString() {
			return i + "th Activity (" + start + " ~ " + end + ")";
		}
    }

}

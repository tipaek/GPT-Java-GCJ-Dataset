/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		Answer solution = new Answer();
		solution.solve(in, out);
		out.flush();
		out.close();
	}
}

class Answer {
    public void solve(Scanner in, PrintWriter out) {
        int test_cases = in.nextInt();
        for (int test_case = 0; test_case < test_cases; test_case++) {
            int numActivities = in.nextInt();
            int lastC = 0;
            int lastJ = 0;
            boolean cannotSolve = false;
            StringBuilder ans = new StringBuilder();
            List<Integer> startTimes = new ArrayList<Integer>();
            Map<Integer, List<Integer>> startTimesToEndTimes = new HashMap<Integer, List<Integer>>();
            
            for (int i=0; i<numActivities; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                
                startTimes.add(startTime);
                
                if (startTimesToEndTimes.containsKey(startTime)) {
                    List<Integer> l = startTimesToEndTimes.get(startTime);
                    l.add(endTime);
                    Collections.sort(l);
                    startTimesToEndTimes.put(startTime, l);
                } else {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(endTime);
                    startTimesToEndTimes.put(startTime, l);
                }
            }
            
            Collections.sort(startTimes);
            
            for (int i=0; i<startTimes.size(); i++) {
                int startTime = startTimes.get(i);

                if (cannotSolve) {
                    continue;
                }
                
                if (startTime >= lastC && lastC <= lastJ) {
                    List<Integer> endTimes = startTimesToEndTimes.get(startTime);
                    lastC = endTimes.remove(0);
                    ans.append("C");
                } else if (startTime >= lastJ) {
                    List<Integer> endTimes = startTimesToEndTimes.get(startTime);
                    lastJ = endTimes.remove(0);
                    ans.append("J");
                } else {
                    ans = new StringBuilder();
                    ans.append("IMPOSSIBLE");
                    cannotSolve = true;
                }
            }
            
            out.println(String.format("Case #%d: %s", (test_case+1), ans.toString()));
        }
    }
}
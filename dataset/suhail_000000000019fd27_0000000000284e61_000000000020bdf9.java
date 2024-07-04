import java.util.*;
import java.io.*;
public class Solution {
    static class Activity{
        public int start;
        public int end;
        public int position;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            TreeMap<Integer, Activity> map = new TreeMap<Integer, Activity>();
            for(int j=0; j<n; j++) {
                Activity activity = new Activity();
                activity.start = in.nextInt();
                activity.end = in.nextInt();
                activity.position = j;
                map.put(activity.start,activity);
            }
            int cTime = 0;
            int jTime = 0;
            char[] output = new char[n];
            boolean caseImposible = false;
            for(Map.Entry<Integer, Activity> session : map.entrySet()) {
                if(session.getKey() >= cTime) {
                    output[session.getValue().position] = 'C';
                    cTime = session.getValue().end;
                } else if(session.getKey() >= jTime) {
                    output[session.getValue().position] = 'J';
                    jTime = session.getValue().end;
                } else {
                    caseImposible = true;
                    break;
                }
            }
            if(caseImposible) {
                sb.append("Case #"+i+": IMPOSSIBLE\n");
            } else {
                sb.append("Case #"+i+": "+new String(output)+"\n");
            }

        }
        System.out.print(sb.toString());
    }
}
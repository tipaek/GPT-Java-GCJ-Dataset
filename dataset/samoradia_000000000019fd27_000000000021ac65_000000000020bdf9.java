import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public static void main(String[] Args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        int count = 1;
        while (count <= cases) {
            int job = Integer.parseInt(in.readLine());
            String out = "";
            HashMap<Integer, List<Integer>> times = new HashMap<>();
            HashMap<Integer, List<Integer>> OrderedTimes = new HashMap<>();
            for (int i = 0; i < job; i++) {
                String[] split = in.readLine().split(" ");
                if (times.get(Integer.parseInt(split[0])) == null) {
                    times.put(Integer.parseInt(split[0]), new ArrayList<Integer>());
                    times.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
                } else {
                    times.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
                }
                if (OrderedTimes.get(Integer.parseInt(split[0])) == null) {
                    OrderedTimes.put(Integer.parseInt(split[0]), new ArrayList<Integer>());
                    OrderedTimes.get(Integer.parseInt(split[0])).add(i);
                } else {
                    OrderedTimes.get(Integer.parseInt(split[0])).add(i);
                }
            }
            Set<Integer> startTimes = times.keySet();
            Integer[] starts = new Integer[job];
            startTimes.toArray(starts);
            PriorityQueue<Integer> ordered = new PriorityQueue<>();
            String[] order = new String[job];
            for(int i = 0; i < startTimes.size(); i++) {
                for (int j = 0; j < times.get(starts[i]).size(); j++) {
                    ordered.add(starts[i]);
                }
            }
            boolean j = false;
            int jEnd = 0;
            boolean c = false;
            int cEnd = 0;
            for (int  i = 0; i < job; i++) {
                int startTime = ordered.remove();
                if (j && startTime >= jEnd) {
                    j = false;
                }
                if (c && startTime >= cEnd) {
                    c= false;
                }
                if (!j) {
                    j = true;
                    jEnd = times.get(startTime).remove(0);
                    order[OrderedTimes.get(startTime).get(0)] = "J";
                    OrderedTimes.get(startTime).remove(0);
                } else if (!c) {
                    c = true;
                    cEnd = times.get(startTime).remove(0);
                    order[OrderedTimes.get(startTime).get(0)] = "C";
                    OrderedTimes.get(startTime).remove(0);
                } else {
                    out = "IMPOSSIBLE";
                    i = job;
                }
            }
            if (out.length() == 0) {
                for(int  i = 0; i < order.length; i++) {
                    out += order[i];
                }
                System.out.println("Case #" + count + ": " + out);
            } else {
                System.out.println("Case #" + count + ": " + out);
            }
            count++;
        }
    }
}
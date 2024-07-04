import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
            HashMap<Integer, Integer> times = new HashMap<>();
            HashMap<Integer, Integer> OrderedTimes = new HashMap();
            for (int i = 0; i < job; i++) {
                String[] split = in.readLine().split(" ");
                times.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                OrderedTimes.put(Integer.parseInt(split[0]), i);
            }
            Set<Integer> startTimes = times.keySet();
            Integer[] starts = new Integer[job];
            startTimes.toArray(starts);
            PriorityQueue<Integer> ordered = new PriorityQueue<>();
            String[] order = new String[job];
            for(int i = 0; i < job; i++) {
                ordered.add(starts[i]);
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
                    jEnd = times.get(startTime);
                    order[OrderedTimes.get(startTime)] = "J";
                } else if (!c) {
                    c = true;
                    cEnd = times.get(startTime);
                    order[OrderedTimes.get(startTime)] = "C";
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

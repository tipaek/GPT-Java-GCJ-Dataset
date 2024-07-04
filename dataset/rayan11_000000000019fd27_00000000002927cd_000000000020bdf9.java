import java.util.*;
import java.io.*;

public class Solution {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt (br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase ++) {
            int n = Integer.parseInt (br.readLine().trim());
            int [][] intervals = new int [n][2];
            for (int i = 0; i < n; i ++) {
                intervals[i] = Arrays.stream (br.readLine().trim().split (" ")).mapToInt (Integer::parseInt).toArray();
            }
            HashMap<String, List<String>> graph = createGraph(intervals);
            //System.out.println (graph);
            System.out.printf ("Case #%d: %s\n", testCase, evalAns (graph, intervals));
        }
    }

    public static HashMap<String, List<String>> createGraph (int [][] intervals) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < intervals.length; i ++) {
            for (int j = 0; j < intervals.length; j ++) {
                if (i == j) continue;
                if (! graph.containsKey (i + ": " + intervals[i][0] + " " + intervals[i][1])) {
                    graph.put (i + ": " + intervals[i][0] + " " + intervals[i][1], new ArrayList<>());
                }
                if (overlaps (intervals[i], intervals[j]))
                    graph.get (i + ": " + intervals[i][0] + " " + intervals[i][1]). add (j + ": " + intervals[j][0] + " " + intervals[j][1]);
            }
        }
            return graph;
    }

    public static String evalAns (HashMap<String, List<String>> graph, int [][] intervals) {
        HashMap<String, String> ans = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < intervals.length; i ++) {
            int [] curr = intervals[i];
            String node = i + ": " + curr[0] + " " + curr[1];
            if (visited.contains (node)) continue;
            queue.add (node);
            while (! queue.isEmpty()) {
                String currNode = queue.poll();
                visited.add (currNode);
                if (! ans.containsKey (currNode)) ans.put (currNode, "C");
                if (graph.get (currNode) == null) continue;
                for (String child: graph.get (currNode)) {
                    if (ans.containsKey (child) && ans.get (child).equals(ans.get (currNode))) 
                        return "IMPOSSIBLE";
                    String value = ans.get (currNode).equals("C") ? "J" : "C";
                    ans.put (child, value);
                    if (! visited.contains (child)) {
                        queue.add (child);
                    }
                }
            }
        }

        return getAns (ans, intervals);
    }

    public static String getAns (HashMap<String, String> map, int [][] ivs) {
        StringBuilder ans = new StringBuilder ();
        for (int i = 0; i < ivs.length; i ++) {
            ans.append (map.get (i + ": " + ivs[i][0] + " " + ivs[i][1]));
        }

        return ans.toString();
    }

    public static boolean overlaps (int [] ar, int [] br) {
        List<int []> list = new ArrayList<>();
        list.add (ar);
        list.add (br);
        Collections.sort (list, (a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        if (list.get (0)[1] > list.get (1)[0]) return true;
        return false;
    }
}
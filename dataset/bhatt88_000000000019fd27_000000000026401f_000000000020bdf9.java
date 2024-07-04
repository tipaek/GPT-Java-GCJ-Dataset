import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int c = 0; c < cases; c++) {
            Map<Integer, List<Integer>> startMap = new HashMap<>();
            Map<Integer, Integer> endMap = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int l = 0; l < n; l++) {
                String line = br.readLine();
                String[] arr = line.split(" ", 2);
                int start = Integer.parseInt(arr[0]);
                int end = Integer.parseInt(arr[1]);
                if (startMap.get(start) == null) {
                    startMap.put(start, new ArrayList<>());
                }
                startMap.get(start).add(l);
                endMap.put(l, end);
            }
            System.out.println("Case #" + (c + 1) + ": " + getResult(startMap, endMap, n));
        }
    }

    private static String getResult(Map<Integer, List<Integer>> startMap, Map<Integer, Integer> endMap, int n) {
        ArrayList<Integer> startList = new ArrayList<Integer>(startMap.keySet());
        Collections.sort(startList);
        int maxJ = 0;
        int maxC = 0;
        char[] assign = new char[n];
        for (int start : startList) {
            List<Integer> tasks = startMap.get(start);
            for (int tasknum : tasks) {
                if (maxC <= start) {
                    assign[tasknum] = 'C';
                    maxC = endMap.get(tasknum);
                } else if (maxJ <= start) {
                    assign[tasknum] = 'J';
                    maxJ = endMap.get(tasknum);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        return new String(assign);
    }
}
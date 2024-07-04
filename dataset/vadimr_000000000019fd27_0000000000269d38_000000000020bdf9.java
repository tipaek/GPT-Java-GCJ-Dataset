import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(reader.readLine());

        for (int k = 1; k <= testCases; k++) {
            Integer N = Integer.parseInt(reader.readLine());
            List<int[]> intervals = new ArrayList<>();
            List<int[]> original = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] line = reader.readLine().split(" ");
                intervals.add(new int[] {Integer.parseInt(line[0]),  Integer.parseInt(line[1])});
                original.add(new int[] {Integer.parseInt(line[0]),  Integer.parseInt(line[1])});
            }

            String result = solve(intervals, original, N);
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + k + ": " + result);
            System.out.println(sb.toString());
        }
    }

    public static String solve(List<int[]> intervals, List<int[]> original, int N) {
        //StringBuilder sb = new StringBuilder();
        char[] result = new char[N];
        Collections.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] mask = new int[N];
        for (int i = 0; i < N; i++) {
            int[] current = original.get(i);
            for (int j = 0; j < N; j++) {
                if(current[0] == intervals.get(j)[0] && current[1] == intervals.get(j)[1]) {
                    mask[j] = i;
                    break;
                }
            }
        }

        Stack<Integer> jj = new Stack<>();
        Stack<Integer> cc = new Stack<>();
        jj.add(intervals.get(0)[1]);
        result[mask[0]] = 'C';
        //sb.append("C");
        Map<Character, Integer> map = new HashMap<>();
        map.put('J', 0);
        map.put('C', intervals.get(0)[1]);

        for (int i = 1; i < N; i++) {
            int[] current = intervals.get(i);
            boolean isInserted = false;
            for (char name : map.keySet()) {
                if (map.get(name) <= current[0]) {
                    map.put(name, current[1]);
                    isInserted = true;
                    //sb.append(name);
                    result[mask[i]] = name;
                    break;
                }
            }
            if (!isInserted) {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }
}

import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {


        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('N', new int[]{0, 1});
        map.put('S', new int[]{0, -1});
        map.put('W', new int[]{-1, 0});
        map.put('E', new int[]{1, 0});
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] params = line.split(" ");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            String path = params[2];
            int m = findPath(x, y, path, map);
            if (m == -1) {
                System.out.println(String.format("Case #%d: %s", i, "IMPOSSIBLE"));
            } else {
                System.out.println(String.format("Case #%d: %d", i, m));
            }
        }


    }

    private static int findPath(int px, int py, String path, HashMap<Character, int[]> dirMap) {
        {
        int dst[][] = new int[path.length() + 1][2];
        dst[0][0] = px;
        dst[0][1] = py;
        for (int i = 1; i <= path.length(); i++) {
            int[] dir = dirMap.get(path.charAt(i - 1));
            dst[i][0] = dst[i - 1][0] + dir[0];
            dst[i][1] = dst[i - 1][1] + dir[1];
        }

        int i = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int end[] = queue.peek();
        HashMap<Integer, HashSet<Integer>> record = new HashMap<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.pollFirst();
            for (int j = i; j <= path.length(); j++) {
                int step = j - i;
                int diff = Math.abs(dst[j][0] - poll[0]) + Math.abs(dst[j][1] - poll[1]);
                if (diff <= step) {
                    return i + step;
                }
            }
            for (Character c : dirMap.keySet()) {
                int[] dir = dirMap.get(c);
                int x = poll[0] + dir[0];
                int y = poll[1] + dir[1];
                HashSet<Integer> set = record.get(x);
                if (set == null) {
                    set = new HashSet<>();
                    record.put(x, set);
                }
                if (set.add(y)) {
                    queue.addLast(new int[]{x, y});
                }
            }
            if (end == poll) {
                i++;
                end = queue.peekLast();
            }
            if (i > path.length()) break;
        }
        return -1;
    }
    }


}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer testCases = Integer.parseInt(reader.readLine());

        for (int k = 1; k <= testCases; k++) {
            String[] s = reader.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            String way = s[2];

            int result = solve(x, y, way);
            StringBuilder sb = new StringBuilder();
            String ss = result == -1 ? "IMPOSSIBLE" : "" + result;
            sb.append("Case #" + k + ": " + ss);
            System.out.println(sb.toString());
            res = Integer.MAX_VALUE;
        }
    }

    public static int solve(int x, int y, String way) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>(); //todo improve: add length to 0;0 - heap?
        int steps = 0;
        map.put(x * 10000 + y, steps);
        ++steps;

        for (char c : way.toCharArray()) {
            int hash = 0;
            if (c == 'N') {
                hash = x * 10000 + y + 1;
                y++;
            } else if (c == 'S') {
                hash = x * 10000 + y - 1;
                y--;
            } else if (c == 'E') {
                hash = (x + 1) + 10000 + y;
                x++;
            } else if (c == 'W') {
                hash = (x - 1) + 10000 + y;
                x--;
            }
            map.put(hash, steps);
            ++steps;
        }

        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();

        map.forEach((k, v) -> {
            if (!visited.contains(k)) {
                visited2.clear();
                int x2 = k / 10000;
                int y2 = k % 10000;
                queue.clear();
                queue.add(0);
                AtomicInteger steps2 = new AtomicInteger();
                while (!queue.isEmpty()) {
                    int n = queue.size();

                    for (int i = 0; i < n; ++i) {
                        Integer cur = queue.poll();
                        if (visited2.contains(cur)) {
                            continue;
                        }
                        int x1 = cur / 10000;
                        int y1 = cur % 10000;

                        if (map.containsKey(cur)) {
                            if (map.get(cur) >= steps2.get()) {
                                if (map.get(cur) < res) {
                                    res = map.get(cur);
                                }
                                //res = Math.min(res, map.get(cur));
                            }
                            if (cur.equals(k)) {
                                queue.clear();
                                visited.add(cur);
                                break;
                            }
                        }
                        visited.add(cur);

                        int dest = (int) Math.abs(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));

                        int newDest = (int) Math.abs(Math.sqrt(Math.pow(x1 + 1 - x2, 2) + Math.pow(y1 - y2, 2)));
                        if (newDest <= dest) {
                            queue.add((x1 + 1) * 10000 + y1);
                        }

                        newDest = (int) Math.abs(Math.sqrt(Math.pow(x1 - 1 - x2, 2) + Math.pow(y1 - y2, 2)));
                        if (newDest <= dest) {
                            queue.add((x1 - 1) * 10000 + y1);
                        }
                        newDest = (int) Math.abs(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 + 1 - y2, 2)));
                        if (newDest <= dest) {
                            queue.add(x1 * 10000 + y1 + 1);
                        }
                        newDest = (int) Math.abs(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - 1 - y2, 2)));
                        if (newDest <= dest) {
                            queue.add(x1 * 10000 + y1 - 1);
                        }
                    }
                    steps2.getAndIncrement();
                    if (steps2.get() > map.get(k)) {
                        break;
                    }

                }
            }
        });


        return res == Integer.MAX_VALUE ? -1 : res;
    }
}


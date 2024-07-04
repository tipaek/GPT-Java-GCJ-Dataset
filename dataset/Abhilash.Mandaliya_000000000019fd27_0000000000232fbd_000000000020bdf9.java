import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for (int z = 1; z <= t; z++) {
                int n = Integer.parseInt(br.readLine());
                List<Pair> tasks = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    String[] times = br.readLine().split(" ");
                    tasks.add(new Pair(Integer.parseInt(times[0]), Integer.parseInt(times[1])));
                }
                sort(tasks);
                StringBuilder result = new StringBuilder();
                boolean ca = true, ja = true, impossible = false;
                int ci = -1, ji = -1;
                for (int i = 0; i < tasks.size() && !impossible; i++) {
                    if (ca) {
                        ca = false;
                        result.append("C");
                        ci = i;
                    } else if (ja) {
                        ja = false;
                        result.append("J");
                        ji = i;
                    } else {
                        if (tasks.get(ci).e <= tasks.get(i).s) {
                            result.append("C");
                            ci = i;
                        } else if (tasks.get(ji).e <= tasks.get(i).s) {
                            result.append("J");
                            ji = i;
                        } else {
                            impossible = true;
                        }
                    }
                }
                System.out.print("Case #" + z + ": ");
                System.out.println(impossible ? "IMPOSSIBLE" : result.toString());
            }
        } catch (Throwable t) {
            System.out.println("Exception occured bro " + t);
        }
    }

    private static void sort(List<Pair> tasks) {
        tasks.sort((p1, p2) -> {
            int result = Integer.compare(p1.s, p2.s);
            if (result == 0) {
                return Integer.compare(p1.e, p2.e);
            }
            return result;
        });
    }
}

class Pair {
    int s, e;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
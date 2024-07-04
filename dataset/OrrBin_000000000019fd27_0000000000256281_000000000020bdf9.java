import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Set<Entry> entries = new TreeSet<>((t1, t2) -> {
                int result = Integer.compare(t1.time, t2.time);
                if (result != 0)
                    return result;

                if (!t1.isStart)
                    return -1;
                if (!t2.isStart)
                    return 1;

                return 1;
            });
            for (int j = 0; j < n; j++) {
                Entry startEntry = new Entry(j, in.nextInt(), true);
                Entry endEntry = new Entry(j, in.nextInt(), false);

                entries.add(startEntry);
                entries.add(endEntry);


            }

            StringBuilder result = new StringBuilder();
            List<Entry> prefix = new ArrayList<>();
            Iterator<Entry> iter = entries.iterator();
            Entry prev = iter.next();
            prefix.add(prev);
            result.append('C');
            prev.isC = true;
            while (iter.hasNext()) {
                Entry curr = iter.next();
                if (curr.isStart) {
                    if (prefix.size() >= 2) {
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    }

                    if (prefix.size() == 0) {
                        result.append('C');
                        curr.isC = true;
                    } else {
                        if (prefix.get(0).isC) {
                            curr.isC = false;
                            result.append('J');
                        } else {
                            curr.isC = true;
                            result.append('C');
                        }

                    }
                    prefix.add(curr);

                } else {
                    prefix.removeIf(e -> e.id == curr.id);
                }
            }


            System.out.println(String.format("Case #%d: %s", i, result.toString()));
        }
    }
}

class Entry {
    int id;
    int time;
    boolean isStart;
    boolean isC;

    public Entry(int id, int time, boolean isStart) {
        this.id = id;
        this.time = time;
        this.isStart = isStart;
    }
}
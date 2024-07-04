import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ducbm
 */
public class Solution {

    static class Entry implements Comparable<Entry> {

        public int S;
        public int E;
        public int idx;

        public Entry(int S, int E, int idx) {
            this.S = S;
            this.E = E;
            this.idx = idx;
        }

        @Override
        public int compareTo(Entry o) {
            return E - o.E;
        }
    }

    public static void main(String[] args) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int T = Integer.valueOf(reader.readLine());

                for (int i = 0; i < T; i++) {
                    int N = Integer.valueOf(reader.readLine());
                    boolean impossible = false;

                    List<Entry> lst = new ArrayList<>();
                    for (int j = 0; j < N; j++) {
                        String line = reader.readLine();
                        String[] tokens = line.split(" ");

                        int S = Integer.valueOf(tokens[0]);
                        int E = Integer.valueOf(tokens[1]);

                        Entry entry = new Entry(S, E, j);
                        lst.add(entry);
                    }

                    Collections.sort(lst);
                    int end = lst.get(0).E;

                    List<Entry> lst1 = new ArrayList<>();
                    List<Entry> lst2 = new ArrayList<>();

                    lst1.add(lst.get(0));

                    for (int j = 1; j < lst.size(); j++) {
                        Entry entry = lst.get(j);

                        if (entry.S >= end) {
                            lst1.add(entry);
                        } else {
                            if (lst2.isEmpty()) {
                                lst2.add(entry);
                            } else {
                                Entry entry2 = lst2.get(lst2.size() - 1);
                                if (entry.S >= entry2.E) {
                                    lst2.add(entry);
                                } else {
                                    // IMPOSSIBLE
                                    impossible = true;
                                    break;
                                }
                            }

                            // change role
                            List<Entry> tmp = lst1;
                            lst1 = lst2;
                            lst2 = tmp;
                        }

                        end = entry.E;
                    }

                    if (impossible) {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
                    } else {
                        char[] ret = new char[N];
                        for (Entry entry : lst1) {
                            ret[entry.idx] = 'C';
                        }
                        for (Entry entry : lst2) {
                            ret[entry.idx] = 'J';
                        }

                        System.out.println(String.format("Case #%d: %s", i + 1, new String(ret)));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

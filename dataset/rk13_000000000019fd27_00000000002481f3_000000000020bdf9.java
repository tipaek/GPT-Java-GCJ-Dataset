import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= t; ++i) {

            List<Entry> entries = new ArrayList<>();
            int n = Integer.parseInt(in.nextLine());

            for (int r = 0; r < n; r++) {
                String[] s = in.nextLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                entries.add(new Entry(r, start, end));
            }

            List<Entry> original = new ArrayList<>(entries);
            entries.sort(Comparator.comparing(Entry::getStart).thenComparing(Entry::getPos));

            Entry cameron = entries.get(0).cameron();
            Entry jack = entries.get(1).jack();

            boolean impossible = false;
            for (int j = 2; j < n; j++) {
                Entry entry = entries.get(j);
                if (entry.start >= cameron.end) {
                    cameron = entry.cameron();
                } else if (entry.start >= jack.end) {
                    jack = entry.jack();
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                String result = original.stream().map(Entry::getWho).collect(Collectors.joining());
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    static class Entry {

        int pos;
        int start;
        int end;
        String who;

        public String getWho() {
            return who;
        }

        public Entry(int pos, int start, int end) {
            this.pos = pos;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPos() {
            return pos;
        }

        public Entry cameron() {
            who = "C";
            return this;
        }

        public Entry jack() {
            who = "J";
            return this;
        }
    }
}



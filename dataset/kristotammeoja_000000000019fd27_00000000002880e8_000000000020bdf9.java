import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; ++i) {
            solve(i+1, in);
        }
    }

    private static void solve(int test_nr, BufferedReader in) throws IOException {
        int n = Integer.parseInt(in.readLine());
        Slot[] a = new Slot[n];
        Slot[] s = new Slot[n];
        for (int i = 0; i < n; ++i) {
            a[i] = new Slot(in.readLine());
            s[i] = a[i];
        }

        Slot sorter = new Slot("0 0");
        Arrays.sort(s, sorter);

        String res = "IMPOSSIBLE";
        if (trySolve(s)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i)
                sb.append(a[i].s);
            res = sb.toString();
        }

        System.out.println(String.format("Case #%d: %s", test_nr, res));
    }

    private static boolean trySolve(Slot[] s) {
        int last_C = 0;
        for (int i = 0; i < s.length; ++i) {
            Slot slot = s[i];
            if (last_C <= slot.start) {
                slot.s = "C";
                last_C = slot.end;
            }
        }

        int last_J = 0;
        for (int i = 0; i < s.length; ++i) {
            Slot slot = s[i];
            if (null != slot.s) continue;

            if (last_J <= slot.start) {
                slot.s = "J";
                last_J = slot.end;
            } else {
                return  false;
            }
        }

        return  true;
    }

    static class Slot implements Comparator<Slot> {
        String s;
        int start, end;
        public Slot(String line) {
            StringTokenizer st = new StringTokenizer(line);
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
        }

        @Override
        public int compare(Slot slot, Slot slot2) {
            if (slot.start == slot2.start) {
                return slot.end - slot2.end;
            }
            return slot.start - slot2.start;
        }
    }
}

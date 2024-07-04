
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static class Interval {
        int start, end;
        Character work;

        public Interval(int start, int end, Character work) {
            this.start = start;
            this.end = end;
            this.work = work;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = s.nextInt();
        ArrayList<String> lists = new ArrayList<>();
        for (int j = 1; j <= t; j++) {
            int n = s.nextInt();
            List<Interval> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int S = s.nextInt();
                int E = s.nextInt();
                list.add(new Interval(S, E, null));
            }
            String ans = check(list, n);
            lists.add("case #" + j + ": " + ans);
        }
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
        s.close();
    }

    private static String check(List<Interval> list, int n) {

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        //C
        int i = 0;
        list.get(i).work = 'C';
        for (int j = i + 1; j < n; j++) {
            if (list.get(j).start >= list.get(i).end) {
                list.get(j).work = 'C';
                i = j;

            }
        }
        if (i < n) {
            //find work for J
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).work == null) {
                    i = j;
                    break;
                }
            }
            //J
            if (list.get(i).work == null)
                list.get(i).work = 'J';
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).start >= list.get(i).end) {
                    if (list.get(j).work == null) {
                        list.get(j).work = 'J';
                        i = j;
                    }

                }
            }
        }

        String ans = "";
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).work != null) {
                ans += list.get(j).work;
            }
        }
        if (ans.length() == n)
            return ans;
        else
            return "IMPOSSIBLE";
    }
}

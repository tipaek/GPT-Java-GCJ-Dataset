package codejam2020;

import java.util.*;

class Time implements Comparable<Time> {
    int start;
    int end;
    int index;

    public Time(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Time o) {
        return start - o.start;
    }

    public boolean overlap(Time o) {
        return start >= o.start && start < o.end;
    }
}


public class Solution {


    public static void main(String[] args) throws Exception {

        //Scanner in = new Scanner(new java.io.FileInputStream("parenting.in"));
         Scanner in = new Scanner(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            List<Time> list = new ArrayList<>();
            for (int n = 0; n < N; n++) {
                list.add(new Time(in.nextInt(), in.nextInt(), n));
            }
            System.out.println("Case #" + t + ": " + compute(list));
        }
        in.close();
    }


    public static String compute(List<Time> list) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        Random rnd = new Random();
        Hashtable<Integer, Boolean> table = new Hashtable<>();
        Time C = null;
        Time J = null;
        for (Time time : list) {
            if (C != null) {
                if (!time.overlap(C)) {
                    C = null;
                }
            }
            if (J != null) {
                if (!time.overlap(J)) {
                    J = null;
                }
            }
            if (C == null && J == null) {
                if (rnd.nextBoolean()) {
                    C = time;
                    table.put(C.index, true);
                } else {
                    J = time;
                    table.put(J.index, false);
                }
                continue;
            }
            if (C == null) {
                C = time;
                table.put(C.index, true);
                continue;
            }

            if (J == null) {
                J = time;
                table.put(J.index, false);
                continue;
            }
            return "IMPOSSIBLE";
        }

        for (int n = 0; n < list.size(); n++) {
            sb.append(table.get(n) ? "C" : "J");
        }


        return sb.toString();
    }


}

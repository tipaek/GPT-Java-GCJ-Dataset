import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ct = 1;
        while (ct <= t) {
            int nt = sc.nextInt();
            int[][] ar = new int[nt][2];
            int[][] war = new int[nt][2];

            for (int i = 0; i < nt; i++) {
                ar[i][0] = sc.nextInt();
                war[i][0] = ar[i][0];
                ar[i][1] = sc.nextInt();
                war[i][1] = ar[i][1];
            }
            Arrays.sort(war, new Comparator<int[]>() {
                @Override
                public int compare(final int[] a1, final int[] a2) {
                    return a1[1] - a2[1];
                }
            });
//            prints(war);
            process(nt, war, ar, ct);
            ct++;
        }
    }

    private static void prints(int[][] war) {
        for (int i = 0; i < war.length; i++) {
            System.out.println(war[i][0] + " " + war[i][1]);
        }
    }

    private static void process(int nt, int[][] war,  int[][] ar, int ct) {
        int cameron = 0;
        int jamie = 0;
        boolean impossible = false;
        Map<String, String> map = new HashMap();

        for (int i = 0; i < nt && !impossible; i++) {
            String key = war[i][0] + "," + war[i][1];
            if (cameron <= war[i][0]  && jamie <= war[i][0]) {
                if (cameron >= jamie) {
                    map.put(key, "C");
                    cameron = war[i][1];
                } else {
                    map.put(key, "J");
                    jamie = war[i][1];
                }
            } else if (cameron <= war[i][0]) {
                map.put(key, "C");
                cameron = war[i][1];
            } else if (jamie <= war[i][0]) {
                map.put(key, "J");
                jamie = war[i][1];
            } else {
                impossible = true;
            }
        }

        if (impossible) {
            System.out.println("Case #" + ct + ": " + "IMPOSSIBLE");
        } else {
            printPossibility(nt, ar, map, ct);
        }
    }

    private static void printPossibility(int nt, int[][] ar, Map<String, String> map, int ct) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nt; i++) {
            sb.append(map.get(ar[i][0] + "," + ar[i][1]));
        }
        System.out.println("Case #" + ct + ": " + sb.toString());
    }
}
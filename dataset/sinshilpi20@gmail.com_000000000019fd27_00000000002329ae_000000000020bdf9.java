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
            Map<String, String> map = new HashMap();
            for (int i = 0; i < nt; i++) {
                ar[i][0] = sc.nextInt();
                war[i][0] = ar[i][0];
                ar[i][1] = sc.nextInt();
                war[i][1] = ar[i][1];
            }
            Arrays.sort(war, new Comparator<int[]>() {
                @Override
                public int compare(final int[] a1, final int[] a2) {
                    return a1[0] - a2[0];
                }
            });

            int cameron = 0;
            int jamie = 0;
            boolean impossible = false;

            for (int i = 0; i < nt && !impossible; i++) {
                if (war[i][0] >= cameron) {
                    map.put(war[i][0] + "," + war[i][1], "C");
                    cameron = war[i][1];
                } else if (war[i][0] >= jamie) {
                    map.put(war[i][0] + "," + war[i][1], "J");
                    jamie = war[i][1];
                } else {
                    impossible = true;
                }
            }
            if (impossible) {
                System.out.println("Case #" + ct + ": " + "IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < nt; i++) {
                    sb.append(map.get(ar[i][0] + "," + ar[i][1]));
                }
                System.out.println("Case #" + ct + ": " + sb.toString());
            }
            ct++;
        }
    }
}
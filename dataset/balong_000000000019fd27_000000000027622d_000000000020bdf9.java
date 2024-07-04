import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    static class Mission {
        int id;
        int start;
        int end;
        Mission(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }


    public static void solve(Scanner scanner) {

        int numberOfCase = scanner.nextInt();

        for (int ca = 1; ca <= numberOfCase; ca++) {

            Mission[] missions = new Mission[scanner.nextInt()];

            for (int i = 0; i < missions.length; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                missions[i] = new Mission(i, start, end);
            }
            Arrays.sort(missions, new Comparator<Mission>() {
                public int compare(Mission o1, Mission o2) {
                    return o1.start - o2.start;
                }
            });

            int c = 0;
            int j = 0;

            boolean impossible = false;
            char[] arrange = new char[missions.length];

            for (int i = 0; i < missions.length; i++) {
                if (missions[i].start >= c) {
                    arrange[missions[i].id] = 'C';
                    c = missions[i].end;
                } else if (missions[i].start >= j) {
                    arrange[missions[i].id] = 'J';
                    j = missions[i].end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + ca + ":" + " " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + ca + ":" + " " + new String(arrange));
            }
        }
    }

}
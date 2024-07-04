import java.util.*;
import java.io.*;
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(in);
    }

    static class Mission {
        int start;
        int end;
        Mission(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void solve(Scanner scanner) {

        int numberOfCase = scanner.nextInt();

        for (int ca = 1; ca <= numberOfCase; ca++) {
            Mission[] missions = new Mission[scanner.nextInt()];
            for (int i = 0; i < missions.length; i++) {
                missions[i] = new Mission(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(missions, new Comparator<Mission>() {
                public int compare(Mission o1, Mission o2) {
                    return o1.end - o2.end;
                }
            });

            int c = 0;
            int j = 0;
            String arrange = "";
            for (int i = 0; i < missions.length; i++) {
                if (missions[i].start >= c) {
                    arrange += "C";
                    c = missions[i].end;
                } else if (missions[i].start >= j) {
                    arrange += "J";
                    j = missions[i].end;
                } else {
                    arrange = "IMPOSSIBLE";
                    break;
                }
            }

            System.out.println("Case #" + ca + ":" + " " + arrange);
        }
    }

}

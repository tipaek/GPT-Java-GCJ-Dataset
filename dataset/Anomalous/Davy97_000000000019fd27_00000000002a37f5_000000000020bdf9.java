import java.util.*;

public class Solution {

    private int id, pos, in;

    public Solution(int id, int pos, int in) {
        this.id = id;
        this.pos = pos;
        this.in = in;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ans = new char[1005];

        int T = scanner.nextInt();
        for (int ca = 1; ca <= T; ca++) {
            List<Solution> intervals = new ArrayList<>();
            int n = scanner.nextInt();
            int totalIntervals = 0;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Solution(i, start, 1));
                intervals.add(new Solution(i, end, 0));
                totalIntervals += 2;
            }

            intervals.sort((a, b) -> {
                if (a.pos == b.pos) {
                    if (a.in == b.in) {
                        return Integer.compare(a.id, b.id);
                    }
                    return Integer.compare(a.in, b.in);
                }
                return Integer.compare(a.pos, b.pos);
            });

            int activeIntervals = 0;
            boolean possible = true;
            boolean cAssigned = false, jAssigned = false;

            for (int i = 0; i < totalIntervals && possible; i++) {
                Solution interval = intervals.get(i);

                if (interval.in == 1) {
                    if (activeIntervals < 2) {
                        if (!cAssigned) {
                            ans[interval.id] = 'C';
                            cAssigned = true;
                        } else if (!jAssigned) {
                            ans[interval.id] = 'J';
                            jAssigned = true;
                        }
                    } else {
                        possible = false;
                        break;
                    }
                    activeIntervals++;
                } else {
                    activeIntervals--;
                    if (ans[interval.id] == 'C') {
                        cAssigned = false;
                    } else {
                        jAssigned = false;
                    }
                }
            }

            System.out.print("Case #" + ca + ": ");
            if (possible) {
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}
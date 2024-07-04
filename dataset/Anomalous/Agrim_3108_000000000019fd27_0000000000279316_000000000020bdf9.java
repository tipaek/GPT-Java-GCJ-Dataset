import java.util.*;

class Pair {
    int start;
    int end;

    Pair(int x, int y) {
        start = x;
        end = y;
    }
}

class TimeComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.start, p2.start);
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Pair[] times = new Pair[n];

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                times[j] = new Pair(startTime, endTime);
            }

            Arrays.sort(times, new TimeComparator());

            int cIndex = 0;
            int jIndex = -1;
            StringBuilder ans = new StringBuilder("C");
            String noAns = "IMPOSSIBLE";

            for (int j = 1; j < n; j++) {
                if (times[j].start < times[cIndex].end) {
                    if (jIndex == -1 || times[j].start >= times[jIndex].end) {
                        jIndex = j;
                        ans.append("J");
                    } else if (times[j].start < times[jIndex].end) {
                        break;
                    }
                } else {
                    cIndex = j;
                    ans.append("C");
                }
            }

            int caseNum = i + 1;

            if (ans.length() < n) {
                int cIndex2 = -1;
                int jIndex2 = 0;
                ans = new StringBuilder("J");

                for (int j = 1; j < n; j++) {
                    if (times[j].start < times[jIndex2].end) {
                        if (cIndex2 == -1 || times[j].start >= times[cIndex2].end) {
                            cIndex2 = j;
                            ans.append("C");
                        } else if (times[j].start < times[cIndex2].end) {
                            break;
                        }
                    } else {
                        jIndex2 = j;
                        ans.append("J");
                    }
                }
            }

            if (ans.length() < n) {
                System.out.println("Case #" + caseNum + ": " + noAns);
            } else {
                System.out.println("Case #" + caseNum + ": " + ans.toString());
            }
        }

        scanner.close();
    }
}
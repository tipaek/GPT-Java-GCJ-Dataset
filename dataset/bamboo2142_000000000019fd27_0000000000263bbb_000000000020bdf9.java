import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            //int[][] arr = new int[n][2];
            Interval[] arr = new Interval[n];
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                arr[i] = new Interval(start, end, i);
            }
            Arrays.sort(arr, new Comparator<Interval>() {
                @Override
                public int compare(Interval i1, Interval i2) {
                    if (i1.start == i2.start) {
                        return i1.end - i2.end;
                    }
                    return i1.start - i2.start;
                }
            });
            char[] res = new char[n];
            Map<Character, Integer> map = new HashMap<>();
            int currstart = arr[0].start;
            int currend = arr[0].end;
            map.put('C', currend);
            res[arr[0].index] = 'C';
            boolean possible = true;
            for (int i = 1; i < n; i++) {
                int start = arr[i].start;
                int end = arr[i].end;
                int cend = map.getOrDefault('C', -1);
                int jend = map.getOrDefault('J', -1);
                if (start < cend && start < jend) {
                    possible = false;
                    break;
                } else if (start >= cend) {
                    map.put('C', end);
                    //sb.append('C');
                    res[arr[i].index] = 'C';
                } else {
                    map.put('J', end);
                    //sb.append('J');
                    res[arr[i].index] = 'J';
                }
            }
            System.out.print("Case #" + t + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(res));
            }
        }
    }

    static class Interval {
        int start, end, index;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

}

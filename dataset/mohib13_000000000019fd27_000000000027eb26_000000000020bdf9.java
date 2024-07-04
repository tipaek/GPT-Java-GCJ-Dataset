import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        List<ArrayList<Integer>> originalIntervals;

        for (int i = 1; i <= t; ++i) {
            int intervalCount = in.nextInt();
            originalIntervals = new ArrayList<>();

            for (int interval = 0; interval < intervalCount; interval++) {
                int start = in.nextInt();
                int end = in.nextInt();

                originalIntervals.add(new ArrayList<>(Arrays.asList(start, end)));
            }
            List<ArrayList<Integer>> intervals = new ArrayList<>(originalIntervals);

            Integer[] indexes = new Integer[intervalCount];
            for (int x = 0; x < intervalCount; x++)
            {
                indexes[x] = x;
            }

            Arrays.sort(indexes, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return intervals.get(o1).get(0).compareTo(intervals.get(o2).get(0));
                }
            });

            intervals.sort((ArrayList<Integer> o1, ArrayList<Integer> o2) -> {
                        return o1.get(0) - o2.get(0);
                    }
            );

            int c = 0;
            int j = 0;

            StringBuilder ans = new StringBuilder();
            for(ArrayList<Integer> interval : originalIntervals) {
                ans.append(' ');
            }
            int x = 0;
            for (ArrayList<Integer> interval : intervals) {
                if (interval.get(0) >= c) {
                    ans.setCharAt(indexes[x++], 'C');
                    c = interval.get(1);
                } else if (interval.get(0) >= j) {
                    ans.setCharAt(indexes[x++], 'J');
                    j = interval.get(1);
                } else {
                    ans = new StringBuilder();
                    ans.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + ans);
        }
    }

    static int getIndexOf(int start, int end, List<ArrayList<Integer>> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).get(0) == start && intervals.get(i).get(1) == end) {
                return i;
            }
        }
        return -1;
    }
}

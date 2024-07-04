
import java.util.*;
import java.io.*;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] finalArray = new String[T];

        for (int i = 0; i < T; ++i) {

            int N = in.nextInt();
            StringBuilder scheduled = new StringBuilder();
            int freeTimeC = 0, freeTimeJ = 0;

            List<Tuple<Integer, Integer>> pairList = new ArrayList<>();
            int[] unSortedList = new int[N];

            for (int j = 0; j < N; ++j) {

                int S = in.nextInt();
                int E = in.nextInt();
                Tuple pair = new Tuple(S, E);
                unSortedList[j] = S;
                pairList.add(pair);
            }

            Collections.sort(pairList, new Comparator<Tuple<Integer, Integer>>() {
                @Override
                public int compare(final Tuple<Integer, Integer> o1, final Tuple<Integer, Integer> o2) {
                    return o1.getStart()- o2.getStart();
                }
            });

            for (int j = 0; j < N; ++j) {

                Tuple<Integer, Integer> pair = pairList.get(j);

                if (freeTimeC <= pair.getStart()) {

                    scheduled.append("C");
                    freeTimeC = pair.getEnd();
                } else if (freeTimeJ <= pair.getStart()) {

                    scheduled.append("J");
                    freeTimeJ = pair.getEnd();
                } else {

                    finalArray[i] = "IMPOSSIBLE";
                    scheduled = null;
                    break;
                }
            }

            if (scheduled != null) {

                StringBuilder scheduledFinal = new StringBuilder(unSortedList.length);

                for (int j = 0; j < N; ++j) {

                    for (int k = 0; k < N; k++) {

                        if (pairList.get(k).getStart() == unSortedList[j]) {

                            scheduledFinal.append(String.valueOf(scheduled.charAt(k)));
                            break;
                        }
                    }
                }

                finalArray[i] = scheduledFinal.toString();
            }
        }

        for (int i = 0; i < finalArray.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, finalArray[i]));
        }
    }

    private static class Tuple<X,Y> {

        private final X x;
        private final Y y;

        private Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        private int getStart() {
            return (Integer) x;
        }

        private int getEnd() {
            return (Integer) y;
        }
    }
}

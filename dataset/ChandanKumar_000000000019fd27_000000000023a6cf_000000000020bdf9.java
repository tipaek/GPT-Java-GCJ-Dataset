
import java.util.*;
import java.io.*;
import javafx.util.Pair;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        String[] finalArray = new String[T];

        for (int i = 0; i < T; ++i) {

            int N = in.nextInt();
            StringBuilder scheduled = new StringBuilder();
            int freeTimeC = 0, freeTimeJ = 0;

            List<Pair<Integer, Integer>> pairList = new ArrayList<>();
            int[] unSortedList = new int[N];

            for (int j = 0; j < N; ++j) {

                int S = in.nextInt();
                int E = in.nextInt();
                Pair pair = new Pair(S, E);
                unSortedList[j] = S;
                pairList.add(pair);
            }

            Collections.sort(pairList, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {
                    return o1.getKey() - o2.getKey();
                }
            });

            for (int j = 0; j < N; ++j) {

                Pair<Integer, Integer> pair = pairList.get(j);

                if (freeTimeC <= pair.getKey()) {

                    scheduled.append("C");
                    freeTimeC = pair.getValue();
                } else if (freeTimeJ <= pair.getValue()) {

                    scheduled.append("J");
                    freeTimeJ = pair.getValue();
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

                        if (pairList.get(k).getKey() == unSortedList[j]) {

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
}

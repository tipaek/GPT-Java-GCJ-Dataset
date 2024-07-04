import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pair {
        int v1;
        int v2;

        Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    static class QInfo {
        List<Pair> cardList;
        List<Pair> ansList;

        QInfo(List<Pair> cardList, List<Pair> ansList) {
            this.cardList = cardList;
            this.ansList = ansList;
        }
    }

    private static int getLastIdx(List<Pair> cardList, int R, int S) {

        int[] chk = new int [R + 2];

        chk[R + 1] = S;

        for (int idx = cardList.size() - 1; idx >= 0; --idx) {
            if (chk[cardList.get(idx).v1 + 1] != S) {
                return idx;
            }

            ++chk[cardList.get(idx).v1];
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int test = 1; test <= T; ++test) {

            int r = in.nextInt();
            int s = in.nextInt();

            List<Pair> initList = new ArrayList<>();

            for (int idx1 = 1 ; idx1 <= s; ++idx1) {
                for (int idx2 = 1; idx2 <= r; ++idx2) {
                    initList.add(new Pair(idx2, idx1));
                }
            }

            Queue<QInfo> queue = new LinkedList<>();

            queue.add(new QInfo(initList, new ArrayList<>()));

            while (!queue.isEmpty()) {

                QInfo cur = queue.poll();
                int lastIdx = getLastIdx(cur.cardList, r, s);

                if (lastIdx == 0) {
                    System.out.println("Case #" + test + ": " + cur.ansList.size());

                    for (Pair ans : cur.ansList) {
                        System.out.println(ans.v1 + " " + ans.v2);
                    }

                    break;
                }

                int a = lastIdx;
                int b = 1;

                while (a > 0) {
                    List<Pair> newCardList = new ArrayList<>();
                    List<Pair> newAnsList = new ArrayList<>(cur.ansList);

                    for (int idx = a; idx <= lastIdx; ++idx) {
                        newCardList.add(cur.cardList.get(idx));
                    }
                    for (int idx = 0; idx < a; ++idx) {
                        newCardList.add(cur.cardList.get(idx));
                    }
                    for (int idx = lastIdx + 1; idx < cur.cardList.size(); ++idx) {
                        newCardList.add(cur.cardList.get(idx));
                    }

                    newAnsList.add(new Pair(a, b));

                    queue.add(new QInfo(newCardList, newAnsList));

                    --a;
                    ++b;
                }
            }
        }
    }
}

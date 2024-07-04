import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNum = in.nextInt();

        for (int caseIndex = 1; caseIndex <= caseNum; caseIndex++) {
            int maxValue = in.nextInt();
            int cycleNum = in.nextInt();
            int n = cycleNum * maxValue;
            ArrayList<Integer> list = new ArrayList<>(n);

            for (int i = 1; i <= cycleNum; i++) {
                for (int j = 1; j <= maxValue; j++) {
                    list.add(j);
                }
            }

            List<Sizes> sizes = new ArrayList<>();
            
            int curOrdering = maxValue;
            int ordered = 0;
            for (int i = n - 1; i >= 0; ) {

                if (ordered >= cycleNum) {
                    curOrdering--;
                    ordered = 0;
                }

                if (list.get(i) == curOrdering) {
                    ordered++;
                    i--;
                    continue;
                }

                int end = i;
                int start = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (list.get(j) == curOrdering) {
                        start = j;
                        break;
                    }
                }
                ArrayList<Integer> newList = new ArrayList<>(n);
                newList.addAll(list.subList(start + 1, end + 1));
                newList.addAll(list.subList(0, start + 1));
                newList.addAll(list.subList(end + 1, n));
                list = newList;

                sizes.add(new Sizes(start + 1, end - start));
            }

            System.out.println(String.format("Case #%s: %s", caseIndex, sizes.size()));
            sizes.forEach(s -> System.out.println(s.a + " " + s.b));
        }
    }

    private static class Sizes {
        long a;
        long b;

        public Sizes(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
    }

}
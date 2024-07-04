import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int r = in.nextInt();
            int s = in.nextInt();
            List<Pair> pairs = new ArrayList<>();
            for (int i = 1; i <= s; i++) {
                for (int j = 1; j <= r; j++) {
                    pairs.add(new Pair(j, i));
                }
            }
            int actualR = r;
            int count = 0;
            List<String> lines = new ArrayList<>();
            while (!isSorted(pairs)) {
                String line = "";
                if (count == s) {
                    actualR--;
                    count = 0;
                }
                List<Pair> deckA = new ArrayList<>();
                List<Pair> deckB = new ArrayList<>();
                List<Pair> deckC = new ArrayList<>();
                int position = 0;
                Pair lastPair = null;
                for (position = 0; position < pairs.size(); position++) {
                    Pair pair = pairs.get(position);
                    if (lastPair != null && lastPair.r > pair.r) {
                        actualR = lastPair.r;
                        break;
                    }
                    lastPair = pair;
                    deckA.add(pair);
                }
                line += deckA.size();
                for (; position < pairs.size(); position++) {
                    Pair pair = pairs.get(position);
                    deckB.add(pair);
                    if (pair.r == actualR - 1) {
                        break;
                    }
                }
                position++;
                line += " " + deckB.size();
                for (; position < pairs.size(); position++) {
                    Pair pair = pairs.get(position);
                    deckC.add(pair);
                    if (pair.r == actualR - 1) {
                        break;
                    }
                }
                pairs = new ArrayList<>();
                pairs.addAll(deckB);
                pairs.addAll(deckA);
                pairs.addAll(deckC);
                lines.add(line);
                count++;
            }
            System.out.println("Case #" + c + ": " + lines.size());
            for (String line : lines) {
                System.out.println(line);
            }
        }
    }

    private static boolean isSorted(List<Pair> pairs) {
        Pair lastPair = null;
        for (Pair p : pairs) {
            if (lastPair != null && lastPair.r > p.r) {
                return false;
            }
            lastPair = p;
        }
        return true;
    }

    static class Pair {

        int r, s;

        Pair(int r, int s) {
            this.r = r;
            this.s = s;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return "r=" + r + ", s=" +s;
        }

    }

}

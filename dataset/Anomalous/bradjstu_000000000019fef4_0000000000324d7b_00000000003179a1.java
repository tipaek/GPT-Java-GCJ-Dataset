import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++) {
            runTestCase(i, in);
        }
    }

    private static void runTestCase(int testCaseNumber, Scanner in) {
        int u = in.nextInt();
        QRPair[] pairs = new QRPair[10000];
        for (int i = 0; i < 10000; i++) {
            long q = in.nextLong();
            String r = in.next();
            pairs[i] = new QRPair(q, r);
        }
        String d = statsApproach(pairs, u);
        outputTestCase(testCaseNumber, d);
    }

    private static String statsApproach(QRPair[] pairs, int u) {
        int[] nums = new int[200];
        int[] others = new int[200];

        for (QRPair pair : pairs) {
            if (pair.result.length() == u) {
                char firstLetter = pair.result.charAt(0);
                char secondLetter = pair.result.charAt(1);
                nums[firstLetter]++;
                others[secondLetter]++;
            }
        }

        List<Rank> ranks = new ArrayList<>();
        List<Rank> ranks2 = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            if (nums[i] > 0) {
                ranks.add(new Rank(nums[i], i));
            }
            if (others[i] > 0) {
                ranks2.add(new Rank(others[i], i));
            }
        }

        ranks.sort(Comparator.comparingInt(Rank::getTally).reversed());

        StringBuilder x = new StringBuilder();
        for (Rank rank2 : ranks2) {
            boolean isPresent = ranks.stream().anyMatch(rank -> rank.value == rank2.value);
            if (!isPresent) {
                x.append((char) rank2.value);
            }
        }

        for (Rank rank : ranks) {
            x.append((char) rank.value);
        }

        return x.toString();
    }

    public static class Rank {
        int tally;
        int value;

        Rank(int tally, int value) {
            this.tally = tally;
            this.value = value;
        }

        public int getTally() {
            return tally;
        }
    }

    public static class QRPair {
        public long query;
        public String result;

        QRPair(long query, String result) {
            this.query = query;
            this.result = result;
        }
    }

    private static void outputTestCase(int testCaseNumber, String outString) {
        System.out.println("Case #" + testCaseNumber + ": " + outString);
    }
}